package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloManufacturadoMapper extends BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDTO> {

    static ArticuloManufacturadoMapper getInstance(){
        return Mappers.getMapper(ArticuloManufacturadoMapper.class);
    }

    @Mapping(target = "source.rubro", ignore = true)
    @Mapping(target = "source.tiempoEstimadoCocina", ignore = true)
    ArticuloManufacturadoDTO toDTO(ArticuloManufacturado source);

    @Mapping(target = "source.rubro", ignore = true)
    @Mapping(target = "source.tiempoEstimadoCocina", ignore = true)
    List<ArticuloManufacturadoDTO> toDTOsList(List<ArticuloManufacturado> source);
}
