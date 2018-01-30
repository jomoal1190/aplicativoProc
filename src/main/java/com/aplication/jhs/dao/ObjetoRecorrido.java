package com.aplication.jhs.dao;

import java.util.List;

import com.aplication.jhs.model.Turno;

public class ObjetoRecorrido {

	private List<Turno> ida;
	private List<Turno> regreso;
	
	
	public List<Turno> getIda() {
		return ida;
	}
	public void setIda(List<Turno> ida) {
		this.ida = ida;
	}
	public List<Turno> getRegreso() {
		return regreso;
	}
	public void setRegreso(List<Turno> regreso) {
		this.regreso = regreso;
	}
	
	

	
	
}
