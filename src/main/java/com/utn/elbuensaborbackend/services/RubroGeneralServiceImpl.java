package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.RubroGeneral;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.RubroGeneralRepository;
import com.utn.elbuensaborbackend.services.interfaces.RubroGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroGeneralServiceImpl extends BaseServiceImpl<RubroGeneral, Long> implements RubroGeneralService {

    @Autowired
    private RubroGeneralRepository rubroGeneralRepository;

    public RubroGeneralServiceImpl(BaseRepository<RubroGeneral, Long> baseRepository) {
        super(baseRepository);
    }
}
