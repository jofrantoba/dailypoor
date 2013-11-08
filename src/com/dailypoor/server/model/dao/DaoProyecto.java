package com.dailypoor.server.model.dao;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.Proyecto;
import com.dailypoor.shared.BeanParametro;
import com.dailypoor.shared.UnknownException;

public class DaoProyecto {
private PersistenceManager pm;
	
	public DaoProyecto(PersistenceManager pm){
		this.pm = pm;
	}
	
	public boolean mantenimiento(BeanParametro parametro) throws UnknownException{
		Querys query = new Querys(this.pm);
		return query.mantenimiento(parametro);
	}
	
	public Object getBean(Long id) throws UnknownException{
		Querys query = new Querys(this.pm);
		return query.getBean(Proyecto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Proyecto> getListarBean() throws UnknownException{
		Querys query = new Querys(this.pm);
		Collection<Proyecto> lista = (Collection<Proyecto>) query.getListaBean(Proyecto.class);
		return lista;
	}
}
