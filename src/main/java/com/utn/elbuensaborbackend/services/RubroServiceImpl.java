package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.Rubro;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.RubroRepository;
import com.utn.elbuensaborbackend.services.interfaces.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroServiceImpl extends BaseServiceImpl<Rubro, Long> implements RubroService {

    @Autowired
    private RubroRepository rubroRepository;

    public RubroServiceImpl(BaseRepository<Rubro, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Rubro> findAllParents() throws Exception {
        try {
            return rubroRepository.findAllParents();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
