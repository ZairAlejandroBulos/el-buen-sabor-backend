package com.utn.elbuensaborbackend.services;


import com.utn.elbuensaborbackend.dtos.*;
import com.utn.elbuensaborbackend.entities.*;
import com.utn.elbuensaborbackend.mappers.ArticuloInsumoMapper;
import com.utn.elbuensaborbackend.mappers.BaseMapper;
import com.utn.elbuensaborbackend.mappers.RubroMapper;
import com.utn.elbuensaborbackend.mappers.UnidadMedidaMapper;
import com.utn.elbuensaborbackend.repositories.*;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloInsumoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ArticuloInsumoServiceImpl
        extends BaseServiceImpl<ArticuloInsumo, ArticuloInsumoFullDTO, Long>
        implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    private ArticuloInsumoPrecioCompraRepository articuloInsumoPrecioCompraRepository;

    @Autowired
    private ArticuloInsumoStockMinimoRepository articuloInsumoStockMinimoRepository;

    @Autowired
    private ArticuloInsumoStockActualRepository articuloInsumoStockActualRepository;

    private final RubroMapper rubroMapper = RubroMapper.getInstance();

    private final UnidadMedidaMapper unidadMedidaMapper = UnidadMedidaMapper.getInstance();

    private final ArticuloInsumoMapper articuloInsumoMapper = ArticuloInsumoMapper.getInstance();

    public ArticuloInsumoServiceImpl(
            BaseRepository<ArticuloInsumo, Long> baseRepository,
            BaseMapper<ArticuloInsumo, ArticuloInsumoFullDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Override
    public List<ArticuloInsumoFullDTO> findAllArticuloInsumoFull() throws Exception{
        try {
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.findAll();
            List<ArticuloInsumoFullDTO> dtos = articuloInsumoMapper.toDTOsList(articuloInsumos);

            for (int i = 0; i < articuloInsumos.size(); i++) {
                // ArticuloInsumoPrecioCompra
                ArticuloInsumoPrecioCompra precioCompra = articuloInsumoPrecioCompraRepository.
                        findByInsumoId(articuloInsumos.get(i).getId());
                dtos.get(i).setPrecioCompra(precioCompra.getMonto());

                // ArticuloInsumoStockMinimo
                ArticuloInsumoStockMinimo stockMinimo = articuloInsumoStockMinimoRepository.
                        findByInsumoId(articuloInsumos.get(i).getId());
                dtos.get(i).setStockMinimo(stockMinimo.getStockMinimo());

                // ArticuloInsumoStockActual
                ArticuloInsumoStockActual stockActual = articuloInsumoStockActualRepository.
                        findByInsumoId(articuloInsumos.get(i).getId());
                dtos.get(i).setStockActual(stockActual.getStockActual());
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloInsumoFullDTO findArticuloInsumoFullById(Long id) throws Exception{
        try {
            ArticuloInsumo articuloInsumo = articuloInsumoRepository.findById(id).get();
            ArticuloInsumoFullDTO dto = articuloInsumoMapper.toDTO(articuloInsumo);

            // ArticuloInsumoPrecioCompra
            ArticuloInsumoPrecioCompra precioCompra = articuloInsumoPrecioCompraRepository.
                    findByInsumoId(articuloInsumo.getId());
            dto.setPrecioCompra(precioCompra.getMonto());

            // ArticuloInsumoStockMinimo
            ArticuloInsumoStockMinimo stockMinimo = articuloInsumoStockMinimoRepository.
                    findByInsumoId(articuloInsumo.getId());
            dto.setStockMinimo(stockMinimo.getStockMinimo());

            // ArticuloInsumoStockActual
            ArticuloInsumoStockActual stockActual = articuloInsumoStockActualRepository.
                    findByInsumoId(articuloInsumo.getId());
            dto.setStockActual(stockActual.getStockActual());

            return dto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloInsumoFullDTO saveArticuloInsumo(ArticuloInsumoFullDTO dto) throws Exception {
        try{
            ArticuloInsumo articuloInsumo = articuloInsumoMapper.toEntity(dto);
            articuloInsumo = articuloInsumoRepository.save(articuloInsumo);

            // ArticuloInsumoPrecioCompra
            ArticuloInsumoPrecioCompra precioCompraDB = articuloInsumoPrecioCompraRepository.findByInsumoId(articuloInsumo.getId());
            if (precioCompraDB != null ) {
                if (!Objects.equals(dto.getPrecioCompra(), precioCompraDB.getMonto())) {
                    articuloInsumoPrecioCompraRepository.save(new ArticuloInsumoPrecioCompra(
                            new Date(),
                            dto.getPrecioCompra(),
                            articuloInsumo));
                }
            } else {
                articuloInsumoPrecioCompraRepository.save(new ArticuloInsumoPrecioCompra(
                        new Date(),
                        dto.getPrecioCompra(),
                        articuloInsumo));
            }

            // ArticuloInsumoStockMinimo
            ArticuloInsumoStockMinimo stockMinimoDB = articuloInsumoStockMinimoRepository.findByInsumoId(articuloInsumo.getId());
            if (stockMinimoDB != null) {
                if (!Objects.equals(dto.getStockMinimo(), stockMinimoDB.getStockMinimo())) {
                    articuloInsumoStockMinimoRepository.save(new ArticuloInsumoStockMinimo(
                            dto.getStockMinimo(),
                            new Date(),
                            articuloInsumo));
                }
            } else {
                articuloInsumoStockMinimoRepository.save(new ArticuloInsumoStockMinimo(
                        dto.getStockMinimo(),
                        new Date(),
                        articuloInsumo));
            }

            // ArticuloInsumoStockActual
            ArticuloInsumoStockActual stockActualDB =
                    articuloInsumoStockActualRepository.findByInsumoId(articuloInsumo.getId());
            if (stockActualDB == null) {
                articuloInsumoStockActualRepository.save(new ArticuloInsumoStockActual(
                        dto.getStockActual(),
                        new Date(),
                        articuloInsumo
                ));
            } else {
                stockActualDB.setStockActual(dto.getStockActual());
                stockActualDB.setFecha(new Date());
                stockActualDB.setArticuloInsumo(articuloInsumo);
                articuloInsumoStockActualRepository.save(stockActualDB);
            }

            return articuloInsumoMapper.toDTO(articuloInsumo);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloInsumoFullDTO updateArticuloInsumo(Long id, ArticuloInsumoFullDTO dto) throws Exception{
        try {
            Optional<ArticuloInsumo> optional = articuloInsumoRepository.findById(id);

            if (optional.isEmpty()) {
                throw new Exception("El Articulo Insumo a actualizar no existe.");
            }

            ArticuloInsumo articuloInsumo = optional.get();
            articuloInsumo.setDenominacion(dto.getDenominacion());
            articuloInsumo.setEsInsumo(dto.getEsInsumo());
            articuloInsumo.setRubro(rubroMapper.toEntity(dto.getRubro()));
            articuloInsumo.setUnidadMedida(unidadMedidaMapper.toEntity(dto.getUnidadMedida()));
            articuloInsumo = articuloInsumoRepository.save(articuloInsumo);

            // ArticuloInsumoPrecioCompra
            ArticuloInsumoPrecioCompra precioCompraDB = articuloInsumoPrecioCompraRepository.findByInsumoId(articuloInsumo.getId());
            if (precioCompraDB != null ) {
                if (!Objects.equals(dto.getPrecioCompra(), precioCompraDB.getMonto())) {
                    articuloInsumoPrecioCompraRepository.save(new ArticuloInsumoPrecioCompra(
                            new Date(),
                            dto.getPrecioCompra(),
                            articuloInsumo));
                }
            } else {
                articuloInsumoPrecioCompraRepository.save(new ArticuloInsumoPrecioCompra(
                        new Date(),
                        dto.getPrecioCompra(),
                        articuloInsumo));
            }

            // ArticuloInsumoStockMinimo
            ArticuloInsumoStockMinimo stockMinimoDB = articuloInsumoStockMinimoRepository.findByInsumoId(articuloInsumo.getId());
            if (stockMinimoDB != null) {
                if (!Objects.equals(dto.getStockMinimo(), stockMinimoDB.getStockMinimo())) {
                    articuloInsumoStockMinimoRepository.save(new ArticuloInsumoStockMinimo(
                            dto.getStockMinimo(),
                            new Date(),
                            articuloInsumo));
                }
            } else {
                articuloInsumoStockMinimoRepository.save(new ArticuloInsumoStockMinimo(
                        dto.getStockMinimo(),
                        new Date(),
                        articuloInsumo));
            }

            // ArticuloInsumoStockActual
            ArticuloInsumoStockActual stockActualDB =
                    articuloInsumoStockActualRepository.findByInsumoId(articuloInsumo.getId());
            if (stockActualDB == null) {
                articuloInsumoStockActualRepository.save(new ArticuloInsumoStockActual(
                        dto.getStockActual(),
                        new Date(),
                        articuloInsumo
                ));
            } else {
                stockActualDB.setStockActual(dto.getStockActual());
                stockActualDB.setFecha(new Date());
                stockActualDB.setArticuloInsumo(articuloInsumo);
                articuloInsumoStockActualRepository.save(stockActualDB);
            }

            return articuloInsumoMapper.toDTO(articuloInsumo);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }



    /*@Override
    public List<ArticuloInsumoDTO> findBebidas() throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.findBebidas();
            List<ArticuloInsumoDTO> articuloInsumoDTOs = new ArrayList<>();

            for (ArticuloInsumo ai : articuloInsumo) {
                ArticuloInsumoDTO articuloInsumoDTO = new ArticuloInsumoDTO();
                articuloInsumoDTO.setId(ai.getId());
                articuloInsumoDTO.setEsInsumo(ai.getEsInsumo());
                articuloInsumoDTO.setDenominacion(ai.getDenominacion());

                //PRECIO COMPRA
                ArticuloInsumoPrecioCompra precioCompra = articuloInsumoPrecioCompraRepository.findByInsumoId(ai.getId());
                ArticuloInsumoPrecioCompraDTO precioCompraDTO = new ArticuloInsumoPrecioCompraDTO();

                precioCompraDTO.setId(precioCompra.getId());
                precioCompraDTO.setFecha(precioCompra.getFecha());
                precioCompraDTO.setMonto(precioCompra.getMonto());


                //STOCK MINIMO
                ArticuloInsumoStockMinimo articuloInsumoStockMinimo =
                        articuloInsumoStockMinimoRepository.findByInsumoId(ai.getId());
                ArticuloInsumoStockMinimoDTO articuloInsumoStockMinimoDTO =
                        new ArticuloInsumoStockMinimoDTO();

                articuloInsumoStockMinimoDTO.setId(articuloInsumoStockMinimo.getId());
                articuloInsumoStockMinimoDTO.setStockMinimo(articuloInsumoStockMinimo.getStockMinimo());
                articuloInsumoStockMinimoDTO.setFecha(articuloInsumoStockMinimo.getFecha());

                //STOCK ACTUAL
                ArticuloInsumoStockActual articuloInsumoStockActual =
                        articuloInsumoStockActualRepository.findByInsumoId(ai.getId());
                ArticuloInsumoStockActualDTO articuloInsumoStockActualDTO =
                        new ArticuloInsumoStockActualDTO();

                articuloInsumoStockActualDTO.setId(articuloInsumoStockActual.getId());
                articuloInsumoStockActualDTO.setStockActual(articuloInsumoStockActual.getStockActual());
                articuloInsumoStockActualDTO.setFecha(articuloInsumoStockActual.getFecha());
                //UNIDAD MEDIDA
                UnidadMedida unidadMedida =
                        unidadMedidaRepository.findByInsumoId(ai.getId());

                UnidadMedidaDTO unidadMedidaDTO =
                        new UnidadMedidaDTO();

                unidadMedidaDTO.setId(unidadMedida.getId());
                unidadMedidaDTO.setDenominacion(unidadMedida.getDenominacion());

                articuloInsumoDTO.setArticuloInsumoPrecioCompra(precioCompraDTO);
                articuloInsumoDTO.setArticuloInsumoStockActual(articuloInsumoStockActualDTO);
                articuloInsumoDTO.setArticuloInsumoStockMinimo(articuloInsumoStockMinimoDTO);
                articuloInsumoDTO.setUnidadMedida(unidadMedidaDTO);

                articuloInsumoDTOs.add(articuloInsumoDTO);
            }

            return articuloInsumoDTOs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }*/
}
