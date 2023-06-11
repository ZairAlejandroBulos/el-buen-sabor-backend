package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.dtos.RubroDTO;
import com.utn.elbuensaborbackend.entities.Rubro;

public interface RubroService extends BaseService<Rubro, RubroDTO, Long> {

    Boolean existsByDenominacion(String denominacion) throws Exception;
    Rubro saveRubro(RubroDTO dto) throws Exception;
    Rubro updateRubro(Long id, RubroDTO dto) throws Exception;
}
