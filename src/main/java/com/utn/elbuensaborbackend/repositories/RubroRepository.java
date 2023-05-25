package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.Rubro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RubroRepository extends BaseRepository<Rubro, Long> {
    @Query(value = "SELECT * FROM Rubro WHERE rubro_id IS NULL", nativeQuery = true)
    List<Rubro> findAllParents();
}
