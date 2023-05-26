package com.utn.elbuensaborbackend.mappers;


import com.utn.elbuensaborbackend.dtos.ArticuloInsumoStockMinimoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoStockMinimo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoStockMinimoMapper {
    static ArticuloInsumoStockMinimoMapper getInstance() {
        return Mappers.getMapper(ArticuloInsumoStockMinimoMapper.class);
    }

    ArticuloInsumoStockMinimoDTO toDTO(ArticuloInsumoStockMinimo source);

    ArticuloInsumoStockMinimo toEntity(ArticuloInsumoStockMinimoDTO source);

    List<ArticuloInsumoStockMinimoDTO> toDTOsList(List<ArticuloInsumoStockMinimo> source);

    List<ArticuloInsumoStockMinimo> toEntitiesList(List<ArticuloInsumoStockMinimoDTO> source);
}
