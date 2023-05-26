package com.utn.elbuensaborbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ArticuloInsumoDTO {

    private Long id;

    private String denominacion;

    private Boolean esInsumo;

    private UnidadMedidaDTO unidadMedida;

    private RubroDTO rubro;

}
