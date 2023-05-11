package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import com.utn.elbuensaborbackend.repositories.ArticuloManufacturadoRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long>
        implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }
}
