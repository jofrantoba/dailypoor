package com.dailypoor.server.model.logic;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.Proyecto;
import com.dailypoor.server.model.dao.DaoProyecto;
import com.dailypoor.shared.BeanParametro;
import com.dailypoor.shared.UnknownException;

public class LogicProyecto {
private PersistenceManager pm;
	
	public LogicProyecto(PersistenceManager pm) {
		this.pm = pm;
	}
	
	public boolean mantenimiento(BeanParametro parametro) throws UnknownException{
		DaoProyecto dao = new DaoProyecto(this.pm);
		return dao.mantenimiento(parametro);
	}
	
	public Object getBean(Long id) throws UnknownException{
		DaoProyecto dao = new DaoProyecto(this.pm);
		return dao.getBean(id);
	}
	
	public Collection<Proyecto> getListarBean() throws UnknownException{
		DaoProyecto dao = new DaoProyecto(this.pm);
		Collection<Proyecto> lista = dao.getListarBean();
		return lista;
	}
}
