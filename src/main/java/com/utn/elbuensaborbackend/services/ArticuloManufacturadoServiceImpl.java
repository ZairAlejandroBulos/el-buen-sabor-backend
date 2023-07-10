package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoDTO;
import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoFullDTO;
import com.utn.elbuensaborbackend.entities.*;
import com.utn.elbuensaborbackend.mappers.*;
import com.utn.elbuensaborbackend.repositories.*;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoService;
import com.utn.elbuensaborbackend.services.interfaces.ImagenService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class ArticuloManufacturadoServiceImpl
        extends BaseServiceImpl<ArticuloManufacturado, ArticuloManufacturadoFullDTO, Long>
        implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private ArticuloManufacturadoPrecioVentaRepository precioVentaRepository;

    @Autowired
    private ImagenService imagenService;

    @Autowired
    private DetalleArticuloManufacturadoRepository detalleRepository;
    
    private final ArticuloManufacturadoMapper articuloManufacturadoMapper = ArticuloManufacturadoMapper.getInstance();

    private final RubroMapper rubroMapper = RubroMapper.getInstance();

    private final DetalleArticuloManufacturadoMapper detalleMapper = DetalleArticuloManufacturadoMapper.getInstance();

    public ArticuloManufacturadoServiceImpl(
            BaseRepository<ArticuloManufacturado, Long> baseRepository,
            BaseMapper<ArticuloManufacturado, ArticuloManufacturadoFullDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Override
    public List<ArticuloManufacturadoFullDTO> findAll() throws Exception {
        try {
            List<ArticuloManufacturado> articulosManufacturados = articuloManufacturadoRepository.findAll();
            List<ArticuloManufacturadoFullDTO> dtos = articuloManufacturadoMapper.toDTOsList(articulosManufacturados);

            for (ArticuloManufacturado articuloManufacturado : articulosManufacturados) {
                // Precio Venta
                Double precioVenta = precioVentaRepository.findLastByManufacturado(articuloManufacturado.getId());
                dtos.get(articulosManufacturados.indexOf(articuloManufacturado)).setPrecioVenta(precioVenta);
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

            // Precio Venta
            Double precioVenta = precioVentaRepository.findLastByManufacturado(id);
            dto.setPrecioVenta(precioVenta);

            return dto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturadoDTO> findAllSimple() throws Exception {
        try {
            List<ArticuloManufacturado> articulosManufacturados = articuloManufacturadoRepository.findAll();
            List<ArticuloManufacturadoDTO> dtos = articuloManufacturadoMapper.toSimpleDTOsList(articulosManufacturados);

            for (ArticuloManufacturado articuloManufacturado : articulosManufacturados) {
                // Precio Venta
                Double precioVenta = precioVentaRepository.findLastByManufacturado(articuloManufacturado.getId());
                dtos.get(articulosManufacturados.indexOf(articuloManufacturado)).setPrecioVenta(precioVenta);
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

            // Precio Venta
            Double precioVenta = precioVentaRepository.findLastByManufacturado(id);
            dto.setPrecioVenta(precioVenta);

            return dto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturadoDTO> findByTermino(String termino) throws Exception {
        try {
            List<ArticuloManufacturado> articulosManufacturados = articuloManufacturadoRepository.findByTermino(termino);
            List<ArticuloManufacturadoDTO> dtos = articuloManufacturadoMapper.toSimpleDTOsList(articulosManufacturados);

            for (ArticuloManufacturado articuloManufacturado : articulosManufacturados) {
                // Precio Venta
                Double precioVenta = precioVentaRepository.findLastByManufacturado(articuloManufacturado.getId());
                dtos.get(articulosManufacturados.indexOf(articuloManufacturado)).setPrecioVenta(precioVenta);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturado saveFull(ArticuloManufacturadoFullDTO dto, MultipartFile file) throws Exception {
        try {
            imagenService.saveImagen(file, dto.getImagen());

            ArticuloManufacturado articuloManufacturado = articuloManufacturadoMapper.toEntity(dto);
            articuloManufacturado = articuloManufacturadoRepository.save(articuloManufacturado);

            return articuloManufacturado;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloManufacturado updateFull(Long id, ArticuloManufacturadoFullDTO dto, MultipartFile file) throws Exception {
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

            // Receta
            Receta receta = articuloManufacturado.getReceta();
            receta.setDescripcion(dto.getReceta());
            articuloManufacturado.setReceta(receta);

            // Imagen
            Imagen imagenDB = imagenRepository.findByManufacturadoId(id);
            if (!Objects.equals(imagenDB.getNombre(), dto.getImagen())) {
                if (file != null) {
                    imagenService.deleteImagen(imagenDB.getNombre());
                    imagenService.saveImagen(file, dto.getImagen());

                    imagenDB.setNombre(dto.getImagen());
                    articuloManufacturado.setImagen(imagenDB);
                }
            }

            // Precio Venta
            Double precioVentaDB = precioVentaRepository.findLastByManufacturado(id);
            if (!Objects.equals(precioVentaDB, dto.getPrecioVenta())) {
                ArticuloManufacturadoPrecioVenta precioVenta = new ArticuloManufacturadoPrecioVenta(
                        new Date(), dto.getPrecioVenta(), articuloManufacturado
                );
                articuloManufacturado.getPreciosVentas().add(precioVenta);
            }

            // Detalles
            List<DetalleArticuloManufacturado> detallesDB = articuloManufacturado.getDetalles();
            List<DetalleArticuloManufacturado> detalles = detalleMapper.toEntitiesList(dto.getDetalles());

            ArticuloManufacturado finalArticuloManufacturado = articuloManufacturado;
            detalles.forEach(detalle -> detalle.setArticuloManufacturado(finalArticuloManufacturado));
            deleteDetalles(detallesDB, detalles);
            articuloManufacturado.setDetalles(detalles);

            articuloManufacturado = articuloManufacturadoRepository.save(articuloManufacturado);

            return articuloManufacturado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private void deleteDetalles(List<DetalleArticuloManufacturado> detallesDB, List<DetalleArticuloManufacturado> detalles) {
        List<DetalleArticuloManufacturado> detallesEliminar = new ArrayList<>(detallesDB);

        for (DetalleArticuloManufacturado detalle : detalles) {
            detallesEliminar.removeIf(detalleDB -> Objects.equals(detalleDB.getId(), detalle.getId()));
        }

        detalleRepository.deleteAll(detallesEliminar);
    }

}
