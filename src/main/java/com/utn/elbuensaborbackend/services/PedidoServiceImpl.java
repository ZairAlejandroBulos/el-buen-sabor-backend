package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.Pedido;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.PedidoRepository;
import com.utn.elbuensaborbackend.services.interfaces.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository) {
        super(baseRepository);
    }
}
