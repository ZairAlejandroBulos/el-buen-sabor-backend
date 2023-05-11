package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.DetallePedido;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.DetallePedidoRepository;
import com.utn.elbuensaborbackend.services.interfaces.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository) {
        super(baseRepository);
    }
}
