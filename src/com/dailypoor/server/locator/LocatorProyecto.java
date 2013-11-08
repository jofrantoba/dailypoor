package com.dailypoor.server.locator;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.Proyecto;
import com.dailypoor.server.model.dao.PMF;
import com.dailypoor.server.model.dao.Querys;
import com.google.web.bindery.requestfactory.shared.Locator;

public class LocatorProyecto extends Locator<Proyecto,Long>{

	@Override
	public Proyecto create(Class<? extends Proyecto> clazz) {
		// TODO Auto-generated method stub
		return new Proyecto();
	}

	@Override
	public Proyecto find(Class<? extends Proyecto> clazz, Long id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = PMF.getPMF().getPersistenceManager();
		Querys query = new Querys(pm);
		try{
			Proyecto bean = (Proyecto) query.getBean(clazz, id);
			pm.close();
			return bean;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Class<Proyecto> getDomainType() {
		// TODO Auto-generated method stub
		return Proyecto.class;
	}

	@Override
	public Long getId(Proyecto domainObject) {
		// TODO Auto-generated method stub
		return domainObject.getIdProyecto();
	}

	@Override
	public Class<Long> getIdType() {
		// TODO Auto-generated method stub
		return Long.class;
	}

	@Override
	public Object getVersion(Proyecto domainObject) {
		// TODO Auto-generated method stub
		return domainObject.getVersion();
	}

}
