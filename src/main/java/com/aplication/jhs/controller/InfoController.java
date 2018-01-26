package com.aplication.jhs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InfoController {

	private static Logger logger = LoggerFactory.getLogger(InfoController.class);
	
	@RequestMapping(value="/getPais", method=RequestMethod.GET)
	public @ResponseBody String getPais(Model model)
	{
		return "/empleado/createEmpleado";
	}
}
