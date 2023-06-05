package com.utn.elbuensaborbackend.services.interfaces;

import com.utn.elbuensaborbackend.entities.Imagen;
import org.springframework.core.io.Resource;

public interface ImagenService extends BaseService<Imagen, Long> {

    Resource findImagenByName(String nombre) throws Exception;

}
