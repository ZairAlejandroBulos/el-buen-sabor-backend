package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoDTO;
import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoFullDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;

import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, ArticuloManufacturadoFullDTO, Long> {

    List<ArticuloManufacturadoDTO> findAllArticuloManufacturado() throws Exception;
    List<ArticuloManufacturadoDTO> findByTermino(String termino) throws Exception;
    ArticuloManufacturadoDTO findArticuloManufacturadoById(Long id) throws Exception;
    List<ArticuloManufacturadoFullDTO> findAllArticuloManufacturadoFull() throws Exception;
    ArticuloManufacturadoFullDTO findArticuloManufacturadoFullById(Long id) throws Exception;
}
