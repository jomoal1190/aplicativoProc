package com.aplication.jhs.dao;

public class RespuestaLoginAsociacion {

	private Long idAsociacion;
	private String token;
	private RespuestaGenericaDAO respuesta;
	
	
	public Long getIdAsociacion() {
		return idAsociacion;
	}
	public void setIdAsociacion(Long idAsociacion) {
		this.idAsociacion = idAsociacion;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public RespuestaGenericaDAO getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(RespuestaGenericaDAO respuesta) {
		this.respuesta = respuesta;
	}
	
	
}
