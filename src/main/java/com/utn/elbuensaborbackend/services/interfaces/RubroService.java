package com.utn.elbuensaborbackend.services.interfaces;


import com.utn.elbuensaborbackend.dtos.RubroDTO;
import com.utn.elbuensaborbackend.entities.Rubro;
import java.util.List;

public interface RubroService {

    List<RubroDTO> findAll() throws Exception;

    List<RubroDTO> findAllParents() throws Exception;

    RubroDTO findById(Long id) throws Exception;

    Rubro save(RubroDTO entity) throws Exception;

    Rubro update(Long id, RubroDTO entity) throws Exception;

    void delete(Long id) throws Exception;
}
