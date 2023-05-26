package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "articulo_insumo")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_articulo_insumo"))
public class ArticuloInsumo extends Base {

    @Column(name = "denominacion",length = 20, nullable = false)
    private String denominacion;

    @Column(name = "es_insumo", nullable = false)
    private Boolean esInsumo;

    @ManyToOne
    @JoinColumn(name = "unidad_medida_id")
    private UnidadMedida unidadMedida;

    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;
}
