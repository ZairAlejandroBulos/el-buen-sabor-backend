package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoStockMinimoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoStockMinimo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoStockMinimoMapper extends BaseMapper<ArticuloInsumoStockMinimo, ArticuloInsumoStockMinimoDTO> {

    static ArticuloInsumoStockMinimoMapper getInstance() {
        return Mappers.getMapper(ArticuloInsumoStockMinimoMapper.class);
    }
}
