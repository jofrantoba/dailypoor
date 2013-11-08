package com.dailypoor.client.beanproxy;


import com.dailypoor.server.locator.LocatorProyectoCosto;
import com.dailypoor.server.model.bean.ProyectoCosto;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=ProyectoCosto.class,locator=LocatorProyectoCosto.class)
public interface ProyectoCostoProxy extends EntityProxy{
	public Long getIdProyectoCosto();
	
	public void setIdProyectoCosto(Long idProyectoCosto);
	
	public Long getIdProyecto();
	
	public void setIdProyecto(Long idProyecto);
	
	public Long getIdCosto();
	
	public void setIdCosto(Long idCosto);
	
	public Double getMonto();
	
	public void setMonto(Double monto);
	
	public Double getCantidad();
	
	public void setCantidad(Double cantidad);
	
	public String getMotivo();
	
	public void setMotivo(String motivo);
	
	public Long getVersion();
	
	public void setVersion(Long version);
	
	public String getOperacion();
	
	public void setOperacion(String operacion);
	
}
