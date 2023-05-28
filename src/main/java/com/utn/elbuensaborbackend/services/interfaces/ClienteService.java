package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.dtos.ClienteDTO;
import com.utn.elbuensaborbackend.entities.Cliente;

import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long> {
    List<ClienteDTO> findAllClientesByRoleId(Long rolId) throws Exception;
}
