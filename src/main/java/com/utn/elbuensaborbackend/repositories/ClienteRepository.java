package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long> {

    @Query(value = "SELECT c.* FROM Cliente c " +
            "INNER JOIN Usuario u ON c.usuario_id = u.id_usuario " +
            "INNER JOIN Rol r ON u.rol_id = r.id_rol " +
            "WHERE r.denominacion IN :roles", nativeQuery = true)
    List<Cliente> findAllClientesByRoles(@Param("roles") List<String> roles);


}
