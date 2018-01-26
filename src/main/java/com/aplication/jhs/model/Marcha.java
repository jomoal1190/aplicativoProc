package com.aplication.jhs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="marcha")
public class Marcha {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_marcha")
	private Long idMarcha;
	@Column(name="nombre")
	private String nombre;
	@Column(name="autor")
	private String autor;
	@Column(name="url")
	private String url;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_turno")
	private Turno turno;
	
	public Long getIdMarcha() {
		return idMarcha;
	}
	public void setIdMarcha(Long idMarcha) {
		this.idMarcha = idMarcha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	
}
