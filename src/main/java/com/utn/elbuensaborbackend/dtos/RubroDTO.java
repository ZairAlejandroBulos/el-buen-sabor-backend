package com.utn.elbuensaborbackend.dtos;

import lombok.Data;

@Data
public class RubroDTO extends BaseDTO {

    private String denominacion;

    private Boolean bloqueado;

    private Long rubroPadreId;

    private String rubroPadreDenominacion;
}
