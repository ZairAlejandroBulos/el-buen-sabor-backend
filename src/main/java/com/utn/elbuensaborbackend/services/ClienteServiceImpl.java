package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.ClienteDTO;
import com.utn.elbuensaborbackend.entities.Cliente;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.mappers.ClienteMapper;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.ClienteRepository;
import com.utn.elbuensaborbackend.services.interfaces.ClienteService;
import com.utn.elbuensaborbackend.services.interfaces.DomicilioService;
import com.utn.elbuensaborbackend.services.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, ClienteDTO, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DomicilioService domicilioService;

    private final ClienteMapper clienteMapper = ClienteMapper.getInstance();

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, BaseMapper<Cliente, ClienteDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Override
    public List<ClienteDTO> findAllClientesByRoles(List<String> roles) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.findAllClientesByRoles(roles);
            return clienteMapper.toDTOsList(clientes);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> findAllClientesByName(String nombre) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.findAllClientesByName(nombre);
            return clienteMapper.toDTOsList(clientes);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> findAllClientesByApellido(String apellido) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.findAllClientesByApellido(apellido);
            return clienteMapper.toDTOsList(clientes);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> findAllClientesByNameAndApellido(String nombre, String apellido) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.findAllClientesByNameAndApellido(nombre, apellido);
            return clienteMapper.toDTOsList(clientes);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}