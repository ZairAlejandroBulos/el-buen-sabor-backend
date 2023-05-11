package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoDetalle;
import com.utn.elbuensaborbackend.services.ArticuloManufacturadoDetalleServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/articulos-manufacturados-detalles")
public class ArticuloManufacturadoDetalleController
        extends BaseControllerImpl<ArticuloManufacturadoDetalle, ArticuloManufacturadoDetalleServiceImpl> {
}
