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
@Table(name="turno")
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_turno")
	private Long idTurno;
	@Column(name="latitud")
	private String latitud;
	@Column(name="longitud")
	private String longitud;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_recorrido")
	private Recorrido recorrido;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="turno")
	@JsonManagedReference
	Set<Marcha> marchas = new HashSet<Marcha>();
	
	public Long getIdTurno() {
		return idTurno;
	}
	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
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
	public Recorrido getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	public Set<Marcha> getMarchas() {
		return marchas;
	}
	public void setMarchas(Set<Marcha> marchas) {
		this.marchas = marchas;
	}

	
	
}
