package com.utn.elbuensaborbackend.dtos;

import lombok.Data;


@Data
public class ArticuloManufacturadoDTO extends BaseDTO{

    private String denominacion;

    private String descripcion;

    private String imagen;

    private Double precioVenta;
}
