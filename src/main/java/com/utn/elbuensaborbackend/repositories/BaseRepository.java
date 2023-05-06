package com.utn.elbuensaborbackend.repositories;

import com.utn.elbuensaborbackend.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<E extends Base, I extends Serializable> extends JpaRepository<E, I> {
}
