package com.dailypoor.server.model.bean;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ProyectoCosto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long idProyectoCosto;
	@Persistent
	private Long idProyecto;
	@Persistent
	private Long idCosto;
	@Persistent
	private Double monto;
	@Persistent
	private Double cantidad;
	@Persistent
	private String motivo;
	@Persistent
	private Long version;
	@NotPersistent
	private String operacion;
	
	public Long getIdProyectoCosto() {
		return idProyectoCosto;
	}
	public void setIdProyectoCosto(Long idProyectoCosto) {
		this.idProyectoCosto = idProyectoCosto;
	}
	public Long getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}
	public Long getIdCosto() {
		return idCosto;
	}
	public void setIdCosto(Long idCosto) {
		this.idCosto = idCosto;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
		
}
