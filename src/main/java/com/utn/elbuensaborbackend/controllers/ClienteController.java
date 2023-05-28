package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.Cliente;
import com.utn.elbuensaborbackend.services.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {

    @GetMapping("/byRol/{rolId}")
    public ResponseEntity<?> findAllCustomersWithDifferentRoleId(@PathVariable Long rolId) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllClientesByRoleId(rolId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
