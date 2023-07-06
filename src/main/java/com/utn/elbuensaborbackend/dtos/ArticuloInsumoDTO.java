package com.utn.elbuensaborbackend.dtos;

import lombok.*;

@Data
public class ArticuloInsumoDTO extends BaseDTO {

    private String denominacion;
    private Boolean esInsumo;
    private UnidadMedidaDTO unidadMedida;
    private RubroDTO rubro;
}
