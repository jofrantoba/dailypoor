package com.dailypoor.server.locator;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.ProyectoCosto;
import com.dailypoor.server.model.dao.PMF;
import com.dailypoor.server.model.dao.Querys;
import com.google.web.bindery.requestfactory.shared.Locator;

public class LocatorProyectoCosto extends Locator<ProyectoCosto,Long>{

	@Override
	public ProyectoCosto create(Class<? extends ProyectoCosto> clazz) {
		// TODO Auto-generated method stub
		return new ProyectoCosto();
	}

	@Override
	public ProyectoCosto find(Class<? extends ProyectoCosto> clazz, Long id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = PMF.getPMF().getPersistenceManager();
		Querys query = new Querys(pm);
		try{
			ProyectoCosto bean = (ProyectoCosto) query.getBean(clazz, id);
			pm.close();
			return bean;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Class<ProyectoCosto> getDomainType() {
		// TODO Auto-generated method stub
		return ProyectoCosto.class;
	}

	@Override
	public Long getId(ProyectoCosto domainObject) {
		// TODO Auto-generated method stub
		return domainObject.getIdProyectoCosto();
	}

	@Override
	public Class<Long> getIdType() {
		// TODO Auto-generated method stub
		return Long.class;
	}

	@Override
	public Object getVersion(ProyectoCosto domainObject) {
		// TODO Auto-generated method stub
		return domainObject.getVersion();
	}

}
