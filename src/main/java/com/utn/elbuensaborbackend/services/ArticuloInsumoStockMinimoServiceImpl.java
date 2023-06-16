package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoStockMinimoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoStockMinimo;
import com.utn.elbuensaborbackend.mappers.ArticuloInsumoStockMinimoMapper;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.repositories.ArticuloInsumoStockMinimoRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloInsumoStockMinimoService;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticuloInsumoStockMinimoServiceImpl
        extends BaseServiceImpl<ArticuloInsumoStockMinimo, ArticuloInsumoStockMinimoDTO, Long>
        implements ArticuloInsumoStockMinimoService {

    @Autowired
    private ArticuloInsumoStockMinimoRepository articuloInsumoStockMinimoRepository;

    private final ArticuloInsumoStockMinimoMapper articuloInsumoStockMinimoMapper
            = ArticuloInsumoStockMinimoMapper.getInstance();

    public ArticuloInsumoStockMinimoServiceImpl(
            BaseRepository<ArticuloInsumoStockMinimo, Long> baseRepository,
            BaseMapper<ArticuloInsumoStockMinimo, ArticuloInsumoStockMinimoDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
