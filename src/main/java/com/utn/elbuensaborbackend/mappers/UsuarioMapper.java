package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.UsuarioDTO;
import com.utn.elbuensaborbackend.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = RolMapper.class)
public interface UsuarioMapper {
    static UsuarioMapper getInstance() {
        return Mappers.getMapper(UsuarioMapper.class);
    }

    @Named("toDTO")
    @Mapping(source = "rol", target = "rol")
    UsuarioDTO toDTO(Usuario source);

    @Named("toEntity")
    @Mapping(source = "rol", target = "rol")
    Usuario toEntity(UsuarioDTO source);

    List<UsuarioDTO> toDTOsList(List<Usuario> source);

    List<Usuario> toEntitiesList(List<UsuarioDTO> source);
}
