package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteRepository extends BaseRepository<Cliente, Long> {
}
