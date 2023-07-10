package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoPrecioVenta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloManufacturadoPrecioVentaRepository extends BaseRepository<ArticuloManufacturadoPrecioVenta, Long>{

    @Query(value = "SELECT * FROM articulo_manufacturado_precio_venta " +
            "WHERE articulo_manufacturado_id = :articuloManufacturadoId " +
            "ORDER BY fecha DESC, id_precio_venta DESC LIMIT 1", nativeQuery = true)
    ArticuloManufacturadoPrecioVenta findByManufacturadoId(@Param("articuloManufacturadoId") Long articuloManufacturadoId);

    @Query(value = "SELECT monto FROM articulo_manufacturado_precio_venta " +
            "WHERE articulo_manufacturado_id = :articuloManufacturadoId " +
            "ORDER BY fecha DESC, id_precio_venta DESC LIMIT 1", nativeQuery = true)
    Double findLastByManufacturado(@Param("articuloManufacturadoId") Long articuloManufacturadoId);
}
