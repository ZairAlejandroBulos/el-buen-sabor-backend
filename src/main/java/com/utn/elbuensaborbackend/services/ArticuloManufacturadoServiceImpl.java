package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoDTO;
import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoFullDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoPrecioVenta;
import com.utn.elbuensaborbackend.entities.Imagen;
import com.utn.elbuensaborbackend.entities.Receta;
import com.utn.elbuensaborbackend.mappers.ArticuloManufacturadoMapper;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.mappers.RubroMapper;
import com.utn.elbuensaborbackend.repositories.*;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoService;
import com.utn.elbuensaborbackend.services.interfaces.ImagenService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArticuloManufacturadoServiceImpl
        extends BaseServiceImpl<ArticuloManufacturado, ArticuloManufacturadoFullDTO, Long>
        implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private ArticuloManufacturadoPrecioVentaRepository articuloManufacturadoPrecioVentaRepository;

    @Autowired
    private RecetaRepository recetaRepository;
    
    @Autowired
    private ImagenService imagenService;
    
    private final ArticuloManufacturadoMapper articuloManufacturadoMapper = ArticuloManufacturadoMapper.getInstance();

    private final RubroMapper rubroMapper = RubroMapper.getInstance();

    public ArticuloManufacturadoServiceImpl(
            BaseRepository<ArticuloManufacturado, Long> baseRepository,
            BaseMapper<ArticuloManufacturado, ArticuloManufacturadoFullDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Override
    public List<ArticuloManufacturadoFullDTO> findAll() throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.findAll();
            List<ArticuloManufacturadoFullDTO> dtos = articuloManufacturadoMapper.toDTOsList(articuloManufacturados);

            for (int i = 0; i < articuloManufacturados.size(); i++) {
                // ArticuloManufacturadoPrecioVenta
                ArticuloManufacturadoPrecioVenta precioVenta = articuloManufacturadoPrecioVentaRepository.
                        findByArticuloManufacturadoId(articuloManufacturados.get(i).getId());
                dtos.get(i).setPrecioVenta(precioVenta.getPrecioVenta());

                // Imagen
                Imagen imagen = imagenRepository.findByArticuloManufacturadoId(articuloManufacturados.get(i).getId());
                dtos.get(i).setImagen(imagen.getNombre());

                // Receta
                Receta receta = recetaRepository.findByArticuloManufacturadoId(articuloManufacturados.get(i).getId());
                dtos.get(i).setReceta(receta.getDescripcion());
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloManufacturadoFullDTO findById(Long id) throws Exception {
        try {
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoRepository.findById(id).get();
            ArticuloManufacturadoFullDTO dto = articuloManufacturadoMapper.toDTO(articuloManufacturado);

            // ArticuloManufacturadoPrecioVenta
            ArticuloManufacturadoPrecioVenta precioVenta = articuloManufacturadoPrecioVentaRepository.
                    findByArticuloManufacturadoId(id);
            dto.setPrecioVenta(precioVenta.getPrecioVenta());

            // Imagen
            Imagen imagen = imagenRepository.findByArticuloManufacturadoId(id);
            dto.setImagen(imagen.getNombre());

            // Receta
            Receta receta = recetaRepository.findByArticuloManufacturadoId(id);
            dto.setReceta(receta.getDescripcion());

            return dto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturadoDTO> findAllSimple() throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.findAll();
            List<ArticuloManufacturadoDTO> dtos = articuloManufacturadoMapper.toSimpleDTOsList(articuloManufacturados);

            for (int i = 0; i < articuloManufacturados.size(); i++) {
                // ArticuloManufacturadoPrecioVenta
                ArticuloManufacturadoPrecioVenta precioVenta = articuloManufacturadoPrecioVentaRepository.
                        findByArticuloManufacturadoId(articuloManufacturados.get(i).getId());
                dtos.get(i).setPrecioVenta(precioVenta.getPrecioVenta());

                // Imagen
                Imagen imagen = imagenRepository.findByArticuloManufacturadoId(articuloManufacturados.get(i).getId());
                dtos.get(i).setImagen(imagen.getNombre());
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloManufacturadoDTO findSimpleById(Long id) throws Exception {
        try {
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoRepository.findById(id).get();
            ArticuloManufacturadoDTO dto = articuloManufacturadoMapper.toSimpleDTO(articuloManufacturado);

            // ArticuloManufacturadoPrecioVenta
            ArticuloManufacturadoPrecioVenta precioVenta = articuloManufacturadoPrecioVentaRepository.
                    findByArticuloManufacturadoId(articuloManufacturado.getId());
            dto.setPrecioVenta(precioVenta.getPrecioVenta());

            // Imagen
            Imagen imagen = imagenRepository.findByArticuloManufacturadoId(articuloManufacturado.getId());
            dto.setImagen(imagen.getNombre());

            return dto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturadoDTO> findByTermino(String termino) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.findByTermino(termino);
            List<ArticuloManufacturadoDTO> dtos = articuloManufacturadoMapper.toSimpleDTOsList(articuloManufacturados);

            for (int i = 0; i < articuloManufacturados.size(); i++) {
                // ArticuloManufacturadoPrecioVenta
                ArticuloManufacturadoPrecioVenta precioVenta = articuloManufacturadoPrecioVentaRepository.
                        findByArticuloManufacturadoId(articuloManufacturados.get(i).getId());
                dtos.get(i).setPrecioVenta(precioVenta.getPrecioVenta());

                // Imagen
                Imagen imagen = imagenRepository.findByArticuloManufacturadoId(articuloManufacturados.get(i).getId());
                dtos.get(i).setImagen(imagen.getNombre());
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturado save(ArticuloManufacturadoFullDTO dto) throws Exception {
        try {
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoMapper.toEntity(dto);
            articuloManufacturado = articuloManufacturadoRepository.save(articuloManufacturado);

            // Imagen
            Imagen imagen = new Imagen(dto.getImagen(), articuloManufacturado);
            imagenRepository.save(imagen);

            // ArticuloManufacturadoPrecioVenta
            ArticuloManufacturadoPrecioVenta precioVenta = new ArticuloManufacturadoPrecioVenta(
                    dto.getPrecioVenta(),
                    new Date(),
                    articuloManufacturado
            );
            articuloManufacturadoPrecioVentaRepository.save(precioVenta);

            // Receta
            Receta receta = new Receta(dto.getReceta(), articuloManufacturado);
            recetaRepository.save(receta);

            return articuloManufacturado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturado update(Long id, ArticuloManufacturadoFullDTO dto) throws Exception {
        try {
            Optional<ArticuloManufacturado> optional = articuloManufacturadoRepository.findById(id);

            if (optional.isEmpty()) {
                throw new Exception("El Artículo Manufacturado a actualizar no existe.");
            }

            ArticuloManufacturado articuloManufacturado = optional.get();
            articuloManufacturado.setDenominacion(dto.getDenominacion());
            articuloManufacturado.setDescripcion(dto.getDescripcion());
            articuloManufacturado.setTiempoEstimadoCocina(dto.getTiempoEstimadoCocina());
            articuloManufacturado.setRubro(rubroMapper.toEntity(dto.getRubro()));
            articuloManufacturado = articuloManufacturadoRepository.save(articuloManufacturado);

            // Imagen
            Imagen imagenDB = imagenRepository.findByArticuloManufacturadoId(articuloManufacturado.getId());
            if (imagenDB != null) {
                if (!Objects.equals(dto.getImagen(), imagenDB.getNombre())) {
                    imagenService.deleteImagen(imagenDB.getNombre());

                    imagenDB.setNombre(dto.getImagen());
                    imagenRepository.save(imagenDB);
                }
            } else {
                Imagen imagen = new Imagen(dto.getImagen(), articuloManufacturado);
                imagenRepository.save(imagen);
            }

            // ArticuloManufacturadoPrecioVenta
            ArticuloManufacturadoPrecioVenta precioVentaDB =
                    articuloManufacturadoPrecioVentaRepository.findByArticuloManufacturadoId(articuloManufacturado.getId());
            if (precioVentaDB != null) {
                if (!Objects.equals(dto.getPrecioVenta(), precioVentaDB.getPrecioVenta())) {
                    ArticuloManufacturadoPrecioVenta precioVenta = new ArticuloManufacturadoPrecioVenta(
                            dto.getPrecioVenta(),
                            new Date(),
                            articuloManufacturado
                    );
                    articuloManufacturadoPrecioVentaRepository.save(precioVenta);
                }
            } else {
                ArticuloManufacturadoPrecioVenta precioVenta = new ArticuloManufacturadoPrecioVenta(
                        dto.getPrecioVenta(),
                        new Date(),
                        articuloManufacturado
                );
                articuloManufacturadoPrecioVentaRepository.save(precioVenta);
            }

            // Receta
            Receta receta = recetaRepository.findByArticuloManufacturadoId(id);
            receta.setDescripcion(dto.getReceta());
            recetaRepository.save(receta);

            return articuloManufacturado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
