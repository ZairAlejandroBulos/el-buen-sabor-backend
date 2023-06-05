package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoInsumoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoInsumo;

import java.util.List;

public interface ArticuloManufacturadoInsumoService extends BaseService<ArticuloManufacturadoInsumo, Long> {
    List<ArticuloManufacturadoInsumoDTO> findByArticuloManufacturadoId(Long articuloManufacturadoId) throws Exception;
}
