package com.aplication.jhs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="pais")
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_pais")
	private Long idPais;
	@Column(name="nombre")
	private String nombre;
	@Column(name="latitud")
	private String latitud;
	@Column(name="longitud")
	private String longitud;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="pais")
	@JsonManagedReference
	Set<Departamento> departamentos = new HashSet<Departamento>();
	
	
	
	public Long getIdPais() {
		return idPais;
	}
	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	

}
