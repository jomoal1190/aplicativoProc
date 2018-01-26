package com.aplication.jhs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AsociacionController {

	private static Logger logger = LoggerFactory.getLogger(AsociacionController.class);
	
	@RequestMapping(value="/createEmpleado", method=RequestMethod.GET)
	public String insertarRegistros(Model model)
	{
		return "/empleado/createEmpleado";
	}
}
