package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoInsumoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoInsumo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoInsumoMapper {
    static ArticuloManufacturadoInsumoMapper getInstance() {
        return Mappers.getMapper(ArticuloManufacturadoInsumoMapper.class);
    }

    ArticuloManufacturadoInsumoDTO toDTO(ArticuloManufacturadoInsumo source);

    ArticuloManufacturadoInsumo toEntity(ArticuloManufacturadoInsumoDTO source);

    List<ArticuloManufacturadoInsumoDTO> toDTOsList(List<ArticuloManufacturadoInsumo> source);

    List<ArticuloManufacturadoInsumo> toEntitiesList(List<ArticuloManufacturadoInsumoDTO> source);
}
