package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoStockActualDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoStockActual;
import com.utn.elbuensaborbackend.mappers.ArticuloInsumoStockActualMapper;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.repositories.ArticuloInsumoStockActualRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloInsumoStockActualService;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticuloInsumoStockActualServiceImpl
        extends BaseServiceImpl<ArticuloInsumoStockActual, ArticuloInsumoStockActualDTO, Long>
        implements ArticuloInsumoStockActualService {

    @Autowired
    private ArticuloInsumoStockActualRepository articuloInsumoStockActualRepository;

    private final ArticuloInsumoStockActualMapper articuloInsumoStockActualMapper
            = ArticuloInsumoStockActualMapper.getInstance();

    public ArticuloInsumoStockActualServiceImpl(
            BaseRepository<ArticuloInsumoStockActual, Long> baseRepository,
            BaseMapper<ArticuloInsumoStockActual, ArticuloInsumoStockActualDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
