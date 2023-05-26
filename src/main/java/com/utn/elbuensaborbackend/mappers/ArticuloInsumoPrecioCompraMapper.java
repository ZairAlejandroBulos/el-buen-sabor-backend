package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoPrecioCompraDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoPrecioCompra;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticuloInsumoPrecioCompraMapper {
    static ArticuloInsumoPrecioCompraMapper getInstance() {
        return Mappers.getMapper(ArticuloInsumoPrecioCompraMapper.class);
    }

    ArticuloInsumoPrecioCompraDTO toDTO(ArticuloInsumoPrecioCompra source);

    ArticuloInsumoPrecioCompra toEntity(ArticuloInsumoPrecioCompraDTO source);

    List<ArticuloInsumoPrecioCompraDTO> toDTOsList(List<ArticuloInsumoPrecioCompra> source);

    List<ArticuloInsumoPrecioCompra> toEntitiesList(List<ArticuloInsumoPrecioCompraDTO> source);
}
