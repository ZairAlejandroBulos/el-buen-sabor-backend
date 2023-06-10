package com.utn.elbuensaborbackend.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class ArticuloManufacturadoPrecioVentaDTO extends BaseDTO {

    private Double precioVenta;

    private Date fecha;
}
