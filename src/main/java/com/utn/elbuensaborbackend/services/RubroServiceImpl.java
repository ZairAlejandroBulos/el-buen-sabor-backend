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
    @Transactional
    public Rubro saveRubro(RubroDTO dto) throws Exception {
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
    public Rubro updateRubro(Long id, RubroDTO dto) throws Exception {
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

}
