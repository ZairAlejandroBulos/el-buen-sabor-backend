package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.dtos.RubroDTO;
import com.utn.elbuensaborbackend.entities.Rubro;

import java.util.List;

public interface RubroService extends BaseService<Rubro, RubroDTO, Long> {

    List<RubroDTO> findDesbloqueados() throws Exception;
    Boolean existsByDenominacion(String denominacion) throws Exception;
    void bloquearDesbloquear(Long id) throws Exception;
}
