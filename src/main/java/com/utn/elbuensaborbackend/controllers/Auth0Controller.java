package com.utn.elbuensaborbackend.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.shaded.gson.JsonArray;
import com.nimbusds.jose.shaded.gson.JsonObject;
import com.squareup.okhttp.*;
import com.squareup.okhttp.RequestBody;
import com.utn.elbuensaborbackend.dtos.Auth0UsuarioDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/api/v1/auth0")
public class Auth0Controller {

    @Value("${AUTH0_DOMAIN}")
    private String domain;

    @Value("${AUTH0_API_CLIENT_ID}")
    private String apiClientID;

    @Value("${AUTH0_API_CLIENT_SECRET}")
    private String apiClientSecret;

    @Value("${AUTH0_API_AUDIENCE}")
    private String apiAudience;

    @GetMapping("/roles/byUsuarioId/{id}")
    public List<Auth0RolDTO> getAuth0RolesByUsuarioId(@PathVariable String id) {
        try {
            String token = getTokenAPI();
            String encodedUsuarioId = URLEncoder.encode(id, StandardCharsets.UTF_8).replace("|", "%7C");
            String url = "https://" + domain + "/api/v2/users/" + encodedUsuarioId + "/roles";

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Bearer " + token)
                    .get()
                    .build();
            Response response = new OkHttpClient().newCall(request).execute();
            String responseBody = response.body().string();

            ObjectMapper objectMapper = new ObjectMapper();
            Auth0RolDTO[] roles = objectMapper.readValue(responseBody, Auth0RolDTO[].class);

            return Arrays.asList(roles);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @GetMapping("/usuarios/logingsById/{id}")
    public String getLoginsByUsuarioId(@PathVariable String id) {
        try {
            String token = getTokenAPI();
            String encodedUsuarioId = URLEncoder.encode(id, StandardCharsets.UTF_8).replace("|", "%7C");
            String url = "https://" + domain + "/api/v2/users/" + encodedUsuarioId + "?fields=logins_count";

            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            Response response = new OkHttpClient().newCall(request).execute();
            String responseBody = response.body().string();

            JsonNode jsonNode = new ObjectMapper().readTree(responseBody);
            Integer logins = jsonNode.get("logins_count").asInt();

            return logins.toString();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/token")
    public String getTokenAPI() {
        try {
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            String body = "grant_type=client_credentials&client_id=" + apiClientID +
                    "&client_secret=" + apiClientSecret +
                    "&audience=" + apiAudience;
            RequestBody requestBody = RequestBody.create(mediaType, body);

            Request request = new Request.Builder()
                    .url("https://" + domain + "/oauth/token")
                    .post(requestBody)
                    .addHeader("content-type", "application/x-www-form-urlencoded")
                    .build();
            Response response = new OkHttpClient().newCall(request).execute();
            String responseBody = response.body().string();

            JsonNode jsonNode = new ObjectMapper().readTree(responseBody);
            String token = jsonNode.get("access_token").asText();

            return token;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> saveUsuario(@org.springframework.web.bind.annotation.RequestBody Auth0UsuarioDTO dto) {
        try {
            String token = getTokenAPI();
            String url = "https://" + domain + "/api/v2/users";

            JsonObject appMetadata = new JsonObject();
            appMetadata.addProperty("isManualCreation", true);

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("connection", "Username-Password-Authentication");
            jsonObject.addProperty("email", dto.getEmail());
            jsonObject.addProperty("password", dto.getClave());
            jsonObject.addProperty("blocked", dto.getBloqueado());
            jsonObject.add("app_metadata", appMetadata);

            RequestBody requestBody = RequestBody.create(
                    MediaType.parse("application/json"),
                    jsonObject.toString()
            );
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .addHeader("Authorization", "Bearer " + token)
                    .build();

            Response response = new OkHttpClient().newCall(request).execute();
            String responseBody = response.body().string();
            HttpStatus status = HttpStatus.valueOf(response.code());

            return ResponseEntity.status(status).body(responseBody);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PostMapping("usuarios/saveRol/{id}")
    public ResponseEntity<?> asignarUsuarioARol(
            @PathVariable String id,
            @org.springframework.web.bind.annotation.RequestBody Map<String, List<String>> body) {
        try {
            String token = getTokenAPI();
            String url = "https://" + domain + "/api/v2/roles/" + id + "/users";

            List<String> usuarios = body.get("usuarios");

            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (String usuario : usuarios) {
                jsonArray.add(usuario);
            }
            jsonObject.add("users", jsonArray);

            RequestBody requestBody = RequestBody.create(
                    MediaType.parse("application/json"),
                    jsonObject.toString()
            );
            Request request = new Request.Builder()
                    .url(url)
                    .header("Authorization", "Bearer " + token)
                    .header("Content-Type", "application/json")
                    .post(requestBody)
                    .build();

            Response response = new OkHttpClient().newCall(request).execute();
            String responseBody = response.body().string();
            HttpStatus status = HttpStatus.valueOf(response.code());

            return ResponseEntity.status(status).body(responseBody);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PatchMapping("/usuarios/cambiarEstado/{id}")
    public ResponseEntity<?> updateEstadoUsuario(
            @PathVariable String id,
            @org.springframework.web.bind.annotation.RequestBody Map<String, Object> body) {
        try {
            String token = getTokenAPI();
            String encodedUsuarioId = URLEncoder.encode(id, StandardCharsets.UTF_8).replace("|", "%7C");
            String url = "https://" + domain + "/api/v2/users/" + encodedUsuarioId;

            Boolean bloqueado = (boolean) body.get("bloqueado");

            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("blocked", bloqueado);

            RequestBody requestBody = RequestBody.create(
                    MediaType.parse("application/json"),
                    jsonObject.toString()
            );
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Bearer " + token)
                    .addHeader("Content-Type", "application/json")
                    .patch(requestBody)
                    .build();

            Response response = new OkHttpClient().newCall(request).execute();
            String responseBody = response.body().string();
            HttpStatus status = HttpStatus.valueOf(response.code());

            return ResponseEntity.status(status).body(responseBody);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PatchMapping("/usuarios/cambiarClave/{id}")
    public ResponseEntity<?> updateClaveUsuario(
            @PathVariable String id,
            @org.springframework.web.bind.annotation.RequestBody Map<String, Object> body) {
        try {
            String token = getTokenAPI();
            String encodedUsuarioId = URLEncoder.encode(id, StandardCharsets.UTF_8).replace("|", "%7C");
            String url = "https://" + domain + "/api/v2/users/" + encodedUsuarioId;

            String clave = (String) body.get("clave");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("password", clave);

            RequestBody requestBody = RequestBody.create(
                    MediaType.parse("application/json"),
                    jsonObject.toString()
            );
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Bearer " + token)
                    .addHeader("Content-Type", "application/json")
                    .patch(requestBody)
                    .build();

            Response response = new OkHttpClient().newCall(request).execute();
            String responseBody = response.body().string();
            HttpStatus status = HttpStatus.valueOf(response.code());

            return ResponseEntity.status(status).body(responseBody);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @DeleteMapping("/usuarios/deleteRoles/{id}")
    public ResponseEntity<?> deleteRolesFromUsuario(
            @PathVariable String id,
            @org.springframework.web.bind.annotation.RequestBody Map<String, List<String>> body) {
        try {
            String token = getTokenAPI();
            String encodedUsuarioId = URLEncoder.encode(id, StandardCharsets.UTF_8).replace("|", "%7C");
            String url = "https://" + domain + "/api/v2/users/" + encodedUsuarioId + "/roles";

            List<String> roles = body.get("roles");

            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (String rol : roles) {
                jsonArray.add(rol);
            }
            jsonObject.add("roles", jsonArray);

            RequestBody requestBody = RequestBody.create(
                    MediaType.parse("application/json"),
                    jsonObject.toString()
            );
            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("Authorization", "Bearer " + token)
                    .delete(requestBody)
                    .build();

            Response response = new OkHttpClient().newCall(request).execute();
            String responseBody = response.body().string();
            HttpStatus status = HttpStatus.valueOf(response.code());

            return ResponseEntity.status(status).body(responseBody);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
