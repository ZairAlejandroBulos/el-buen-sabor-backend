package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.dtos.UsuarioDTO;
import com.utn.elbuensaborbackend.entities.Usuario;
import com.utn.elbuensaborbackend.services.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioDTO> {

    @Autowired
    private UsuarioService service;
}
