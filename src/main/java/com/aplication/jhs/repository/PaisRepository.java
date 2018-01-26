package com.aplication.jhs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aplication.jhs.model.Pais;


public interface PaisRepository extends CrudRepository<Pais, Long>{

	List<Pais> findAll();
}
