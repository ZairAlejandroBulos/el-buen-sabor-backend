package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.dtos.ClienteDTO;
import com.utn.elbuensaborbackend.entities.Cliente;
import com.utn.elbuensaborbackend.services.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteDTO> {

    @Autowired
    private ClienteService service;

    @GetMapping("/rolEmpleados")
    public ResponseEntity<?> getAllEmpleados() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllEmpleados());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @GetMapping("/rolClientes")
    public ResponseEntity<?> getAllClientes() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllClientes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @GetMapping("/byAuth0Id")
    public ResponseEntity<?> getClienteByUsuarioAuth0Id(@RequestParam String auth0Id) {
        try {
            auth0Id = URLDecoder.decode(auth0Id, StandardCharsets.UTF_8);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findClienteByUsuarioAuth0Id(auth0Id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PutMapping("/cambiarEstado/{id}")
    public ResponseEntity<?> updateEstadoCliente(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.updateEstado(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
