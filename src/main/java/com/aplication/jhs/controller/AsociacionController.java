package com.aplication.jhs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aplication.jhs.dao.PeticionLoginAsociacion;
import com.aplication.jhs.dao.RespuestaLoginAsociacion;
import com.aplication.jhs.service.AsociacionService;

@Controller
public class AsociacionController {

	private static Logger logger = LoggerFactory.getLogger(AsociacionController.class);
	
	@Autowired AsociacionService asociacionService;
	
	
	@RequestMapping(value="/loginAsociacionApp", method=RequestMethod.POST)
	public @ResponseBody RespuestaLoginAsociacion loginAsociacionApp(PeticionLoginAsociacion peticion)
	{
		RespuestaLoginAsociacion response= asociacionService.loginAsociacion(peticion);
		
		return response;
	}
	
}
