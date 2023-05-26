package com.utn.elbuensaborbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ClienteDTO {

    private String nombre;
    private String apellido;
    private Long telefono;
    private UsuarioDTO usuario;
    private DomicilioDTO domicilio;
}
