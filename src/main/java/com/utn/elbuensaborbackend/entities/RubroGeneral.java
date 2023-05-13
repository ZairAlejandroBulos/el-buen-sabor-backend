package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rubro_general")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RubroGeneral extends Base {

    @Column(name = "denominacion", nullable = false)
    private String denominacion;

}
