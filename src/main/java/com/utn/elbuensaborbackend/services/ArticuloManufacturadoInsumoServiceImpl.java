package com.utn.elbuensaborbackend.services;

/*
import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoInsumoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoInsumo;
import com.utn.elbuensaborbackend.repositories.ArticuloManufacturadoInsumoRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ArticuloManufacturadoInsumoServiceImpl extends BaseServiceImpl<ArticuloManufacturadoInsumo, Long>
    implements ArticuloManufacturadoInsumoService {

    @Autowired
    private ArticuloManufacturadoInsumoRepository articuloManufacturadoInsumoRepository;

    public ArticuloManufacturadoInsumoServiceImpl(BaseRepository<ArticuloManufacturadoInsumo, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<ArticuloManufacturadoInsumoDTO> findByArticuloManufacturadoId(Long articuloManufacturadoId) throws Exception {
        try {
            List<ArticuloManufacturadoInsumo> entities =
                    articuloManufacturadoInsumoRepository.findByArticuloManufacturadoId(articuloManufacturadoId);
            List<ArticuloManufacturadoInsumoDTO> dtos = new ArrayList<>();

            for (ArticuloManufacturadoInsumo ami : entities) {
                ArticuloManufacturadoInsumoDTO dto = new ArticuloManufacturadoInsumoDTO();

                dto.setId(ami.getId());
                dto.setCantidad(ami.getCantidad());
                dto.setArticuloManufacturadoId(ami.getArticuloManufacturado().getId());
                dto.setArticuloInsumoId(ami.getArticuloInsumo().getId());

                dtos.add(dto);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}*/
