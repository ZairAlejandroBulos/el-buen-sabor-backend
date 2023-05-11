package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.RubroArticulo;
import com.utn.elbuensaborbackend.services.RubroArticuloServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/rubros-articulos")
public class RubroArticuloController extends BaseControllerImpl<RubroArticulo, RubroArticuloServiceImpl> {
}
