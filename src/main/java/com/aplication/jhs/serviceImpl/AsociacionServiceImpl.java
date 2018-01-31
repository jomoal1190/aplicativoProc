package com.aplication.jhs.serviceImpl;

import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplication.jhs.controller.LocalizacionController;
import com.aplication.jhs.dao.Localizacion;
import com.aplication.jhs.dao.PeticionLoginAsociacion;
import com.aplication.jhs.dao.RespuestaGenericaDAO;
import com.aplication.jhs.dao.RespuestaLoginAsociacion;
import com.aplication.jhs.model.Asociacion;
import com.aplication.jhs.repository.AsociacionRepository;
import com.aplication.jhs.service.AsociacionService;

@Service
public class AsociacionServiceImpl implements AsociacionService{

	private static Logger logger = LoggerFactory.getLogger(LocalizacionController.class);
	private static final String CORRECTO = "001";
	private static final String INCORRECTO = "000";
	private static final String ERROR = "002";
	
	@Autowired AsociacionRepository asociacionRepository;
	
	
	protected static SecureRandom random = new SecureRandom();
    
   
	
	@Override
	public RespuestaGenericaDAO getAsociacionId(Localizacion localizacion) {
		
		RespuestaGenericaDAO response = new RespuestaGenericaDAO();
		Asociacion asociacion = asociacionRepository.findByIdAsociacionAndToken(localizacion.getIdAsociacion(), localizacion.getToken());
		if(asociacion != null)
		{
			logger.info("Asociacon nombre "+asociacion.getNombre());
			asociacion.setLatitud(localizacion.getLatitutd());
			asociacion.setLongitud(localizacion.getLongitud());
			response.setCodigo(saveAsociacion(asociacion));
			response.setMensaje("Ubicacion actualizada");
		}
		else
		{
			response.setCodigo(INCORRECTO);
			response.setMensaje("No se actualizo la hubicacion");
		}
		return response;
	}

	@Override
	public String saveAsociacion(Asociacion asociacion) {
		try
		{
			if(asociacion != null)
			{
				asociacionRepository.save(asociacion);
				return CORRECTO;
			}
			else
			{
				return INCORRECTO;
			}
		}
		catch(Exception e){
			logger.info("Error al guardar asociacion "+e);
			return ERROR;
		}
	}

	@Override
	public RespuestaLoginAsociacion loginAsociacion(PeticionLoginAsociacion peticion) {
		RespuestaLoginAsociacion response = new RespuestaLoginAsociacion();
		RespuestaGenericaDAO respuestaDao = new RespuestaGenericaDAO();
		Asociacion asociacion = new Asociacion();
		try
		{
			if(peticion!=null)
			{
				if(peticion.getIdAsociacion() !=null)
				{
					if(peticion.getPassword()!=null)
					{
						asociacion= asociacionRepository.findByIdAsociacion(peticion.getIdAsociacion());
						if(asociacion != null)
						{
							if(asociacion.getContrasena().equals(peticion.getPassword()))
							{
								String token = generateToken(asociacion.getNombre());
								logger.info("token "+token);
								asociacion.setToken(token);
								asociacionRepository.save(asociacion);
								response.setToken(token);
								response.setIdAsociacion(asociacion.getIdAsociacion());
								logger.info("Asociacion encontrada");
								respuestaDao.setCodigo(CORRECTO);
								respuestaDao.setMensaje("Asociacion encontrada");
							}
							else
							{
								logger.info("Contraseña no coincide");
								respuestaDao.setCodigo(INCORRECTO);
								respuestaDao.setMensaje("Contraseña no coincide");
							}
						}
						else
						{
							logger.info("No existe asociacion con el id ingresado ");
							respuestaDao.setCodigo(INCORRECTO);
							respuestaDao.setMensaje("No existe asociacion con el id ingresado ");
						}
					}
					else
					{
						logger.info("ID constraseña vacia ");
						respuestaDao.setCodigo(INCORRECTO);
						respuestaDao.setMensaje("ID asociacion vacio ");
					}
				}
				else
				{
					logger.info("ID asociacion vacio ");
					respuestaDao.setCodigo(INCORRECTO);
					respuestaDao.setMensaje("ID asociacion vacio ");
				}
				
			}
			
		}catch(Exception e)
		{
			logger.info("Error login asociacion"+e);
			respuestaDao.setCodigo(ERROR);
			respuestaDao.setMensaje("Error en login asociacion ");
		}
		response.setRespuesta(respuestaDao);
		return response;
	}

	 public synchronized String generateToken( String username ) {
         long longToken = Math.abs( random.nextLong() );
         String random = Long.toString( longToken, 16 );
         return ( username + ":" + random );
	 }
}
