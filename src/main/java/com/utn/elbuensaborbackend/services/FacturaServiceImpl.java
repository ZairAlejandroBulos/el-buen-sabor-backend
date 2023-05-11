package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.Factura;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.FacturaRepository;
import com.utn.elbuensaborbackend.services.interfaces.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }
}
