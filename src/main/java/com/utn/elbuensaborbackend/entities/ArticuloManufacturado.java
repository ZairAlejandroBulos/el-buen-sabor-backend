package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_articulo_manufacturado"))
public class ArticuloManufacturado extends Base {

    @Column(name = "denominacion", length=20)
	private String denominacion;
    
    @Column(name = "tiempo_estimado_cocina")
    @Temporal(TemporalType.TIME)
	private Date tiempoEstimado;

    @ManyToOne
    @JoinColumn(name = "rubro_general_id")
	private RubroGeneral rubroGeneral;

    @OneToMany(mappedBy = "articuloManufacturado")
    private List<Imagen> imagenes;

    @ManyToMany(
        fetch = FetchType.LAZY,
        targetEntity = ArticuloInsumo.class,
        cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
        name = "articulo_manufacturado_insumo",
        joinColumns = @JoinColumn(name = "articulo_manufacturado_id"),
        inverseJoinColumns = @JoinColumn(name = "articulo_insumo_id")
    )
    private List<ArticuloInsumo> articulosInsumos;


}
