package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rol")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_rol"))
public class Rol extends Base {

    @Column(name = "denominacion", nullable = false, length = 20)
    private String denominacion;

    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuarios;
}
