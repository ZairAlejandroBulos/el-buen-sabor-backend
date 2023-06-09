package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.dtos.RubroDTO;
import com.utn.elbuensaborbackend.entities.Rubro;

import java.util.List;

public interface RubroService extends BaseService<Rubro, RubroDTO, Long> {
    List<RubroDTO> findAllParents() throws Exception;
    Rubro saveRubro(RubroDTO dto) throws Exception;
    Rubro updateRubro(Long id, RubroDTO dto) throws Exception;
}
