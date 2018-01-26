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
@Table(name= "asociacion")
public class Asociacion {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_asociacion")
	private Long idAsociacion;
	@Column(name="nombre")
	private String nombre;
	@Column(name="direccion")
	private String direccion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference
	@JoinColumn(name="id_municipio")
	private Municipio municipio;
	@Column(name="telefono")
	private String telefono;
	@Column(name="correo")
	private String correo;
	@Column(name="identificador")
	private String identificador;
	@Column(name="mac")
	private String mac;
	@Column(name="ip")
	private String ip;
	@Column(name="latitud")
	private String latitud;
	@Column(name="longitud")
	private String longitud;
	@Column(name="activo")
	private Boolean activo;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="asociacion")
	@JsonManagedReference
	Set<Recorrido> recorridos = new HashSet<Recorrido>();
	
	
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Long getIdAsociacion() {
		return idAsociacion;
	}
	public void setIdAsociacion(Long idAsociacion) {
		this.idAsociacion = idAsociacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
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
	public Set<Recorrido> getRecorridos() {
		return recorridos;
	}
	public void setRecorridos(Set<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}
	
	
	
}
