package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * Interfaz base para los controlladores que manejan entidades que extienden de Base.
 *
 * @param <E> Tipo de Entidad que extiende de Base.
 * @param <ID> Tipo de DTO que implementa Serializable.
 */
public interface BaseController<E extends Base, ID extends Serializable> {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getOneById(@PathVariable ID id);
    ResponseEntity<?> delete(@PathVariable ID id);
}
