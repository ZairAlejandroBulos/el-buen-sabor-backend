package com.utn.elbuensaborbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ArticuloInsumoPrecioCompraDTO {

    private Long id;

    private Date fecha;

    private Double monto;

    private ArticuloInsumoDTO articuloInsumo;
}
