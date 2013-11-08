package com.dailypoor.server.model.logic;

import java.util.Collection;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.Costo;
import com.dailypoor.server.model.dao.DaoCosto;
import com.dailypoor.shared.BeanParametro;
import com.dailypoor.shared.UnknownException;

public class LogicCosto {
	private PersistenceManager pm;
	
	public LogicCosto(PersistenceManager pm) {
		this.pm = pm;
	}
	
	public boolean mantenimiento(BeanParametro parametro) throws UnknownException{
		DaoCosto dao = new DaoCosto(this.pm);
		return dao.mantenimiento(parametro);
	}
	
	public Object getBean(Long id) throws UnknownException{
		DaoCosto dao = new DaoCosto(this.pm);
		return dao.getBean(id);
	}
	
	public Collection<Costo> getListarBean() throws UnknownException{
		DaoCosto dao = new DaoCosto(this.pm);
		Collection<Costo> lista = dao.getListarBean();
		return lista;
	}
	
	public Collection<Costo> getListarBean(String correo) throws UnknownException{
		DaoCosto dao = new DaoCosto(this.pm);
		Collection<Costo> lista = dao.getListarBean(correo);
		return lista;
	}
	
}
