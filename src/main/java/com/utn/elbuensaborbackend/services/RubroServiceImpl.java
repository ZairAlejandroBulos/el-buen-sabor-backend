package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.RubroDTO;
import com.utn.elbuensaborbackend.entities.Rubro;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.mappers.RubroMapper;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.RubroRepository;
import com.utn.elbuensaborbackend.services.interfaces.RubroService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RubroServiceImpl extends BaseServiceImpl<Rubro, RubroDTO, Long> implements RubroService  {

    @Autowired
    private RubroRepository rubroRepository;

    private final RubroMapper rubroMapper = RubroMapper.getInstance();

    public RubroServiceImpl(BaseRepository<Rubro, Long> baseRepository, BaseMapper<Rubro, RubroDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Override
    public List<RubroDTO> findDesbloqueados() throws Exception {
        try {
            List<Rubro> rubros = rubroRepository.findDesbloqueados();
            return rubroMapper.toDTOsList(rubros);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean existsByDenominacion(String denominacion) throws Exception {
        try {
            Rubro rubro = rubroRepository.findByDenominacion(denominacion);
            return rubro != null ? true : false;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Rubro save(RubroDTO dto) throws Exception {
        try {
            Rubro rubro = rubroMapper.toEntity(dto);

            if (dto.getRubroPadreId() != null) {
                if (rubroRepository.existsById(dto.getRubroPadreId())) {
                    Rubro rubroPadre = rubroRepository.findById(dto.getRubroPadreId()).get();
                    rubro.setRubroPadre(rubroPadre);
                } else {
                    throw new Exception("El Rubro Padre no existe.");
                }
            }

            return rubroRepository.save(rubro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Rubro update(Long id, RubroDTO dto) throws Exception {
        try {
            Optional<Rubro> optional = rubroRepository.findById(id);

            if (optional.isEmpty()) {
                throw new Exception("El Rubro a actualizar no existe.");
            }

            Rubro rubro = optional.get();

            if (dto.getRubroPadreId() != null) {
                if (rubroRepository.existsById(dto.getRubroPadreId())) {
                    Rubro rubroPadre = rubroRepository.findById(dto.getRubroPadreId()).get();
                    rubro.setRubroPadre(rubroPadre);
                } else {
                    throw new Exception("El Rubro Padre no existe.");
                }
            } else {
                rubro.setRubroPadre(null);
            }

            rubro.setDenominacion(dto.getDenominacion());

            return rubroRepository.save(rubro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void bloquearDesbloquear(Long id) throws Exception {
        try {
            Optional<Rubro> optional = rubroRepository.findById(id);

            if (optional.isEmpty()) {
                throw new Exception("El Rubro a bloquear o desbloquear no existe.");
            }

            Rubro rubro = optional.get();
            recursiveBloquearDesbloquear(rubro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void recursiveBloquearDesbloquear(Rubro entity) {
        entity.setBloqueado(!entity.getBloqueado());

        if (entity.getSubRubros() != null && !entity.getSubRubros().isEmpty()) {
            for (Rubro subRubro : entity.getSubRubros()) {
                recursiveBloquearDesbloquear(subRubro);
            }
        }

        rubroRepository.save(entity);
    }
}
