package com.utn.elbuensaborbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ArticuloInsumoStockMinimoDTO {

    private Long id;

    private Float stockMinimo;

    private Date fecha;

    private ArticuloInsumoDTO articuloInsumo;
}
