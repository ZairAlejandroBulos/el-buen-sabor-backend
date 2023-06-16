package com.utn.elbuensaborbackend.services.interfaces;
import com.utn.elbuensaborbackend.dtos.ArticuloInsumoFullDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumo;

import java.util.List;


public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, ArticuloInsumoFullDTO, Long> {

    List<ArticuloInsumoFullDTO> findAllArticuloInsumoFull() throws Exception;
    ArticuloInsumoFullDTO findArticuloInsumoFullById(Long id) throws Exception;
    ArticuloInsumoFullDTO saveArticuloInsumo(ArticuloInsumoFullDTO dto) throws Exception;
    ArticuloInsumoFullDTO updateArticuloInsumo(Long id, ArticuloInsumoFullDTO dto) throws Exception;
}
