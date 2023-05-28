package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.LocalidadDTO;
import com.utn.elbuensaborbackend.entities.Localidad;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocalidadMapper {
    static LocalidadMapper getInstance() {
        return Mappers.getMapper(LocalidadMapper.class);
    }

    @Named("toDTO")
    LocalidadDTO toDTO(Localidad source);

    @Named("toEntity")
    Localidad toEntity(LocalidadDTO source);

    List<LocalidadDTO> toDTOsList(List<Localidad> source);

    List<Localidad> toEntitiesList(List<LocalidadDTO> source);
}
