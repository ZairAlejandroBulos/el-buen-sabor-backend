package com.utn.elbuensaborbackend.services.interfaces;


import com.utn.elbuensaborbackend.dtos.DomicilioDTO;
import com.utn.elbuensaborbackend.entities.Domicilio;

public interface DomicilioService extends BaseService<Domicilio, DomicilioDTO, Long> {
    Domicilio saveDomicilio(DomicilioDTO dto) throws Exception;
    Domicilio updateDomicilio(Long id, DomicilioDTO dto) throws Exception;
}