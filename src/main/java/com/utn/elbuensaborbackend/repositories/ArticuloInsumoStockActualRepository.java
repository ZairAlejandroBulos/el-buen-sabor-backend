package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.ArticuloInsumoStockActual;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloInsumoStockActualRepository extends BaseRepository<ArticuloInsumoStockActual, Long> {

    @Query(value = "SELECT * FROM articulo_insumo_stock_actual " +
            "WHERE articulo_insumo_id = :articuloInsumoId", nativeQuery = true)
    ArticuloInsumoStockActual findByInsumoId(@Param("articuloInsumoId") Long articuloInsumoId);

    @Query(value = "SELECT stock_actual FROM articulo_insumo_stock_actual " +
            "WHERE articulo_insumo_id = :articuloInsumoId", nativeQuery = true)
    Float findLastByInsumoId(@Param("articuloInsumoId") Long articuloInsumoId);
}
