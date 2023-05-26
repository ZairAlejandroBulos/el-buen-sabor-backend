package com.utn.elbuensaborbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DomicilioDTO {

    private Long id;

    private String calle;

    private Integer numero;

    private LocalidadDTO localidad;
}
