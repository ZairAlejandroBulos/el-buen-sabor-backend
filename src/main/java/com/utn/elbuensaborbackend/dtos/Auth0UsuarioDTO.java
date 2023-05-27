package com.utn.elbuensaborbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Auth0UsuarioDTO {
    private String email;
    private String clave;
    private List<RolDTO> roles;
}
