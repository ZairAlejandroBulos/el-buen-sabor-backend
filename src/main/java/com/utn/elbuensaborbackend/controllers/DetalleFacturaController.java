package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.DetalleFactura;
import com.utn.elbuensaborbackend.services.DetalleFacturaServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/detalles-facturas")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura, DetalleFacturaServiceImpl> {
}
