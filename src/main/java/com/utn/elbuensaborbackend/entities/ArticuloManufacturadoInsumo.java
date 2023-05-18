package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "articulo_manufacturado_insumo")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_articulo_manufacturado_insumo"))
public class ArticuloManufacturadoInsumo extends Base {

    @Column(name = "cantidad")
	private int cantidad;

    @OneToMany(mappedBy = "articuloManufacturadoInsumo")
    private List<Receta> receta;

}
