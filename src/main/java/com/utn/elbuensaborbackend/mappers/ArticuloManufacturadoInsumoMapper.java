package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoInsumoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoInsumo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoInsumoMapper extends BaseMapper<ArticuloManufacturadoInsumo, ArticuloManufacturadoInsumoDTO> {

    static ArticuloManufacturadoInsumoMapper getInstance() {
        return Mappers.getMapper(ArticuloManufacturadoInsumoMapper.class);
    }
}
