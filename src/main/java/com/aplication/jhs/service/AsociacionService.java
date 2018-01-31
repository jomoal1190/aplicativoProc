package com.aplication.jhs.service;

import com.aplication.jhs.dao.Localizacion;
import com.aplication.jhs.dao.PeticionLoginAsociacion;
import com.aplication.jhs.dao.RespuestaGenericaDAO;
import com.aplication.jhs.dao.RespuestaLoginAsociacion;
import com.aplication.jhs.model.Asociacion;

public interface AsociacionService {


		public RespuestaGenericaDAO getAsociacionId(Localizacion localizacion);
		public String saveAsociacion(Asociacion asociacion);
		public RespuestaLoginAsociacion loginAsociacion(PeticionLoginAsociacion peticion);
}
