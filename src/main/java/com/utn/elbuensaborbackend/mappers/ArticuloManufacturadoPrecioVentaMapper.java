package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoPrecioVentaDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoPrecioVenta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoPrecioVentaMapper extends BaseMapper<ArticuloManufacturadoPrecioVenta, ArticuloManufacturadoPrecioVentaDTO> {

    static ArticuloManufacturadoPrecioVentaMapper getInstance() {
        return Mappers.getMapper(ArticuloManufacturadoPrecioVentaMapper.class);
    }

}
