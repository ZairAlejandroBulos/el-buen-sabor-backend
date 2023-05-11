package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.MercadoPagoDatos;
import com.utn.elbuensaborbackend.services.MercadoPagoDatosServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mercado-pago-datos")
public class MercadoPagoDatosController extends BaseControllerImpl<MercadoPagoDatos, MercadoPagoDatosServiceImpl> {
}
