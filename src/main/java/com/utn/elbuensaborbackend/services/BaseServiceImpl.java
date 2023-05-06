package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.Base;
import com.utn.elbuensaborbackend.exceptions.BaseException;
import com.utn.elbuensaborbackend.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class BaseServiceImpl<E extends Base, I extends Serializable> implements BaseService<E, I> {

    protected BaseRepository<E, I> baseRepository;

    public BaseServiceImpl(BaseRepository<E, I> baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public List<E> findAll() throws BaseException {
        try {
           List<E> entities = baseRepository.findAll();
           return entities;
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(I id) throws BaseException {
        try {
            Optional<E> entity = baseRepository.findById(id);
            return entity.get();
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
    public E update(I id, E entity) throws BaseException {
        try {
            Optional<E> optional = baseRepository.findById(id);

            if (!optional.isPresent()) {
                throw new BaseException("No se encontro la entidad.");
            }

            return baseRepository.save(entity);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(I id) throws BaseException {
        try {
            if (!baseRepository.existsById(id)) {
                throw new BaseException("No se encontro la entidad.");
            }

            baseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }
}
