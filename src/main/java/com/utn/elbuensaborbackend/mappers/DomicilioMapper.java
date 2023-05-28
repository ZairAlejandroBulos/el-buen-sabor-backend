package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.DomicilioDTO;
import com.utn.elbuensaborbackend.entities.Domicilio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = LocalidadMapper.class)
public interface DomicilioMapper {
    static DomicilioMapper getInstance() {
        return Mappers.getMapper(DomicilioMapper.class);
    }

    @Named("toDTO")
    @Mapping(source = "localidad", target = "localidad")
    DomicilioDTO toDTO(Domicilio source);

    @Named("toEntity")
    @Mapping(source = "localidad", target = "localidad")
    Domicilio toEntity(DomicilioDTO source);

    List<DomicilioDTO> toDTOsList(List<Domicilio> source);

    List<Domicilio> toEntitiesList(List<DomicilioDTO> source);
}
