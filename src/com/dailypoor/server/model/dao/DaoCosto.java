package com.dailypoor.server.model.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.dailypoor.server.model.bean.Costo;
import com.dailypoor.shared.BeanParametro;
import com.dailypoor.shared.UnknownException;

public class DaoCosto {
private PersistenceManager pm;
private static final Logger LOG = Logger.getLogger(DaoCosto.class.getName());
	
	public DaoCosto(PersistenceManager pm){
		this.pm = pm;
	}
	
	public boolean mantenimiento(BeanParametro parametro) throws UnknownException{
		Querys query = new Querys(this.pm);
		return query.mantenimiento(parametro);
	}
	
	public Object getBean(Long id) throws UnknownException{
		Querys query = new Querys(this.pm);
		return query.getBean(Costo.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Costo> getListarBean() throws UnknownException{
		Querys query = new Querys(this.pm);
		Collection<Costo> lista = (Collection<Costo>) query.getListaBean(Costo.class);
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Costo> getListarBean(String correo) throws UnknownException{
		
		Query query = pm.newQuery(Costo.class);
		query.setFilter("correo == paramCorreo");
		query.setOrdering("version desc");
		query.declareParameters("String paramCorreo");
		try{
		List<Costo> lista=new ArrayList<Costo>();
		lista.addAll((List<Costo>)query.execute(correo));
		return lista;
		}catch(Exception ex){
			LOG.warning(ex.getMessage());
			LOG.info(ex.getLocalizedMessage());
			throw new UnknownException(ex.getMessage());
		}finally{
			query.closeAll();
		}
	}
}
