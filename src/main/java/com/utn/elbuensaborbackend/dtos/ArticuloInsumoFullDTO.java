package com.utn.elbuensaborbackend.dtos;

import lombok.Data;

@Data
public class ArticuloInsumoFullDTO extends BaseDTO {

    private String denominacion;
    private Boolean esInsumo;
    private Float stockMinimo;
    private Float stockActual;
    private RubroDTO rubro;
    private Double precioCompra;
    private UnidadMedidaDTO unidadMedida;
}
