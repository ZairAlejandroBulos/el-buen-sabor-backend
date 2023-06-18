package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoInsumoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoInsumo;
import com.utn.elbuensaborbackend.mappers.ArticuloManufacturadoInsumoMapper;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.repositories.ArticuloManufacturadoInsumoRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticuloManufacturadoInsumoServiceImpl extends BaseServiceImpl<ArticuloManufacturadoInsumo,ArticuloManufacturadoInsumoDTO, Long>
        implements ArticuloManufacturadoInsumoService {

    @Autowired
    private ArticuloManufacturadoInsumoRepository articuloManufacturadoInsumoRepository;

    @Autowired
    private ArticuloManufacturadoInsumoMapper articuloManufacturadoInsumoMapper = ArticuloManufacturadoInsumoMapper.getInstance();

    public ArticuloManufacturadoInsumoServiceImpl(BaseRepository<ArticuloManufacturadoInsumo, Long> baseRepository,
                                                  BaseMapper<ArticuloManufacturadoInsumo, ArticuloManufacturadoInsumoDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Override
    public List<ArticuloManufacturadoInsumoDTO> findByArticuloManufacturadoId(Long id) throws Exception {
        try {
            List<ArticuloManufacturadoInsumo> entities =
                    articuloManufacturadoInsumoRepository.findByArticuloManufacturadoId(id);
            return articuloManufacturadoInsumoMapper.toDTOsList(entities);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}