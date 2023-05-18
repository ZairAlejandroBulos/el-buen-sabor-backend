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
    private boolean esInsumo;

    @ManyToOne
    @JoinColumn(name = "unidad_medida_id")
    private UnidadMedida unidadMedida;

    @ManyToOne
    @JoinColumn(name = "rubro_articulo_id")
    private RubroArticulo rubroArticulo;

    @OneToMany(mappedBy = "articuloInsumo")
    private List<ArticuloInsumoStockActual> articuloInsumoStockActual;

    @OneToMany(mappedBy = "articuloInsumo")
    private List<ArticuloInsumoStockMinimo> articuloInsumoStockMinimo;

    @OneToMany(mappedBy = "articuloInsumo")
    private List<ArticuloInsumoPrecioCompra> articuloInsumoPrecioCompra;

    @ManyToMany(
            fetch = FetchType.LAZY,
            targetEntity = ArticuloManufacturado.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    private List<ArticuloManufacturado> articuloManufacturados;
}
