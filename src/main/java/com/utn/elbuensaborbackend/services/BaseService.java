package com.utn.elbuensaborbackend.services;

import com.utn.elbuensaborbackend.entities.Base;
import com.utn.elbuensaborbackend.exceptions.BaseException;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable> {
    List<E> findAll() throws BaseException;
    E findById(ID id) throws BaseException;
    E save(E entity) throws BaseException;
    E update(ID id, E entity) throws BaseException;
    void delete(ID id) throws BaseException;
}
