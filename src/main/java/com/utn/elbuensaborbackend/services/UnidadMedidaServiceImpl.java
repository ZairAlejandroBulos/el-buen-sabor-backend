package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.UnidadMedidaDTO;
import com.utn.elbuensaborbackend.entities.UnidadMedida;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.UnidadMedidaRepository;
import com.utn.elbuensaborbackend.services.interfaces.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UnidadMedidaServiceImpl
        extends BaseServiceImpl<UnidadMedida, UnidadMedidaDTO, Long>
        implements UnidadMedidaService {

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    public UnidadMedidaServiceImpl(BaseRepository<UnidadMedida, Long> baseRepository, BaseMapper<UnidadMedida, UnidadMedidaDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Override
    public Boolean existsByDenominacionUnidadMedida(String denominacion) throws Exception {
        try {
            UnidadMedida unidadMedida = unidadMedidaRepository.findByDenominacion(denominacion);
            return unidadMedida != null ? true : false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
