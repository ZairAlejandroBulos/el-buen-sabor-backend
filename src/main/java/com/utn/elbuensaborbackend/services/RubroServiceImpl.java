package com.utn.elbuensaborbackend.services;

/*
import com.utn.elbuensaborbackend.dtos.RubroDTO;
import com.utn.elbuensaborbackend.entities.Rubro;
import com.utn.elbuensaborbackend.repositories.RubroRepository;
import com.utn.elbuensaborbackend.services.interfaces.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RubroServiceImpl implements RubroService  {

    @Autowired
    private RubroRepository rubroRepository;

    @Override
    public List<RubroDTO> findAll() throws Exception {
        try {
            List<Rubro> rubros = rubroRepository.findAll();
            List<RubroDTO> dtos = new ArrayList<>();

            for (Rubro r : rubros) {
                RubroDTO rubroDTO = new RubroDTO();
                rubroDTO.setId(r.getId());
                rubroDTO.setDenominacion(r.getDenominacion());

                if (r.getRubroPadre() != null) {
                    rubroDTO.setRubroPadreId(r.getRubroPadre().getId());
                }

                dtos.add(rubroDTO);
            }

            return dtos;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<RubroDTO> findAllParents() throws Exception {
        try {
            List<Rubro> rubros = rubroRepository.findAllParents();
            List<RubroDTO> dtos = new ArrayList<>();

            for (Rubro r : rubros) {
                RubroDTO rubroDTO = new RubroDTO();
                rubroDTO.setId(r.getId());
                rubroDTO.setDenominacion(r.getDenominacion());

                if (r.getRubroPadre() != null) {
                    rubroDTO.setRubroPadreId(r.getId());
                }

                dtos.add(rubroDTO);
            }

            return dtos;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public RubroDTO findById(Long id) throws Exception {
        try {
            Rubro rubro = rubroRepository.findById(id).get();
            RubroDTO rubroDTO = new RubroDTO();

            rubroDTO.setId(rubro.getId());
            rubroDTO.setDenominacion(rubro.getDenominacion());

            if (rubro.getRubroPadre() != null) {
                rubroDTO.setRubroPadreId(rubro.getId());
            }

            return rubroDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Rubro save(RubroDTO entity) throws Exception {
        try {
            Rubro rubro = new Rubro();
            rubro.setId(entity.getId());
            rubro.setDenominacion(entity.getDenominacion());

            if (entity.getRubroPadreId() != null) {
                Rubro rubroPadre = rubroRepository.findById(entity.getRubroPadreId()).get();
                rubro.setRubroPadre(rubroPadre);
            }

            return rubroRepository.save(rubro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Rubro update(Long id, RubroDTO entity) throws Exception {
        try {
            Optional<Rubro> optional = rubroRepository.findById(id);

            if (optional == null) {
                throw new Exception("El Rubro actualizar no existe.");
            }

            Rubro rubro = optional.get();
            rubro.setId(entity.getId());
            rubro.setDenominacion(entity.getDenominacion());

            if (entity.getRubroPadreId() != null) {
                Rubro rubroPadre = rubroRepository.findById(entity.getRubroPadreId()).get();
                rubro.setRubroPadre(rubroPadre);
            } else {
                rubro.setRubroPadre(null);
            }

            return rubroRepository.save(rubro);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            rubroRepository.deleteById(id);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
*/