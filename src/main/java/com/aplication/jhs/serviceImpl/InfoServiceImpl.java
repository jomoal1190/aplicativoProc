package com.aplication.jhs.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.jhs.controller.InfoController;
import com.aplication.jhs.dao.ObjetoRecorrido;
import com.aplication.jhs.model.Pais;
import com.aplication.jhs.model.Turno;
import com.aplication.jhs.repository.PaisRepository;
import com.aplication.jhs.repository.TurnoRepository;
import com.aplication.jhs.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService{

	private static Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);
	@Autowired PaisRepository paisRepository;
	@Autowired TurnoRepository turnoRespository;
	
	
	@Override
	public List<Pais> getPaises() {
		List<Pais> response = (List<Pais>) paisRepository.findAll();
		
		return response;
	}


	@Override
	public ObjetoRecorrido getRecorrido(Long idRecorrido) {
		ObjetoRecorrido response = new ObjetoRecorrido();
		
		
		List<Turno> turnoIda = turnoRespository.findByRecorridoIdRecorridoAndIdaTrue(idRecorrido);
		List<Turno> turnoRetorno = turnoRespository.findByRecorridoIdRecorridoAndIdaFalse(idRecorrido);
		response.setIda(turnoIda);
		response.setRegreso(turnoRetorno);
		return response;
	}

	
}
