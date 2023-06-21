package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoFullDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumo;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/articulos-insumos")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoFullDTO> {

    @Autowired
    private ArticuloInsumoService service;
}
