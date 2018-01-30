package com.aplication.jhs.service;

import java.util.List;

import com.aplication.jhs.dao.ObjetoRecorrido;
import com.aplication.jhs.model.Pais;

public interface InfoService {

	public List<Pais> getPaises();
	public ObjetoRecorrido getRecorrido(Long idRecorrido);
}
