package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoStockActualDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoStockActual;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoStockActualMapper extends BaseMapper<ArticuloInsumoStockActual, ArticuloInsumoStockActualDTO> {

    static ArticuloInsumoStockActualMapper getInstance() {
        return Mappers.getMapper(ArticuloInsumoStockActualMapper.class);
    }
}
