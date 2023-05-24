package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.Rubro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RubroRepository extends BaseRepository<Rubro, Long> {
    @Query(value = "SELECT r FROM Rubro r WHERE r.rubroPadre.id IS NULL")
    List<Rubro> findAllParents();

}
