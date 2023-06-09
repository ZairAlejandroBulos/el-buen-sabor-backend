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

    @GetMapping("/parents")
    public ResponseEntity<?> getAllParents() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllParents());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody RubroDTO entity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.saveRubro(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RubroDTO entity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.updateRubro(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

}
