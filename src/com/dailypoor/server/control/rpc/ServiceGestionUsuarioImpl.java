package com.dailypoor.server.control.rpc;

import javax.servlet.http.HttpSession;

import com.dailypoor.client.service.ServiceGestionUsuario;
import com.dailypoor.server.model.bean.Usuario;
import com.dailypoor.server.model.process.GestionUsuario;
import com.dailypoor.shared.UnknownException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ServiceGestionUsuarioImpl extends RemoteServiceServlet implements ServiceGestionUsuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Usuario logearUsuario(String correo, String clave) throws UnknownException {
		// TODO Auto-generated method stub
		Usuario bean=GestionUsuario.logearUsuario(correo, clave);
		if(bean!=null){
			HttpSession sesion = this.getThreadLocalRequest().getSession(true);
			String idSesion=sesion.getId();
			bean.setIdSesion(idSesion);
			sesion.setAttribute("beanusuario", bean);
			sesion.setAttribute("idsession", idSesion);			
		}
		return bean;
	}

}
