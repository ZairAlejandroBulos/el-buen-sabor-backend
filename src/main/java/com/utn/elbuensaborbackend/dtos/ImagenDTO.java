package com.utn.elbuensaborbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ImagenDTO {

    private Long id;
    private String nombre;
    private ArticuloManufacturadoDTO articuloManufacturado;
}
