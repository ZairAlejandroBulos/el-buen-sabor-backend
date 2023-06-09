package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.dtos.UsuarioDTO;
import com.utn.elbuensaborbackend.entities.Usuario;


public interface UsuarioService extends BaseService<Usuario, UsuarioDTO, Long> {
    Usuario saveUsuario(UsuarioDTO dto) throws Exception;
    Usuario updateUsuario(Long id, UsuarioDTO dto) throws Exception;
}