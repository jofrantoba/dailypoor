package com.dailypoor.server.model.dao;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.ProyectoCosto;
import com.dailypoor.shared.BeanParametro;
import com.dailypoor.shared.UnknownException;

public class DaoProyectoCosto {
private PersistenceManager pm;
	
	public DaoProyectoCosto(PersistenceManager pm){
		this.pm = pm;
	}
	
	public boolean mantenimiento(BeanParametro parametro) throws UnknownException{
		Querys query = new Querys(this.pm);
		return query.mantenimiento(parametro);
	}
	
	public Object getBean(Long id) throws UnknownException{
		Querys query = new Querys(this.pm);
		return query.getBean(ProyectoCosto.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<ProyectoCosto> getListarBean() throws UnknownException{
		Querys query = new Querys(this.pm);
		Collection<ProyectoCosto> lista = (Collection<ProyectoCosto>) query.getListaBean(ProyectoCosto.class);
		return lista;
	}
}
