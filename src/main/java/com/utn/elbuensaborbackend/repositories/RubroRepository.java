package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.Rubro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RubroRepository extends BaseRepository<Rubro, Long> {

    @Query(value = "SELECT * FROM rubro WHERE bloqueado = false", nativeQuery = true)
    List<Rubro> findDesbloqueados();

    @Query(value = "SELECT * FROM rubro WHERE denominacion = :denominacion", nativeQuery = true)
    Rubro findByDenominacion(@Param("denominacion") String denominacion);
}
