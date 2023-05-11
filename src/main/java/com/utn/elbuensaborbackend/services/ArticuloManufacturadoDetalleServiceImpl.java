package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoDetalle;
import com.utn.elbuensaborbackend.repositories.ArticuloManufacturadoDetalleRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoDetalleServiceImpl extends BaseServiceImpl<ArticuloManufacturadoDetalle, Long>
        implements ArticuloManufacturadoDetalleService {

    @Autowired
    private ArticuloManufacturadoDetalleRepository articuloManufacturadoDetalleRepository;

    public ArticuloManufacturadoDetalleServiceImpl(BaseRepository<ArticuloManufacturadoDetalle, Long> baseRepository) {
        super(baseRepository);
    }
}
