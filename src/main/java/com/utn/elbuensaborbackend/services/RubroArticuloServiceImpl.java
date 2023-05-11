package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.RubroArticulo;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.RubroArticuloRepository;
import com.utn.elbuensaborbackend.services.interfaces.RubroArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long> implements RubroArticuloService {

    @Autowired
    private RubroArticuloRepository rubroArticuloRepository;

    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository) {
        super(baseRepository);
    }
}
