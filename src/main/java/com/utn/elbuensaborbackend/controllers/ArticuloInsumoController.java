package com.utn.elbuensaborbackend.controllers;


import com.utn.elbuensaborbackend.dtos.ArticuloInsumoFullDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumo;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articulos-insumos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoFullDTO> {

    @Autowired
    private ArticuloInsumoService service;

    @GetMapping("/findAllFull")
    public ResponseEntity<?> getAllArticuloInsumoFull(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAllArticuloInsumoFull());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @GetMapping("/full/byId/{id}")
    public ResponseEntity<?> getArticuloInsumoFullById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findArticuloInsumoFullById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ArticuloInsumoFullDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.saveArticuloInsumo(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ArticuloInsumoFullDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.updateArticuloInsumo(id, dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"Ocurrio un error\"}");
        }
    }
}
