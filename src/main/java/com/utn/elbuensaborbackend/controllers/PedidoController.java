package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.Pedido;
import com.utn.elbuensaborbackend.services.PedidoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {
}
