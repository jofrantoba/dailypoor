package com.dailypoor.server.model.logic;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.ProyectoCosto;
import com.dailypoor.server.model.dao.DaoProyectoCosto;
import com.dailypoor.shared.BeanParametro;
import com.dailypoor.shared.UnknownException;

public class LogicProyectoCosto {
private PersistenceManager pm;
	
	public LogicProyectoCosto(PersistenceManager pm) {
		this.pm = pm;
	}
	
	public boolean mantenimiento(BeanParametro parametro) throws UnknownException{
		DaoProyectoCosto dao = new DaoProyectoCosto(this.pm);
		return dao.mantenimiento(parametro);
	}
	
	public Object getBean(Long id) throws UnknownException{
		DaoProyectoCosto dao = new DaoProyectoCosto(this.pm);
		return dao.getBean(id);
	}
	
	public Collection<ProyectoCosto> getListarBean() throws UnknownException{
		DaoProyectoCosto dao = new DaoProyectoCosto(this.pm);
		Collection<ProyectoCosto> lista = dao.getListarBean();
		return lista;
	}
}
