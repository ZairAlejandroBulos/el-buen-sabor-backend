package com.utn.elbuensaborbackend.mappers;

import com.utn.elbuensaborbackend.dtos.ClienteDTO;
import com.utn.elbuensaborbackend.entities.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, DomicilioMapper.class})
public interface ClienteMapper {

    static ClienteMapper getInstance() {
        return Mappers.getMapper(ClienteMapper.class);
    }

    @Mapping(source = "usuario", target = "usuario", qualifiedByName = "toDTO")
    @Mapping(source = "domicilio", target = "domicilio", qualifiedByName = "toDTO")
    ClienteDTO toDTO(Cliente source);

    @Mapping(source = "usuario", target = "usuario", qualifiedByName = "toEntity")
    @Mapping(source = "domicilio", target = "domicilio", qualifiedByName = "toEntity")
    Cliente toEntity(ClienteDTO source);

    List<ClienteDTO> toDTOsList(List<Cliente> source);

    List<Cliente> toEntitiesList(List<ClienteDTO> source);
}
