package com.dailypoor.client.beanproxy;

import com.dailypoor.server.locator.LocatorCosto;
import com.dailypoor.server.model.bean.Costo;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=Costo.class,locator=LocatorCosto.class)
public interface CostoProxy extends EntityProxy{
	public Long getIdCosto();
	
	public void setIdCosto(Long idCosto);
	
	public String getNombre();
	
	public void setNombre(String nombre);
	
	public String getCorreo();

	public void setCorreo(String correo);
	
	public Long getVersion();
	
	public void setVersion(Long version);
	
	public String getOperacion();
	
	public void setOperacion(String operacion);
	
}
