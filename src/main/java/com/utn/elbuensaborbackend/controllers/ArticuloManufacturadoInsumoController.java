package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoInsumo;
import com.utn.elbuensaborbackend.services.ArticuloManufacturadoInsumoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/articulos-manufacturados-insumos")
public class ArticuloManufacturadoInsumoController
        extends BaseControllerImpl<ArticuloManufacturadoInsumo, ArticuloManufacturadoInsumoServiceImpl> {

    @GetMapping("/byArticuloManufacturado/{id}")
    public ResponseEntity<?> getByArticuloManufacturadoId(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findByArticuloManufacturadoId(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
