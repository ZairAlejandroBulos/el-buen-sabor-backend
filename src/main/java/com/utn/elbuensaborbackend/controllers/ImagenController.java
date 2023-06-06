package com.utn.elbuensaborbackend.controllers;

/*
import com.utn.elbuensaborbackend.entities.Imagen;
import com.utn.elbuensaborbackend.services.ImagenServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/imagenes")
public class ImagenController extends BaseControllerImpl<Imagen, ImagenServiceImpl> {

    @GetMapping("/byName/{nombre}")
    public ResponseEntity<?> getImagenByName(@PathVariable String nombre) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(service.findImagenByName(nombre));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error al recuperar la imagen\"}");
        }
    }

    @PostMapping("/{nombre}")
    public ResponseEntity<?> saveImagen(@RequestParam("file") MultipartFile file, @PathVariable String nombre) {
        try {
            service.saveImage(file, nombre);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error al guardar la imagen\"}");
        }
    }
}
*/