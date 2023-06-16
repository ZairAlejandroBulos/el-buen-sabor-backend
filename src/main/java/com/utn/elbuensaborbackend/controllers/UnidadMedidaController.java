package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.dtos.UnidadMedidaDTO;
import com.utn.elbuensaborbackend.entities.UnidadMedida;
import com.utn.elbuensaborbackend.services.interfaces.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/unidad-medida")
public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaDTO> {

    @Autowired
    private UnidadMedidaService service;

    @GetMapping("/exists/{denominacion}")
    public ResponseEntity<?> existsByDenominacion(@PathVariable String denominacion) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.existsByDenominacionUnidadMedida(denominacion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody UnidadMedidaDTO entity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UnidadMedidaDTO entity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
