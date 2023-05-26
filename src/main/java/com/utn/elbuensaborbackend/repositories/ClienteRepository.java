package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    @Query(value = "SELECT c FROM Cliente c JOIN c.usuario u JOIN u.rol r WHERE r.denominacion IN :roles")
    List<Cliente> findClientesByRoles(@Param("roles") List<String> roles);

}
