package com.dailypoor.client.service;

import com.dailypoor.server.model.bean.Usuario;
import com.dailypoor.shared.UnknownException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("servicegestionusuario")
public interface ServiceGestionUsuario extends RemoteService{
	Usuario logearUsuario(String correo,String clave) throws UnknownException;
}
