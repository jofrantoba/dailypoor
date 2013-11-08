package com.dailypoor.server.model.logic;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.Usuario;
import com.dailypoor.server.model.dao.DaoUsuario;
import com.dailypoor.shared.BeanParametro;
import com.dailypoor.shared.UnknownException;

public class LogicUsuario {
private PersistenceManager pm;
	
	public LogicUsuario(PersistenceManager pm) {
		this.pm = pm;
	}
	
	public boolean mantenimiento(BeanParametro parametro) throws UnknownException{
		DaoUsuario dao = new DaoUsuario(this.pm);
		return dao.mantenimiento(parametro);
	}
	
	public Object getBean(String id) throws UnknownException{
		DaoUsuario dao = new DaoUsuario(this.pm);
		return dao.getBean(id);
	}
	
	public Collection<Usuario> getListarBean() throws UnknownException{
		DaoUsuario dao = new DaoUsuario(this.pm);
		Collection<Usuario> lista = dao.getListarBean();
		return lista;
	}
}
