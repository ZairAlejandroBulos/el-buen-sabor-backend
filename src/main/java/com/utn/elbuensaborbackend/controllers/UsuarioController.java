package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.Usuario;
import com.utn.elbuensaborbackend.services.UsuarioServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {
}
