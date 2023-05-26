package com.utn.elbuensaborbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ArticuloInsumoStockActualDTO {

    private Long id;

    private Float stockActual;

    private Date fecha;

    private ArticuloInsumoDTO articuloInsumo;
}
