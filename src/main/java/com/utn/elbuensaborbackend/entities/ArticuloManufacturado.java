package com.utn.elbuensaborbackend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articulo_manufacturado")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ArticuloManufacturado extends Base {
}
