package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;

import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, ArticuloManufacturadoDTO, Long> {

    List<ArticuloManufacturadoDTO> findByTermino(String termino) throws Exception;

    List<ArticuloManufacturadoDTO> findAllArticuloManufacturado() throws Exception;

    ArticuloManufacturadoDTO findByIdArticuloManufacturado(Long id) throws Exception;

    //ArticuloManufacturado saveArticuloManufacturado(ArticuloManufacturadoDTO dto) throws Exception;
}
