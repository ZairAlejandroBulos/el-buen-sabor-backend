package com.utn.elbuensaborbackend.dtos;

import lombok.Data;

@Data
public class ArticuloInsumoFullDTO extends BaseDTO {

    private String denominacion;
    private Boolean esInsumo;
    private UnidadMedidaDTO unidadMedida;
    private RubroDTO rubro;
    private Double precioCompra;
    private Float stockMinimo;
    private Float stockActual;
}
