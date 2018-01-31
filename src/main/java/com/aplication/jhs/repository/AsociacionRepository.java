package com.aplication.jhs.repository;

import org.springframework.data.repository.CrudRepository;

import com.aplication.jhs.model.Asociacion;



public interface AsociacionRepository extends CrudRepository<Asociacion, Long>{

	
	Asociacion findByIdAsociacion(Long idAsociacion);
	Asociacion findByIdAsociacionAndToken(Long idAsociacion, String token);
}
