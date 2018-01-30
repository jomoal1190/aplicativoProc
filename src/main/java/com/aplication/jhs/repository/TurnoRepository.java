package com.aplication.jhs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aplication.jhs.model.Turno;

public interface TurnoRepository extends CrudRepository<Turno, Long> {
	
	List<Turno> findByRecorridoIdRecorridoAndIdaTrue(Long idRecorrido);
	List<Turno> findByRecorridoIdRecorridoAndIdaFalse(Long idRecorrido);

}
