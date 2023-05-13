package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rubro_articulo")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RubroArticulo extends Base {

    @Column(name = "denominacion", nullable = false)
    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "rubro_padre_id")
    private RubroArticulo rubroPadre;

    @OneToMany(mappedBy = "rubroPadre")
    private List<RubroArticulo> subRubros;
}
