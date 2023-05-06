package com.utn.elbuensaborbackend.controllers;

import com.utn.elbuensaborbackend.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController<E extends Base, I extends Serializable> {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getOneById(@PathVariable I id);
    ResponseEntity<?> save(@RequestBody E entity);
    ResponseEntity<?> update(@PathVariable I id, @RequestBody E entity);
    ResponseEntity<?> delete(@PathVariable I id);
}
