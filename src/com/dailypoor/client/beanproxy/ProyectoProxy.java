package com.dailypoor.client.beanproxy;

import java.util.Date;

import com.dailypoor.server.locator.LocatorProyecto;
import com.dailypoor.server.model.bean.Proyecto;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=Proyecto.class,locator=LocatorProyecto.class)
public interface ProyectoProxy extends EntityProxy{
	public Long getIdProyecto();
	
	public void setIdProyecto(Long idProyecto);
	
	public String getNombre();
	
	public void setNombre(String nombre);
	
	public String getDescripcion();
	
	public void setDescripcion(String descripcion);
	
	public Date getFecha();
	
	public void setFecha(Date fecha);
	
	public String getMonto();
	
	public void setMonto(String monto);
	
	public String getCorreo();
	
	public void setCorreo(String correo);
	
	public Long getVersion();
	
	public void setVersion(Long version);
	
	public String getOperacion();
	
	public void setOperacion(String operacion);
	
}
