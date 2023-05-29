package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.dtos.*;
import com.utn.elbuensaborbackend.entities.Cliente;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.ClienteRepository;
import com.utn.elbuensaborbackend.services.interfaces.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<ClienteDTO> findAllClientesByRoles(List<String> roles) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.findAllClientesByRoles(roles);
            List<ClienteDTO> clientesDTOs = new ArrayList<>();

            for(Cliente c : clientes){
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setId(c.getId());
                clienteDTO.setNombre(c.getNombre());
                clienteDTO.setApellido(c.getApellido());
                clienteDTO.setTelefono(c.getTelefono());

                RolDTO rolDTO = new RolDTO();
                rolDTO.setId(c.getUsuario().getRol().getId());
                rolDTO.setDenominacion(c.getUsuario().getRol().getDenominacion());

                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(c.getUsuario().getId());
                usuarioDTO.setUsuario(c.getUsuario().getUsuario());
                usuarioDTO.setRol(rolDTO);

                LocalidadDTO localidadDTO = new LocalidadDTO();
                localidadDTO.setId(c.getDomicilio().getLocalidad().getId());
                localidadDTO.setNombre(c.getDomicilio().getLocalidad().getNombre());

                DomicilioDTO domicilioDTO = new DomicilioDTO();
                domicilioDTO.setId(c.getDomicilio().getId());
                domicilioDTO.setNumero(c.getDomicilio().getNumero());
                domicilioDTO.setCalle(c.getDomicilio().getCalle());
                domicilioDTO.setLocalidad(localidadDTO);

                clienteDTO.setUsuario(usuarioDTO);
                clienteDTO.setDomicilio(domicilioDTO);

                clientesDTOs.add(clienteDTO);
            }

            return clientesDTOs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> findAllClientesByName(String nombre) throws Exception {
        try{
            List<Cliente> clientes = clienteRepository.findAllClientesByName(nombre);
            List<ClienteDTO> clientesDTOs = new ArrayList<>();

            for(Cliente c : clientes){
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setId(c.getId());
                clienteDTO.setNombre(c.getNombre());
                clienteDTO.setApellido(c.getApellido());
                clienteDTO.setTelefono(c.getTelefono());

                RolDTO rolDTO = new RolDTO();
                rolDTO.setId(c.getUsuario().getRol().getId());
                rolDTO.setDenominacion(c.getUsuario().getRol().getDenominacion());

                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(c.getUsuario().getId());
                usuarioDTO.setUsuario(c.getUsuario().getUsuario());
                usuarioDTO.setRol(rolDTO);

                LocalidadDTO localidadDTO = new LocalidadDTO();
                localidadDTO.setId(c.getDomicilio().getLocalidad().getId());
                localidadDTO.setNombre(c.getDomicilio().getLocalidad().getNombre());

                DomicilioDTO domicilioDTO = new DomicilioDTO();
                domicilioDTO.setId(c.getDomicilio().getId());
                domicilioDTO.setNumero(c.getDomicilio().getNumero());
                domicilioDTO.setCalle(c.getDomicilio().getCalle());
                domicilioDTO.setLocalidad(localidadDTO);

                clienteDTO.setUsuario(usuarioDTO);
                clienteDTO.setDomicilio(domicilioDTO);

                clientesDTOs.add(clienteDTO);
            }

            return clientesDTOs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> findAllClientesByApellido(String apellido) throws Exception {
        try{
            List<Cliente> clientes = clienteRepository.findAllClientesByApellido(apellido);
            List<ClienteDTO> clientesDTOs = new ArrayList<>();

            for(Cliente c : clientes){
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setId(c.getId());
                clienteDTO.setNombre(c.getNombre());
                clienteDTO.setApellido(c.getApellido());
                clienteDTO.setTelefono(c.getTelefono());

                RolDTO rolDTO = new RolDTO();
                rolDTO.setId(c.getUsuario().getRol().getId());
                rolDTO.setDenominacion(c.getUsuario().getRol().getDenominacion());

                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(c.getUsuario().getId());
                usuarioDTO.setUsuario(c.getUsuario().getUsuario());
                usuarioDTO.setRol(rolDTO);

                LocalidadDTO localidadDTO = new LocalidadDTO();
                localidadDTO.setId(c.getDomicilio().getLocalidad().getId());
                localidadDTO.setNombre(c.getDomicilio().getLocalidad().getNombre());

                DomicilioDTO domicilioDTO = new DomicilioDTO();
                domicilioDTO.setId(c.getDomicilio().getId());
                domicilioDTO.setNumero(c.getDomicilio().getNumero());
                domicilioDTO.setCalle(c.getDomicilio().getCalle());
                domicilioDTO.setLocalidad(localidadDTO);

                clienteDTO.setUsuario(usuarioDTO);
                clienteDTO.setDomicilio(domicilioDTO);

                clientesDTOs.add(clienteDTO);
            }

            return clientesDTOs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ClienteDTO> findAllClientesByNameAndApellido(String nombre, String apellido) throws Exception {
        try{
            List<Cliente> clientes = clienteRepository.findAllClientesByNameAndApellido(nombre, apellido);
            List<ClienteDTO> clientesDTOs = new ArrayList<>();

            for(Cliente c : clientes){
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setId(c.getId());
                clienteDTO.setNombre(c.getNombre());
                clienteDTO.setApellido(c.getApellido());
                clienteDTO.setTelefono(c.getTelefono());

                RolDTO rolDTO = new RolDTO();
                rolDTO.setId(c.getUsuario().getRol().getId());
                rolDTO.setDenominacion(c.getUsuario().getRol().getDenominacion());

                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(c.getUsuario().getId());
                usuarioDTO.setUsuario(c.getUsuario().getUsuario());
                usuarioDTO.setRol(rolDTO);

                LocalidadDTO localidadDTO = new LocalidadDTO();
                localidadDTO.setId(c.getDomicilio().getLocalidad().getId());
                localidadDTO.setNombre(c.getDomicilio().getLocalidad().getNombre());

                DomicilioDTO domicilioDTO = new DomicilioDTO();
                domicilioDTO.setId(c.getDomicilio().getId());
                domicilioDTO.setNumero(c.getDomicilio().getNumero());
                domicilioDTO.setCalle(c.getDomicilio().getCalle());
                domicilioDTO.setLocalidad(localidadDTO);

                clienteDTO.setUsuario(usuarioDTO);
                clienteDTO.setDomicilio(domicilioDTO);

                clientesDTOs.add(clienteDTO);
            }

            return clientesDTOs;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
