package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.MercadoPagoDatos;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.MercadoPagoDatosRepository;
import com.utn.elbuensaborbackend.services.interfaces.MercadoPagoDatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoDatosServiceImpl extends BaseServiceImpl<MercadoPagoDatos, Long> implements MercadoPagoDatosService {

    @Autowired
    private MercadoPagoDatosRepository mercadoPagoDatosRepository;

    public MercadoPagoDatosServiceImpl(BaseRepository<MercadoPagoDatos, Long> baseRepository) {
        super(baseRepository);
    }
}
