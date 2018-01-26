package com.aplication.jhs.model;

import java.util.Date;
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

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="recorrido")
public class Recorrido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_recorrido")
	private Long idRecorrido;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="fecha_creacion")
	@Type(type="date")
	private Date fecha;
	@Column(name="activo")
	private Boolean activo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_asociacion")
	private Asociacion asociacion;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="recorrido")
	@JsonManagedReference
	Set<Turno> turnos = new HashSet<Turno>();
	
	
	public Long getIdRecorrido() {
		return idRecorrido;
	}
	public void setIdRecorrido(Long idRecorrido) {
		this.idRecorrido = idRecorrido;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Asociacion getAsociacion() {
		return asociacion;
	}
	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}
	public Set<Turno> getTurnos() {
		return turnos;
	}
	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}
	

}
