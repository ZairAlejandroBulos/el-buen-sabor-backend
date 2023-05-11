package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.Factura;
import com.utn.elbuensaborbackend.services.FacturaServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl> {
}
