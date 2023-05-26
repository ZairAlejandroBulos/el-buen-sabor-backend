package com.utn.elbuensaborbackend.mappers;


import com.utn.elbuensaborbackend.dtos.ArticuloInsumoStockActualDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoStockActualMapper {
    static ArticuloInsumoStockActualMapper getInstance() {
        return Mappers.getMapper(ArticuloInsumoStockActualMapper.class);
    }

    ArticuloInsumoStockActualDTO toDTO(ArticuloInsumo source);

    ArticuloInsumo toEntity(ArticuloInsumoStockActualDTO source);

    List<ArticuloInsumoStockActualDTO> toDTOsList(List<ArticuloInsumo> source);

    List<ArticuloInsumo> toEntitiesList(List<ArticuloInsumoStockActualDTO> source);
}
