package com.utn.elbuensaborbackend.dtos;

import lombok.Data;

import java.sql.Time;

@Data
public class ArticuloManufacturadoFullDTO extends BaseDTO {

    private String denominacion;

    private String descripcion;

    private String imagen;

    private Double precioVenta;

    private Time tiempoEstimadoCocina;

    private RubroDTO rubro;
}
