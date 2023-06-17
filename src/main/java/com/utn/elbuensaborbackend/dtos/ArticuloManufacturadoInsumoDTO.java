package com.utn.elbuensaborbackend.dtos;

import lombok.*;

@Data
public class ArticuloManufacturadoInsumoDTO extends BaseDTO{

    private Integer cantidad;

    private ArticuloInsumoDTO articuloInsumoId;

    private ArticuloManufacturadoDTO articuloManufacturadoDTO;
}
