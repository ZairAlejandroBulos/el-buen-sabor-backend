package com.utn.elbuensaborbackend.dtos;

import com.utn.elbuensaborbackend.entities.Imagen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ArticuloManufacturadoDTO extends BaseDTO{

    private String denominacion;

    private String descripcion;

    private Date tiempoEstimado;

    private List<ImagenDTO> imagenes;

    private ArticuloManufacturadoPrecioVentaDTO articuloManufacturadoPrecioVenta;
}
