package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.dtos.RubroDTO;
import com.utn.elbuensaborbackend.entities.Rubro;
import com.utn.elbuensaborbackend.services.interfaces.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rubros")
public class RubroController extends BaseControllerImpl<Rubro, RubroDTO> {

    @Autowired
    private RubroService service;

    @GetMapping("/desbloqueados")
    public ResponseEntity<?> getDesbloqueados() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findDesbloqueados());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @GetMapping("/byTipo/{bool}")
    public ResponseEntity<?> getByTipo(@PathVariable Boolean bool) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findByTipo(bool));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @GetMapping("/exists/{denominacion}")
    public ResponseEntity<?> existsByDenominacion(@PathVariable String denominacion) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.existsByDenominacion(denominacion));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @DeleteMapping("/bloquear-desbloquear/{id}")
    public ResponseEntity<?> bloquearDesbloquear(@PathVariable Long id) {
        try {
            service.bloquearDesbloquear(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
