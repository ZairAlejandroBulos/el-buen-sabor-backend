package com.utn.elbuensaborbackend.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RubroSimpleDTO {
    private Long id;
    private Long rubroPadreId;
    private String denominacion;
}
