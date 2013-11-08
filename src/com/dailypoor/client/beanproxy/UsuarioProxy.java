package com.dailypoor.client.beanproxy;

import com.dailypoor.server.locator.LocatorUsuario;
import com.dailypoor.server.model.bean.Usuario;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=Usuario.class,locator=LocatorUsuario.class)
public interface UsuarioProxy extends EntityProxy{
	public String getCorreo();
	
	public void setCorreo(String correo);
	
	public String getClave();
	
	public void setClave(String clave);
	
	public String getNombre();
	
	public void setNombre(String nombre);
	
	public String getApellidos();
	
	public void setApellidos(String apellidos);
	
	public Long getVersion();
	
	public void setVersion(Long version);
	
	public String getOperacion();
	
	public void setOperacion(String operacion);	
	
	public String getIdSesion();
	
	public void setIdSesion(String idSesion);
	
}
