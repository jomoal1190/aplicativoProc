package com.aplication.jhs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aplication.jhs.dao.ObjetoRecorrido;
import com.aplication.jhs.service.InfoService;

@Controller
public class InfoController {

	private static Logger logger = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired InfoService infoService;
	@Value("${google.maps.key}")
	private String googleMapsKey;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String getIndex(Model model)
	{
		return "index";
	}
	
	
	@RequestMapping(value="/recorrido", method=RequestMethod.GET)
	public @ResponseBody ObjetoRecorrido getRecorrido(Model model)
	{
		Long idRecorrido =(long) 1;
		ObjetoRecorrido respuesta  = infoService.getRecorrido(idRecorrido);
		logger.info("CANTIDAD DE PUNTOS EN IDA "+respuesta.getIda().size());
		logger.info("CANTIDAD DE PUNTOS EN REGRESO "+respuesta.getRegreso().size());
		logger.info(googleMapsKey);
		return respuesta;
	}
	@RequestMapping(value="/dibujarRecorrido", method=RequestMethod.GET)
	public String drawRecorrido(Model model)
	{
		model.addAttribute(googleMapsKey, googleMapsKey);
		
		return "dibujarRecorrido";
	}
	
	
}


