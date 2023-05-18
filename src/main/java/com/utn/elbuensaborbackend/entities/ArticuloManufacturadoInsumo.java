package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articulo_manufacturado_insumo")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_articulo_manufacturado_insumo"))
public class ArticuloManufacturadoInsumo extends Base {

    @Column(name = "cantidad")
	private int cantidad;

    @OneToMany(mappedBy = "articuloManufacturadoInsumo")
    private Receta receta;

}
