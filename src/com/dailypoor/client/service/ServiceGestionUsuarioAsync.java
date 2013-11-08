package com.dailypoor.client.service;

import com.dailypoor.server.model.bean.Usuario;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServiceGestionUsuarioAsync {

	void logearUsuario(String correo, String clave,AsyncCallback<Usuario> callback);

}
