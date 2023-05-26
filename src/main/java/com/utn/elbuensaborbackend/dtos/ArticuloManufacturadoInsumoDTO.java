package com.utn.elbuensaborbackend.dtos;

import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ArticuloManufacturadoInsumoDTO {

    private Long id;

    private Integer cantidad;

    private ArticuloManufacturadoDTO articuloManufacturado;
}
