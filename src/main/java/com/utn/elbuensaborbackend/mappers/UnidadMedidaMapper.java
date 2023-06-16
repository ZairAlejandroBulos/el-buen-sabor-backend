package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.UnidadMedidaDTO;
import com.utn.elbuensaborbackend.entities.UnidadMedida;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UnidadMedidaMapper extends BaseMapper<UnidadMedida, UnidadMedidaDTO> {

    static UnidadMedidaMapper getInstance() {
        return Mappers.getMapper(UnidadMedidaMapper.class);
    }

    UnidadMedidaDTO toDTO(UnidadMedida source);


    UnidadMedida toEntity(UnidadMedidaDTO source);

    @IterableMapping(qualifiedByName = "toDTO")
    List<UnidadMedidaDTO> toDTOsList(List<UnidadMedida> source);

    @IterableMapping(qualifiedByName = "toEntity")
    List<UnidadMedida> toEntitiesList(List<UnidadMedidaDTO> source);

    @Named("toDTO")
    default UnidadMedidaDTO toDTO(UnidadMedidaDTO source) {
        return source;
    }

    @Named("toEntity")
    default UnidadMedida toEntity(UnidadMedida source) {
        return source;
    }
}
