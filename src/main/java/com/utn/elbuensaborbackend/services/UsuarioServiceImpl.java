package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.RolDTO;
import com.utn.elbuensaborbackend.dtos.UsuarioDTO;
import com.utn.elbuensaborbackend.entities.Rol;
import com.utn.elbuensaborbackend.entities.Usuario;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.mappers.UsuarioMapper;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.UsuarioRepository;
import com.utn.elbuensaborbackend.services.interfaces.RolService;
import com.utn.elbuensaborbackend.services.interfaces.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, UsuarioDTO, Long> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolService rolService;

    private UsuarioMapper usuarioMapper = UsuarioMapper.getInstance();

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository, BaseMapper<Usuario, UsuarioDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

}
