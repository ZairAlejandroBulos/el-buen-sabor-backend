package com.utn.elbuensaborbackend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ArticuloManufacturadoDTO extends BaseDTO {

    private String denominacion;
    private String descripcion;
    private String imagen;
    private Double precioVenta;
    private List<DetalleArticuloManufacturadoDTO> detalles;
}
