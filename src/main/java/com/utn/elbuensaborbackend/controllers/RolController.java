package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.dtos.RolDTO;
import com.utn.elbuensaborbackend.entities.Rol;
import com.utn.elbuensaborbackend.services.interfaces.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/roles")
public class RolController extends BaseControllerImpl<Rol, RolDTO> {

    @Autowired
    private RolService service;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody RolDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.save(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RolDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.update(id, dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
