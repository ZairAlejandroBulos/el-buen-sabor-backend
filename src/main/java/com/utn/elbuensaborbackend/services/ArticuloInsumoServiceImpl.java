package com.utn.elbuensaborbackend.services;

/*
import com.utn.elbuensaborbackend.dtos.*;
import com.utn.elbuensaborbackend.entities.*;
import com.utn.elbuensaborbackend.repositories.*;
import com.utn.elbuensaborbackend.services.interfaces.ArticuloInsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ArticuloInsumoServiceImpl implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    private ArticuloInsumoPrecioCompraRepository articuloInsumoPrecioCompraRepository;

    @Autowired
    private ArticuloInsumoStockMinimoRepository articuloInsumoStockMinimoRepository;

    @Autowired
    private ArticuloInsumoStockActualRepository articuloInsumoStockActualRepository;

    @Autowired
    private UnidadMedidaRepository unidadMedidaRepository;

    @Override
    public List<ArticuloInsumoDTO> findAll() throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumo = articuloInsumoRepository.findAll();
            List<ArticuloInsumoDTO> articuloInsumoDTOs = new ArrayList<>();

            for (ArticuloInsumo ai : articuloInsumo) {
                ArticuloInsumoDTO articuloInsumoDTO = new ArticuloInsumoDTO();
                articuloInsumoDTO.setId(ai.getId());
                articuloInsumoDTO.setEsInsumo(ai.getEsInsumo());
                articuloInsumoDTO.setDenominacion(ai.getDenominacion());

                //PRECIO COMPRA
                ArticuloInsumoPrecioCompra precioCompra =
                        articuloInsumoPrecioCompraRepository.findByInsumoId(ai.getId());
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
            throw new Exception(e.getMessage());
        }
    }

    @Override
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
    }

    @Override
    public ArticuloInsumoDTO findById(Long id) throws Exception {
        try {
            ArticuloInsumo articuloInsumo = articuloInsumoRepository.findById(id).get();
            ArticuloInsumoDTO articuloInsumoDTO = new ArticuloInsumoDTO();

            articuloInsumoDTO.setId(articuloInsumo.getId());
            articuloInsumoDTO.setEsInsumo(articuloInsumo.getEsInsumo());
            articuloInsumoDTO.setDenominacion(articuloInsumo.getDenominacion());

            //PRECIO COMPRA
            ArticuloInsumoPrecioCompra precioCompra =
                    articuloInsumoPrecioCompraRepository.findByInsumoId(articuloInsumo.getId());
            ArticuloInsumoPrecioCompraDTO precioCompraDTO =
                    new ArticuloInsumoPrecioCompraDTO();

            precioCompraDTO.setId(precioCompra.getId());
            precioCompraDTO.setFecha(precioCompra.getFecha());
            precioCompraDTO.setMonto(precioCompra.getMonto());

            //STOCK MINIMO
            ArticuloInsumoStockMinimo articuloInsumoStockMinimo =
                    articuloInsumoStockMinimoRepository.findByInsumoId(articuloInsumo.getId());
            ArticuloInsumoStockMinimoDTO articuloInsumoStockMinimoDTO =
                    new ArticuloInsumoStockMinimoDTO();

            articuloInsumoStockMinimoDTO.setId(articuloInsumoStockMinimo.getId());
            articuloInsumoStockMinimoDTO.setStockMinimo(articuloInsumoStockMinimo.getStockMinimo());
            articuloInsumoStockMinimoDTO.setFecha(articuloInsumoStockMinimo.getFecha());

            //STOCK ACTUAL
            ArticuloInsumoStockActual articuloInsumoStockActual =
                    articuloInsumoStockActualRepository.findByInsumoId(articuloInsumo.getId());
            ArticuloInsumoStockActualDTO articuloInsumoStockActualDTO =
                    new ArticuloInsumoStockActualDTO();

            articuloInsumoStockActualDTO.setId(articuloInsumoStockActual.getId());
            articuloInsumoStockActualDTO.setStockActual(articuloInsumoStockActual.getStockActual());
            articuloInsumoStockActualDTO.setFecha(articuloInsumoStockActual.getFecha());

            //UNIDAD MEDIDA
            UnidadMedida unidadMedida =
                    unidadMedidaRepository.findByInsumoId(articuloInsumo.getId());
            UnidadMedidaDTO unidadMedidaDTO =
                    new UnidadMedidaDTO();

            unidadMedidaDTO.setId(unidadMedida.getId());
            unidadMedidaDTO.setDenominacion(unidadMedida.getDenominacion());

            articuloInsumoDTO.setArticuloInsumoPrecioCompra(precioCompraDTO);
            articuloInsumoDTO.setArticuloInsumoStockActual(articuloInsumoStockActualDTO);
            articuloInsumoDTO.setArticuloInsumoStockMinimo(articuloInsumoStockMinimoDTO);
            articuloInsumoDTO.setUnidadMedida(unidadMedidaDTO);

            return articuloInsumoDTO;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloInsumo save(ArticuloInsumoDTO entity) throws Exception {
        try {
            ArticuloInsumo articuloInsumo = new ArticuloInsumo();
            articuloInsumo.setDenominacion(entity.getDenominacion());
            articuloInsumo.setEsInsumo(entity.getEsInsumo());

            ArticuloInsumo savedArticuloInsumo = articuloInsumoRepository.save(articuloInsumo);

            ArticuloInsumoPrecioCompraDTO precioCompraDTO = entity.getArticuloInsumoPrecioCompra();
            ArticuloInsumoPrecioCompra precioCompra = new ArticuloInsumoPrecioCompra();
            precioCompra.setFecha(precioCompraDTO.getFecha());
            precioCompra.setMonto(precioCompraDTO.getMonto());
            precioCompra.setArticuloInsumo(savedArticuloInsumo);

            articuloInsumoPrecioCompraRepository.save(precioCompra);


            ArticuloInsumoStockMinimoDTO stockMinimoDTO = entity.getArticuloInsumoStockMinimo();
            ArticuloInsumoStockMinimo stockMinimo = new ArticuloInsumoStockMinimo();
            stockMinimo.setFecha(stockMinimoDTO.getFecha());
            stockMinimo.setStockMinimo(stockMinimoDTO.getStockMinimo());
            stockMinimo.setArticuloInsumo(savedArticuloInsumo);

            articuloInsumoStockMinimoRepository.save(stockMinimo);


            ArticuloInsumoStockActualDTO stockActualDTO = entity.getArticuloInsumoStockActual();
            ArticuloInsumoStockActual stockActual = new ArticuloInsumoStockActual();
            stockActual.setFecha(stockMinimoDTO.getFecha());
            stockActual.setStockActual(stockActualDTO.getStockActual());
            stockActual.setArticuloInsumo(savedArticuloInsumo);

            articuloInsumoStockActualRepository.save(stockActual);


            UnidadMedidaDTO unidadMedidaDTO = entity.getUnidadMedida();
            UnidadMedida unidadMedida = new UnidadMedida();
            unidadMedida.setDenominacion(unidadMedidaDTO.getDenominacion());

            unidadMedidaRepository.save(unidadMedida);


            return savedArticuloInsumo;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloInsumo update(Long id, ArticuloInsumoDTO entity) throws Exception {
        try {
            Optional<ArticuloInsumo> optionalArticuloInsumo = articuloInsumoRepository.findById(id);

            if (optionalArticuloInsumo.isPresent()) {
                ArticuloInsumo articuloInsumo = optionalArticuloInsumo.get();
                articuloInsumo.setDenominacion(entity.getDenominacion());
                articuloInsumo.setEsInsumo(entity.getEsInsumo());


                // Actualizar el precio de compra
                ArticuloInsumoPrecioCompraDTO precioCompraDTO = entity.getArticuloInsumoPrecioCompra();
                ArticuloInsumoPrecioCompra precioCompra = articuloInsumoPrecioCompraRepository
                        .findByInsumoId(id);

                if (precioCompra != null) {
                    precioCompra.setFecha(precioCompraDTO.getFecha());
                    precioCompra.setMonto(precioCompraDTO.getMonto());
                } else {
                    precioCompra = new ArticuloInsumoPrecioCompra();
                    precioCompra.setFecha(precioCompraDTO.getFecha());
                    precioCompra.setMonto(precioCompraDTO.getMonto());
                    precioCompra.setArticuloInsumo(articuloInsumo);
                }

                articuloInsumoPrecioCompraRepository.save(precioCompra);

                // Actualizar el stock minimo
                ArticuloInsumoStockMinimoDTO stockMinimoDTO = entity.getArticuloInsumoStockMinimo();
                ArticuloInsumoStockMinimo stockMinimo = articuloInsumoStockMinimoRepository
                        .findByInsumoId(id);

                if (stockMinimo != null) {
                    stockMinimo.setFecha(stockMinimoDTO.getFecha());
                    stockMinimo.setStockMinimo(stockMinimoDTO.getStockMinimo());
                } else {
                    stockMinimo = new ArticuloInsumoStockMinimo();
                    stockMinimo.setFecha(stockMinimoDTO.getFecha());
                    stockMinimo.setStockMinimo(stockMinimoDTO.getStockMinimo());
                    stockMinimo.setArticuloInsumo(articuloInsumo);
                }

                articuloInsumoStockMinimoRepository.save(stockMinimo);

                // Actualizar el Stock Actual
                ArticuloInsumoStockActualDTO stockActualDTO = entity.getArticuloInsumoStockActual();
                ArticuloInsumoStockActual stockActual = articuloInsumoStockActualRepository
                        .findByInsumoId(id);

                if (stockActual != null) {
                    stockActual.setFecha(stockActualDTO.getFecha());
                    stockActual.setStockActual(stockActualDTO.getStockActual());
                } else {
                    stockActual = new ArticuloInsumoStockActual();
                    stockActual.setFecha(stockActualDTO.getFecha());
                    stockActual.setStockActual(stockActualDTO.getStockActual());
                    stockActual.setArticuloInsumo(articuloInsumo);
                }

                articuloInsumoStockActualRepository.save(stockActual);

                // Actualizar la Unidad Medida
                UnidadMedidaDTO unidadMedidaDTO = entity.getUnidadMedida();
                UnidadMedida unidadMedida = unidadMedidaRepository
                        .findByInsumoId(id);

                if (unidadMedida != null) {
                    unidadMedida.setDenominacion(unidadMedidaDTO.getDenominacion());
                } else {
                    unidadMedida = new UnidadMedida();
                    unidadMedida.setDenominacion(unidadMedidaDTO.getDenominacion());
                }

                unidadMedidaRepository.save(unidadMedida);

                return articuloInsumoRepository.save(articuloInsumo);
            } else {
                throw new Exception("Articulo Insumo no se encontro con el siguiente Id: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            Optional<ArticuloInsumo> optionalArticuloInsumo = articuloInsumoRepository.findById(id);

            if (optionalArticuloInsumo.isPresent()) {

                ArticuloInsumoStockMinimo stockMinimo = articuloInsumoStockMinimoRepository
                        .findByInsumoId(id);
                if (stockMinimo != null) {
                    articuloInsumoStockMinimoRepository.delete(stockMinimo);
                }

                ArticuloInsumoStockActual stockActual = articuloInsumoStockActualRepository
                        .findByInsumoId(id);
                if (stockActual != null) {
                    articuloInsumoStockActualRepository.delete(stockActual);
                }

                ArticuloInsumoPrecioCompra precioCompra = articuloInsumoPrecioCompraRepository
                        .findByInsumoId(id);
                if (precioCompra != null) {
                    articuloInsumoPrecioCompraRepository.delete(precioCompra);
                }

                UnidadMedida unidadMedida = unidadMedidaRepository
                        .findByInsumoId(id);
                if (unidadMedida != null) {
                    unidadMedidaRepository.delete(unidadMedida);
                }

                articuloInsumoRepository.deleteById(id);
            } else {
                throw new Exception("Articulo Insumo no se encontro el siguiente ID: " + id);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

}
*/