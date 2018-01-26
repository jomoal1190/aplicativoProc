package com.aplication.jhs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="departamento")
public class Departamento {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_departamento")
	private Long idDepartamento;
	@Column(name="nombre")
	private String nombre;
	@Column(name="latitud")
	private String latitud;
	@Column(name="longitud")
	private String longitud;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_pais")
	private Pais pais;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="departamento")
	@JsonManagedReference
	Set<Municipio> municipio = new HashSet<Municipio>();
	
	public Long getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
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
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Set<Municipio> getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Set<Municipio> municipio) {
		this.municipio = municipio;
	}
	
	
	
	
}
