package com.utn.elbuensaborbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "denominacion",length = 20)
    private String denominacion;

    @Column(name = "es_insumo")
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private Boolean esInsumo;

    @Column(name = "stock_actual")
    private Float stockActual;

    @Column(name = "stock_minimo")
    private Float stockMinimo;

    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;

    @ManyToOne
    @JoinColumn(name = "unidad_medida_id")
    private UnidadMedida unidadMedida;

    @OneToMany(mappedBy = "articuloInsumo", cascade = CascadeType.ALL)
    private List<ArticuloInsumoPrecioCompra> preciosCompras;

    @OneToMany(mappedBy = "articuloInsumo")
    @JsonIgnore
    List<DetalleArticuloManufacturado> detalles;

    public void addStock(Float stock) {
        this.stockActual += stock;
    }

    public void decrementStock(Float stock) {
        this.stockActual -= stock;
    }
}
