package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rubro_general")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RubroGeneral extends Base {

    @Column(name = "denominacion", nullable = false, length = 20)
    private String denominacion;

    @OneToMany(mappedBy = "rubroGeneral")
    public List<ArticuloManufacturado> articulosManufacturado;
}
