package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoPrecioVentaDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoPrecioVenta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoPrecioVentaMapper {
    static ArticuloManufacturadoPrecioVentaMapper getInstance() {
        return Mappers.getMapper(ArticuloManufacturadoPrecioVentaMapper.class);
    }

    ArticuloManufacturadoPrecioVentaDTO toDTO(ArticuloManufacturadoPrecioVenta source);

    ArticuloManufacturadoPrecioVenta toEntity(ArticuloManufacturadoPrecioVentaDTO source);

    List<ArticuloManufacturadoPrecioVentaDTO> toDTOsList(List<ArticuloManufacturadoPrecioVenta> source);

    List<ArticuloManufacturadoPrecioVenta> toEntitiesList(List<ArticuloManufacturadoPrecioVentaDTO> source);
}
