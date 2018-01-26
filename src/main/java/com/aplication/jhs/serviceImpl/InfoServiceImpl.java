package com.aplication.jhs.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aplication.jhs.controller.InfoController;
import com.aplication.jhs.model.Pais;
import com.aplication.jhs.repository.PaisRepository;
import com.aplication.jhs.service.InfoService;

public class InfoServiceImpl implements InfoService{

	private static Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);
	@Autowired PaisRepository paisRepository;
	
	
	@Override
	public List<Pais> getPaises() {
		List<Pais> response = (List<Pais>) paisRepository.findAll();
		
		return response;
	}

	
}
