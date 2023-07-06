package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.ArticuloInsumoFullDTO;
import com.utn.elbuensaborbackend.entities.ArticuloInsumo;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoPrecioCompra;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoStockActual;
import com.utn.elbuensaborbackend.entities.ArticuloInsumoStockMinimo;
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
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, ArticuloInsumoFullDTO, Long>
        implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    @Autowired
    private ArticuloInsumoPrecioCompraRepository precioCompraRepository;

    @Autowired
    private ArticuloInsumoStockMinimoRepository stockMinimoRepository;

    @Autowired
    private ArticuloInsumoStockActualRepository stockActualRepository;

    private final RubroMapper rubroMapper = RubroMapper.getInstance();

    private final UnidadMedidaMapper unidadMedidaMapper = UnidadMedidaMapper.getInstance();

    private final ArticuloInsumoMapper articuloInsumoMapper = ArticuloInsumoMapper.getInstance();

    public ArticuloInsumoServiceImpl(
            BaseRepository<ArticuloInsumo, Long> baseRepository,
            BaseMapper<ArticuloInsumo, ArticuloInsumoFullDTO> baseMapper) {
        super(baseRepository, baseMapper);
    }

    @Override
    public List<ArticuloInsumoFullDTO> findAll() throws Exception {
        try {
            List<ArticuloInsumo> articulosInsumos = articuloInsumoRepository.findAll();
            List<ArticuloInsumoFullDTO> dtos = articuloInsumoMapper.toDTOsList(articulosInsumos);

            for (ArticuloInsumo articuloInsumo : articulosInsumos) {
                // Precio Compra
                Double precioCompra = precioCompraRepository.findLastByInsumoId(articuloInsumo.getId());
                dtos.get(articulosInsumos.indexOf(articuloInsumo)).setPrecioCompra(precioCompra);

                // Stock Minimo
                Float stockMinimo = stockMinimoRepository.findLastByInsumoId(articuloInsumo.getId());
                dtos.get(articulosInsumos.indexOf(articuloInsumo)).setStockMinimo(stockMinimo);

                // Stock Actual
                Float stockActual = stockActualRepository.findLastByInsumoId(articuloInsumo.getId());
                dtos.get(articulosInsumos.indexOf(articuloInsumo)).setStockActual(stockActual);
            }

            return dtos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public ArticuloInsumoFullDTO findById(Long id) throws Exception {
        try {
            ArticuloInsumo articuloInsumo = articuloInsumoRepository.findById(id).get();
            ArticuloInsumoFullDTO dto = articuloInsumoMapper.toDTO(articuloInsumo);

            // Precio Compra
            Double precioCompra = precioCompraRepository.findLastByInsumoId(id);
            dto.setPrecioCompra(precioCompra);

            // Stock Minimo
            Float stockMinimo = stockMinimoRepository.findLastByInsumoId(id);
            dto.setStockMinimo(stockMinimo);

            // Stock Actual
            Float stockActual = stockActualRepository.findLastByInsumoId(id);
            dto.setStockActual(stockActual);

            return dto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloInsumo save(ArticuloInsumoFullDTO dto) throws Exception {
        try{
            ArticuloInsumo articuloInsumo = articuloInsumoMapper.toEntity(dto);
            articuloInsumo = articuloInsumoRepository.save(articuloInsumo);

            // ArticuloInsumoPrecioCompra
            ArticuloInsumoPrecioCompra precioCompra = new ArticuloInsumoPrecioCompra(
                    new Date(),
                    dto.getPrecioCompra(),
                    articuloInsumo
            );
            precioCompraRepository.save(precioCompra);

            // ArticuloInsumoStockMinimo
            ArticuloInsumoStockMinimo stockMinimo = new ArticuloInsumoStockMinimo(
                    dto.getStockMinimo(),
                    new Date(),
                    articuloInsumo
            );
            stockMinimoRepository.save(stockMinimo);

            // ArticuloInsumoStockActual
            ArticuloInsumoStockActual stockActual = new ArticuloInsumoStockActual(
                    dto.getStockActual(),
                    new Date(),
                    articuloInsumo
            );
            stockActualRepository.save(stockActual);

            return articuloInsumo;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ArticuloInsumo update(Long id, ArticuloInsumoFullDTO dto) throws Exception {
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

            // Precio Compra
            Double precioCompraDB = precioCompraRepository.findLastByInsumoId(articuloInsumo.getId());
            if (precioCompraDB != null ) {
                if (!Objects.equals(dto.getPrecioCompra(), precioCompraDB)) {
                    precioCompraRepository.save(new ArticuloInsumoPrecioCompra(
                            new Date(),
                            dto.getPrecioCompra(),
                            articuloInsumo)
                    );
                }
            } else {
                precioCompraRepository.save(new ArticuloInsumoPrecioCompra(
                        new Date(),
                        dto.getPrecioCompra(),
                        articuloInsumo)
                );
            }

            // Stock Minimo
            Float stockMinimoDB = stockMinimoRepository.findLastByInsumoId(articuloInsumo.getId());
            if (stockMinimoDB != null) {
                if (!Objects.equals(dto.getStockMinimo(), stockMinimoDB)) {
                    stockMinimoRepository.save(new ArticuloInsumoStockMinimo(
                            dto.getStockMinimo(),
                            new Date(),
                            articuloInsumo)
                    );
                }
            } else {
                stockMinimoRepository.save(new ArticuloInsumoStockMinimo(
                        dto.getStockMinimo(),
                        new Date(),
                        articuloInsumo)
                );
            }

            // Stock Actual
            ArticuloInsumoStockActual stockActualDB = stockActualRepository.findByInsumoId(articuloInsumo.getId());
            if (stockActualDB == null) {
                stockActualRepository.save(new ArticuloInsumoStockActual(
                        dto.getStockActual(),
                        new Date(),
                        articuloInsumo
                ));
            } else {
                stockActualDB.setStockActual(dto.getStockActual());
                stockActualDB.setFecha(new Date());
                stockActualDB.setArticuloInsumo(articuloInsumo);
                stockActualRepository.save(stockActualDB);
            }

            return articuloInsumo;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
