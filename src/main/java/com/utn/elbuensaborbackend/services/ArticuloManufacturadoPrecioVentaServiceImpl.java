package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoPrecioVentaDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoPrecioVenta;
import com.utn.elbuensaborbackend.mappers.ArticuloManufacturadoPrecioVentaMapper;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.repositories.ArticuloManufacturadoPrecioVentaRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoPrecioVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloManufacturadoPrecioVentaServiceImpl
        extends BaseServiceImpl<ArticuloManufacturadoPrecioVenta, ArticuloManufacturadoPrecioVentaDTO, Long>
        implements ArticuloManufacturadoPrecioVentaService {

    @Autowired
    private ArticuloManufacturadoPrecioVentaRepository articuloManufacturadoPrecioVentaRepository;

    private final ArticuloManufacturadoPrecioVentaMapper articuloManufacturadoPrecioVentaMapper
            = ArticuloManufacturadoPrecioVentaMapper.getInstance();


    public ArticuloManufacturadoPrecioVentaServiceImpl(
            BaseRepository<ArticuloManufacturadoPrecioVenta, Long> baseRepository,
            BaseMapper<ArticuloManufacturadoPrecioVenta, ArticuloManufacturadoPrecioVentaDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
