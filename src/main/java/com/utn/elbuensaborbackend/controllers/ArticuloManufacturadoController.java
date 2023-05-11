package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import com.utn.elbuensaborbackend.services.ArticuloManufacturadoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/articulos-manufacturados")
public class ArticuloManufacturadoController
        extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl> {
}
