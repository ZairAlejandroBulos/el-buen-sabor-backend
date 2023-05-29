package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.ArticuloManufacturado;
import com.utn.elbuensaborbackend.entities.ArticuloManufacturadoInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long> {
    @Query(value = "SELECT * FROM articulo_manufacturado WHERE denominacion LIKE %:termino%", nativeQuery = true)
    List<ArticuloManufacturado> findByTermino(@Param("termino") String termino);
}
