package com.utn.elbuensaborbackend.mappers;


import com.utn.elbuensaborbackend.dtos.ArticuloInsumoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoMapper {

    static ArticuloInsumoMapper getInstance() {
        return Mappers.getMapper(ArticuloInsumoMapper.class);
    }

    ArticuloInsumoDTO toDTO(ArticuloInsumo source);

    ArticuloInsumo toEntity(ArticuloInsumoDTO source);

    List<ArticuloInsumoDTO> toDTOsList(List<ArticuloInsumo> source);

    List<ArticuloInsumo> toEntitiesList(List<ArticuloInsumoDTO> source);

}
