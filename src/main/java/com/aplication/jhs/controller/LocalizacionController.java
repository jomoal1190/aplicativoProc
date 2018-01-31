package com.aplication.jhs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aplication.jhs.dao.Localizacion;
import com.aplication.jhs.model.Asociacion;
import com.aplication.jhs.repository.AsociacionRepository;
import com.aplication.jhs.service.AsociacionService;



@Controller
public class LocalizacionController {

	private static Logger logger = LoggerFactory.getLogger(LocalizacionController.class);
	private static final String CORRECTO = "001";
	private static final String INCORRECTO = "000";
	
	@Autowired AsociacionService asociacionService;
	
	
	@RequestMapping(value="/setLocation", method=RequestMethod.POST)
	public @ResponseBody String setLocation(@RequestBody Localizacion localizacion)
	{
		Asociacion asoc = asociacionService.getAsociacionId(localizacion.getIdAsociacion());
		logger.info("Asociacon nombre "+asoc.getNombre());
		asoc.setLatitud(localizacion.getLatitutd());
		asoc.setLongitud(localizacion.getLongitud());
		String respuesta = asociacionService.saveAsociacion(asoc);
		return respuesta;
	}
	
}
