package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.ArticuloInsumo;
import com.utn.elbuensaborbackend.repositories.ArticuloInsumoRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository) {
        super(baseRepository);
    }
}
