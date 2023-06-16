package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoPrecioCompraDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoPrecioCompra;
import com.utn.elbuensaborbackend.mappers.ArticuloInsumoPrecioCompraMapper;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.repositories.ArticuloInsumoPrecioCompraRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloInsumoPrecioCompraService;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticuloInsumoPrecioCompraServiceImpl
        extends BaseServiceImpl<ArticuloInsumoPrecioCompra, ArticuloInsumoPrecioCompraDTO, Long>
        implements ArticuloInsumoPrecioCompraService {

    @Autowired
    private ArticuloInsumoPrecioCompraRepository articuloInsumoPrecioCompraRepository;

    private final ArticuloInsumoPrecioCompraMapper articuloInsumoPrecioCompraMapper
            = ArticuloInsumoPrecioCompraMapper.getInstance();

    public ArticuloInsumoPrecioCompraServiceImpl(
            BaseRepository<ArticuloInsumoPrecioCompra, Long> baseRepository,
            BaseMapper<ArticuloInsumoPrecioCompra, ArticuloInsumoPrecioCompraDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }
}
