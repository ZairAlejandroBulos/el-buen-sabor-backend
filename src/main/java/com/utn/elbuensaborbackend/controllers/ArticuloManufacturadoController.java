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

    @GetMapping("/findAll")
    public ResponseEntity<?> getAllArticuloManufacturado(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllArticuloManufacturado());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> getArticuloManufacturadoById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findArticuloManufacturadoById(id));
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

    @GetMapping("/findAllFull")
    public ResponseEntity<?> getAllArticuloManufacturadoFull(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllArticuloManufacturadoFull());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @GetMapping("/full/byId/{id}")
    public ResponseEntity<?> getArticuloManufacturadoFullById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findArticuloManufacturadoFullById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ArticuloManufacturadoFullDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.saveArticuloManufacturado(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ArticuloManufacturadoFullDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.updateArticuloManufacturado(id, dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
