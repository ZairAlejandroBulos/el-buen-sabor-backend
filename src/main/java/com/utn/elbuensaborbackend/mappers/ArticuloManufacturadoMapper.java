package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoDTO;
import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoFullDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoFullDTO> {

    static ArticuloManufacturadoMapper getInstance(){
        return Mappers.getMapper(ArticuloManufacturadoMapper.class);
    }

    @Mapping(target = "source.rubro", ignore = true)
    @Mapping(target = "source.tiempoEstimadoCocina", ignore = true)
    ArticuloManufacturadoDTO toSimpleDTO(ArticuloManufacturado source);

    List<ArticuloManufacturadoDTO> toSimpleDTOsList(List<ArticuloManufacturado> source);

    @Mapping(target = "source.tiempoEstimadoCocina", dateFormat = "HH:mm:ss")
    ArticuloManufacturado toEntity(ArticuloManufacturadoFullDTO source);
}
