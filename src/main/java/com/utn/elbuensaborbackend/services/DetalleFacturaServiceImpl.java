package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.DetalleFactura;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.DetalleFacturaRepository;
import com.utn.elbuensaborbackend.services.interfaces.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura, Long> implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository) {
        super(baseRepository);
    }
}
