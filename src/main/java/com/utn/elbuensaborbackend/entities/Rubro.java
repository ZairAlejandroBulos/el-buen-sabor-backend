package com.utn.elbuensaborbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rubro")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id_rubro"))
public class Rubro extends Base  {

    @Column(name = "denominacion", nullable = false, length = 20)
    private String denominacion;

    @ManyToOne
    @JoinColumn(name = "rubro_padre_id")
    private Rubro rubroPadre;

    @OneToMany(mappedBy = "rubroPadre")
    private List<Rubro> subRubros;

    public Rubro(String denominacion, Rubro rubroPadre) {
        this.denominacion = denominacion;
        this.rubroPadre = rubroPadre;
    }

    public void setSubRubros(List<Rubro> subRubros) {
        this.subRubros.clear();
        this.subRubros.addAll(subRubros);
    }
}
