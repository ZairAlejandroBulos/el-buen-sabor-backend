package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoMapper {

    static ArticuloManufacturadoMapper getInstance() {
        return Mappers.getMapper(ArticuloManufacturadoMapper.class);
    }

    ArticuloManufacturadoDTO toDTO(ArticuloManufacturado source);

    ArticuloManufacturado toEntity(ArticuloManufacturadoDTO source);

    List<ArticuloManufacturadoDTO> toDTOsList(List<ArticuloManufacturado> source);

    List<ArticuloManufacturado> toEntitiesList(List<ArticuloManufacturadoDTO> source);

}
