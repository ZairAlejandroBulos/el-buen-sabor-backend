package com.utn.elbuensaborbackend.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RubroCompletoDTO extends BaseDTO {

    private RubroSimpleDTO rubroPadre;

    private Long rubroPadreId;

    private String denominacion;
}
