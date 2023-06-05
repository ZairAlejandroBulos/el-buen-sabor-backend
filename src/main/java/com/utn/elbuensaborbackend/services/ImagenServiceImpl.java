package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.Imagen;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.repositories.ImagenRepository;
import com.utn.elbuensaborbackend.services.interfaces.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImagenServiceImpl extends BaseServiceImpl<Imagen, Long> implements ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public ImagenServiceImpl(BaseRepository<Imagen, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Resource findImagenByName(String nombre) throws Exception {
        try {
            Path path = Paths.get("images").toAbsolutePath().resolve(nombre);
            Resource resource = new UrlResource(path.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                throw new Exception("La imagen no existe.");
            }

            return resource;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
