package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.*;
import com.utn.elbuensaborbackend.entities.Cliente;
import com.utn.elbuensaborbackend.mappers.ClienteMapper;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.ClienteRepository;
import com.utn.elbuensaborbackend.services.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<ClienteDTO> findAllClientesByRoleId(Long rolId) throws Exception {
        try{
            List<Cliente> clientes = clienteRepository.findAllCustomersWithDifferentRoleId(rolId);
            return clienteMapper.toDTOsList(clientes);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
