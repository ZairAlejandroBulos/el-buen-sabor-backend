package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ImagenDTO;
import com.utn.elbuensaborbackend.entities.Imagen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImagenMapper extends BaseMapper<Imagen, ImagenDTO> {

    static ImagenMapper getInstance() {
        return Mappers.getMapper(ImagenMapper.class);
    }

    @Mapping(source = "articuloManufacturado.id", target = "articuloManufacturadoId")
    ImagenDTO toDTO(Imagen source);

    @Mapping(target = "articuloManufacturado", ignore = true)
    Imagen toEntity(ImagenDTO source);

    List<ImagenDTO> toDTOsList(List<Imagen> source);

    List<Imagen> toEntitiesList(List<ImagenDTO> source);
}
