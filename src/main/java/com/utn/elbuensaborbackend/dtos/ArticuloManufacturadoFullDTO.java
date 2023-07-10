package com.utn.elbuensaborbackend.dtos;

import lombok.Data;

import java.sql.Time;
import java.util.List;

@Data
public class ArticuloManufacturadoFullDTO extends BaseDTO {

    private String denominacion;
    private String descripcion;
    private Time tiempoEstimadoCocina;
    private String imagen;
    private String receta;
    private Double precioVenta;
    private RubroDTO rubro;
    private List<DetalleArticuloManufacturadoDTO> detalles;
}
