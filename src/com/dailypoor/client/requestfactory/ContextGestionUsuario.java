package com.dailypoor.client.requestfactory;

import com.dailypoor.client.beanproxy.UsuarioProxy;
import com.dailypoor.server.model.process.GestionUsuario;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value=GestionUsuario.class)
public interface ContextGestionUsuario extends RequestContext{
	Request<Boolean> insertarUsuario(UsuarioProxy bean);
	Request<Boolean> insertarUsuario(String correo, String clave,String nombres,String apellidos);
}
