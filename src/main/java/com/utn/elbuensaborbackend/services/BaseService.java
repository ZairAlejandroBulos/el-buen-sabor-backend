package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.Base;
import com.utn.elbuensaborbackend.exceptions.BaseException;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, I extends Serializable> {
    List<E> findAll() throws BaseException;
    E findById(I id) throws BaseException;
    E save(E entity) throws BaseException;
    E update(I id, E entity) throws BaseException;
    boolean delete(I id) throws BaseException;
}
