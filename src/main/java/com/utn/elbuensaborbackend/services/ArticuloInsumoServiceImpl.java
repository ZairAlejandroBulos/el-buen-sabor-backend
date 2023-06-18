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
            ArticuloInsumoPrecioCompra precioCompra = new ArticuloInsumoPrecioCompra(
                    new Date(),
                    dto.getPrecioCompra(),
                    articuloInsumo
            );
            articuloInsumoPrecioCompraRepository.save(precioCompra);

            // ArticuloInsumoStockMinimo
            ArticuloInsumoStockMinimo stockMinimo = new ArticuloInsumoStockMinimo(
                    dto.getStockMinimo(),
                    new Date(),
                    articuloInsumo
            );
            articuloInsumoStockMinimoRepository.save(stockMinimo);

            // ArticuloInsumoStockActual
            ArticuloInsumoStockActual stockActual = new ArticuloInsumoStockActual(
                    dto.getStockActual(),
                    new Date(),
                    articuloInsumo
            );
            articuloInsumoStockActualRepository.save(stockActual);

            return articuloInsumoMapper.toDTO(articuloInsumo);
        } catch (Exception e) {
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
                            articuloInsumo)
                    );
                }
            } else {
                articuloInsumoPrecioCompraRepository.save(new ArticuloInsumoPrecioCompra(
                        new Date(),
                        dto.getPrecioCompra(),
                        articuloInsumo)
                );
            }

            // ArticuloInsumoStockMinimo
            ArticuloInsumoStockMinimo stockMinimoDB = articuloInsumoStockMinimoRepository.findByInsumoId(articuloInsumo.getId());
            if (stockMinimoDB != null) {
                if (!Objects.equals(dto.getStockMinimo(), stockMinimoDB.getStockMinimo())) {
                    articuloInsumoStockMinimoRepository.save(new ArticuloInsumoStockMinimo(
                            dto.getStockMinimo(),
                            new Date(),
                            articuloInsumo)
                    );
                }
            } else {
                articuloInsumoStockMinimoRepository.save(new ArticuloInsumoStockMinimo(
                        dto.getStockMinimo(),
                        new Date(),
                        articuloInsumo)
                );
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

}
