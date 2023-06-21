package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoFullDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articulos-manufacturados")
public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoFullDTO> {

    @Autowired
    private ArticuloManufacturadoService service;

    @GetMapping("/simple")
    public ResponseEntity<?> getAllSimple() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllSimple());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @GetMapping("/simple/{id}")
    public ResponseEntity<?> getSimpleById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findSimpleById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @GetMapping("/byTermino/{termino}")
    public ResponseEntity<?> getByTermino(@PathVariable String termino) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findByTermino(termino));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
