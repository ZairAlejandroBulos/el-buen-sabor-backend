package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.DetallePedido;
import com.utn.elbuensaborbackend.services.DetallePedidoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/detalles-pedidos")
public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoServiceImpl> {
}
