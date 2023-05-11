package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.Base;
import com.utn.elbuensaborbackend.exceptions.BaseException;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import com.utn.elbuensaborbackend.services.interfaces.BaseService;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {

    protected BaseRepository<E, ID> baseRepository;

    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<E> findAll() throws BaseException {
        try {
            return baseRepository.findAll();
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    public E findById(ID id) throws BaseException {
        try {
            return baseRepository.findById(id).get();
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws BaseException {
        try {
            return baseRepository.save(entity);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws BaseException {
        try {
            Optional<E> optional = baseRepository.findById(id);

            E entityUpdate = optional.get();
            entityUpdate = baseRepository.save(entity);
            return entityUpdate;
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(ID id) throws BaseException {
        try {
            if (!baseRepository.existsById(id)) {
                throw new BaseException("No se encontró la entidad");
            }

            baseRepository.deleteById(id);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }
}
