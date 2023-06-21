package com.utn.elbuensaborbackend.dtos;

import lombok.Data;

@Data
public class ArticuloManufacturadoInsumoDTO extends BaseDTO {

    private Integer cantidad;

    private ArticuloInsumoFullDTO articuloInsumo;

    private ArticuloManufacturadoFullDTO articuloManufacturado;
}
