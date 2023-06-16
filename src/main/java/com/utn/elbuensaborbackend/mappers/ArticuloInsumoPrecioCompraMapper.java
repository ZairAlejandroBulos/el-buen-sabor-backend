package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoPrecioCompraDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoPrecioCompra;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoPrecioCompraMapper extends BaseMapper<ArticuloInsumoPrecioCompra, ArticuloInsumoPrecioCompraDTO> {

    static ArticuloInsumoPrecioCompraMapper getInstance() {
        return Mappers.getMapper(ArticuloInsumoPrecioCompraMapper.class);
    }
}
