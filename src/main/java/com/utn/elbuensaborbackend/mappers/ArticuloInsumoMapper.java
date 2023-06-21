package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoDTO;
import com.utn.elbuensaborbackend.dtos.ArticuloInsumoFullDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoMapper extends BaseMapper<ArticuloInsumo, ArticuloInsumoFullDTO> {

    static ArticuloInsumoMapper getInstance(){
        return Mappers.getMapper(ArticuloInsumoMapper.class);
    }

    @Mapping(target = "source.rubro", ignore = true)
    @Mapping(target = "source.unidadMedida", ignore = true)
    @Mapping(target = "source.esInsumo", ignore = true)
    ArticuloInsumoDTO toSimpleDTO(ArticuloInsumo source);

    List<ArticuloInsumoDTO> toSimpleDTOsList(List<ArticuloInsumo> source);
}
