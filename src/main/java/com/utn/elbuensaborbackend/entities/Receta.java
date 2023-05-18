package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "receta")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_receta"))
public class Receta extends Base {

    @Column(name = "descripcion")
	private String descripcion;

    @ManyToOne
    @JoinColumn(name="articulo_manufacturado_insumo_id")
	private ArticuloManufacturadoInsumo articuloManufacturadoInsumo;

}
