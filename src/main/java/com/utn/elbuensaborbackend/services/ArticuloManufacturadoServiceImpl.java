package com.utn.elbuensaborbackend.services;

/*
import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoDTO;
import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoPrecioVentaDTO;
import com.utn.elbuensaborbackend.dtos.ImagenDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoPrecioVenta;
import com.utn.elbuensaborbackend.entities.Imagen;
import com.utn.elbuensaborbackend.repositories.ArticuloManufacturadoPrecioVentaRepository;
import com.utn.elbuensaborbackend.repositories.ArticuloManufacturadoRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.ImagenRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private ArticuloManufacturadoPrecioVentaRepository articuloManufacturadoPrecioVentaRepository;

    @Override
    public List<ArticuloManufacturadoDTO> findAll() throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.findAll();
            List<ArticuloManufacturadoDTO> articulosManufacturadoDTOs = new ArrayList<>();

            for (ArticuloManufacturado am : articuloManufacturados) {
                ArticuloManufacturadoDTO articuloManufacturadoDTO = new ArticuloManufacturadoDTO();
                articuloManufacturadoDTO.setId(am.getId());
                articuloManufacturadoDTO.setDenominacion(am.getDenominacion());
                articuloManufacturadoDTO.setDescripcion(am.getDescripcion());
                articuloManufacturadoDTO.setTiempoEstimadoCocina(am.getTiempoEstimadoCocina());

                Imagen imagen = imagenRepository.findByArticuloManufacturadoId(am.getId());
                ImagenDTO imagenDTO = new ImagenDTO();
                imagenDTO.setId(imagen.getId());
                imagenDTO.setNombre(imagen.getNombre());

                ArticuloManufacturadoPrecioVenta articuloManufacturadoPrecioVenta =
                        articuloManufacturadoPrecioVentaRepository.findByArticuloManufacturadoId(am.getId());
                ArticuloManufacturadoPrecioVentaDTO articuloManufacturadoPrecioVentaDTO =
                        new ArticuloManufacturadoPrecioVentaDTO();

                articuloManufacturadoPrecioVentaDTO.setId(articuloManufacturadoPrecioVenta.getId());
                articuloManufacturadoPrecioVentaDTO.setFecha(articuloManufacturadoPrecioVenta.getFecha());
                articuloManufacturadoPrecioVentaDTO.setPrecioVenta(articuloManufacturadoPrecioVenta.getPrecioVenta());

                articuloManufacturadoDTO.setImagen(imagenDTO);
                articuloManufacturadoDTO.setArticuloManufacturadoPrecioVenta(articuloManufacturadoPrecioVentaDTO);

                articulosManufacturadoDTOs.add(articuloManufacturadoDTO);
            }

            return articulosManufacturadoDTOs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloManufacturadoDTO findById(Long id) throws Exception {
        try {
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoRepository.findById(id).get();
            ArticuloManufacturadoDTO articuloManufacturadoDTO = new ArticuloManufacturadoDTO();

            articuloManufacturadoDTO.setId(articuloManufacturado.getId());
            articuloManufacturadoDTO.setDenominacion(articuloManufacturado.getDenominacion());
            articuloManufacturadoDTO.setDescripcion(articuloManufacturado.getDescripcion());
            articuloManufacturadoDTO.setTiempoEstimadoCocina(articuloManufacturado.getTiempoEstimadoCocina());

            Imagen imagen = imagenRepository.findByArticuloManufacturadoId(articuloManufacturado.getId());
            ImagenDTO imagenDTO = new ImagenDTO();

            imagenDTO.setId(imagen.getId());
            imagenDTO.setNombre(imagen.getNombre());

            ArticuloManufacturadoPrecioVenta articuloManufacturadoPrecioVenta =
                    articuloManufacturadoPrecioVentaRepository.findByArticuloManufacturadoId(articuloManufacturado.getId());
            ArticuloManufacturadoPrecioVentaDTO articuloManufacturadoPrecioVentaDTO =
                    new ArticuloManufacturadoPrecioVentaDTO();

            articuloManufacturadoPrecioVentaDTO.setId(articuloManufacturadoPrecioVenta.getId());
            articuloManufacturadoPrecioVentaDTO.setFecha(articuloManufacturadoPrecioVenta.getFecha());
            articuloManufacturadoPrecioVentaDTO.setPrecioVenta(articuloManufacturadoPrecioVenta.getPrecioVenta());

            articuloManufacturadoDTO.setImagen(imagenDTO);
            articuloManufacturadoDTO.setArticuloManufacturadoPrecioVenta(articuloManufacturadoPrecioVentaDTO);

            return articuloManufacturadoDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturadoDTO> findByTermino(String termino) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.findByTermino(termino);
            List<ArticuloManufacturadoDTO> articulosManufacturadoDTOs = new ArrayList<>();

            for (ArticuloManufacturado am : articuloManufacturados) {
                ArticuloManufacturadoDTO articuloManufacturadoDTO = new ArticuloManufacturadoDTO();
                articuloManufacturadoDTO.setId(am.getId());
                articuloManufacturadoDTO.setDenominacion(am.getDenominacion());
                articuloManufacturadoDTO.setDescripcion(am.getDescripcion());
                articuloManufacturadoDTO.setTiempoEstimadoCocina(am.getTiempoEstimadoCocina());

                Imagen imagen = imagenRepository.findByArticuloManufacturadoId(am.getId());
                ImagenDTO imagenDTO = new ImagenDTO();

                imagenDTO.setId(imagen.getId());
                    imagenDTO.setNombre(imagen.getNombre());

                    ArticuloManufacturadoPrecioVenta articuloManufacturadoPrecioVenta =
                        articuloManufacturadoPrecioVentaRepository.findByArticuloManufacturadoId(am.getId());
                ArticuloManufacturadoPrecioVentaDTO articuloManufacturadoPrecioVentaDTO =
                        new ArticuloManufacturadoPrecioVentaDTO();

                articuloManufacturadoPrecioVentaDTO.setId(articuloManufacturadoPrecioVenta.getId());
                articuloManufacturadoPrecioVentaDTO.setFecha(articuloManufacturadoPrecioVenta.getFecha());
                articuloManufacturadoPrecioVentaDTO.setPrecioVenta(articuloManufacturadoPrecioVenta.getPrecioVenta());

                articuloManufacturadoDTO.setImagen(imagenDTO);
                articuloManufacturadoDTO.setArticuloManufacturadoPrecioVenta(articuloManufacturadoPrecioVentaDTO);

                articulosManufacturadoDTOs.add(articuloManufacturadoDTO);
            }

            return articulosManufacturadoDTOs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloManufacturado save(ArticuloManufacturadoDTO entity) throws Exception {
        try {
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloManufacturado update(Long id, ArticuloManufacturadoDTO entity) throws Exception {
        try {
            return null;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            articuloManufacturadoRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
*/