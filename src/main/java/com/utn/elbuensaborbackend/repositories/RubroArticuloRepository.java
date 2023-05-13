package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.RubroArticulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloRepository extends BaseRepository<RubroArticulo, Long> {

    @Query(value = "SELECT r FROM RubroArticulo r WHERE r.rubroPadre.id IS NULL")
    List<RubroArticulo> findAllParents();

}
