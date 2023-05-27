package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c JOIN FETCH c.usuario u JOIN FETCH u.rol r WHERE r.id <> :rolId")
    List<Cliente> findAllCustomersWithDifferentRoleId(@Param("rolId") Long rolId);


}
