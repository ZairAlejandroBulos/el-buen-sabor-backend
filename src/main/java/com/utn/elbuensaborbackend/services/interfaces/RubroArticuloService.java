package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.entities.RubroArticulo;

import java.util.List;

public interface RubroArticuloService extends BaseService<RubroArticulo, Long> {
    List<RubroArticulo> findAllParents() throws Exception;
}
