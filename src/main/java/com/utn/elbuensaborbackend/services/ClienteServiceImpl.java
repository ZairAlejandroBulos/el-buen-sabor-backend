package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.Cliente;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.ClienteRepository;
import com.utn.elbuensaborbackend.services.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

}
