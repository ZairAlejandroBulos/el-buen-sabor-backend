package com.utn.elbuensaborbackend.services;


import com.utn.elbuensaborbackend.dtos.ArticuloManufacturadoDTO;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoPrecioVenta;
import com.utn.elbuensaborbackend.entities.Imagen;
import com.utn.elbuensaborbackend.mappers.ArticuloManufacturadoMapper;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.repositories.ArticuloManufacturadoPrecioVentaRepository;
import com.utn.elbuensaborbackend.repositories.ArticuloManufacturadoRepository;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.ImagenRepository;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoPrecioVentaService;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloManufacturadoService;
import com.utn.elbuensaborbackend.services.interfaces.ImagenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, ArticuloManufacturadoDTO, Long> implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Autowired
    private ImagenRepository imagenRepository;

    @Autowired
    private ArticuloManufacturadoPrecioVentaRepository articuloManufacturadoPrecioVentaRepository;

    @Autowired
    private ArticuloManufacturadoPrecioVentaService articuloManufacturadoPrecioVentaService;

    @Autowired
    private ImagenService imagenService;

    private final ArticuloManufacturadoMapper articuloManufacturadoMapper = ArticuloManufacturadoMapper.getInstance();

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, BaseMapper<ArticuloManufacturado, ArticuloManufacturadoDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Override
    public List<ArticuloManufacturadoDTO> findAllArticuloManufacturado() throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.findAll();
            List<ArticuloManufacturadoDTO> dtos = articuloManufacturadoMapper.toDTOsList(articuloManufacturados);

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
    public ArticuloManufacturadoDTO findByIdArticuloManufacturado(Long id) throws Exception {
        try {
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoRepository.findById(id).get();
            ArticuloManufacturadoDTO dto = articuloManufacturadoMapper.toDTO(articuloManufacturado);

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
            List<ArticuloManufacturadoDTO> dtos = articuloManufacturadoMapper.toDTOsList(articuloManufacturados);

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

    /*@Override
    @Transactional
    public ArticuloManufacturado saveArticuloManufacturado(ArticuloManufacturadoDTO dto) throws Exception {
        try {
            ArticuloManufacturado articuloManufacturado = articuloManufacturadoMapper.toEntity(dto);

            articuloManufacturado = articuloManufacturadoRepository.save(articuloManufacturado);


            ArticuloManufacturadoPrecioVentaDTO articuloManufacturadoPrecioVentaDTO = dto.getArticuloManufacturadoPrecioVenta();
            if(articuloManufacturadoPrecioVentaDTO != null && articuloManufacturadoPrecioVentaDTO.getId() == null){
                ArticuloManufacturadoPrecioVenta articuloManufacturadoPrecioVenta =
                        articuloManufacturadoPrecioVentaMapper.toEntity(articuloManufacturadoPrecioVentaDTO);
                articuloManufacturadoPrecioVenta.setArticuloManufacturado(articuloManufacturado);
                articuloManufacturadoPrecioVentaService.saveArticuloManufacturadoPrecioVenta(articuloManufacturadoPrecioVenta);
            }

            ImagenDTO imagenDTO = dto.getImagen();
            if(imagenDTO != null && imagenDTO.getId() == null){
                Imagen imagen = imagenMapper.toEntity(imagenDTO);
                imagen.setArticuloManufacturado(articuloManufacturado);
                imagenService.saveImagen(imagen);
            }

            return articuloManufacturado;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }*/

}
