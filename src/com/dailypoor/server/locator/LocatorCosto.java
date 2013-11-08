package com.dailypoor.server.locator;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.Costo;
import com.dailypoor.server.model.dao.PMF;
import com.dailypoor.server.model.dao.Querys;
import com.google.web.bindery.requestfactory.shared.Locator;

public class LocatorCosto  extends Locator<Costo,Long>{

	@Override
	public Costo create(Class<? extends Costo> clazz) {
		// TODO Auto-generated method stub
		return new Costo();
	}

	@Override
	public Costo find(Class<? extends Costo> clazz, Long id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = PMF.getPMF().getPersistenceManager();
		Querys query = new Querys(pm);
		try{
			Costo bean = (Costo) query.getBean(clazz, id);
			pm.close();
			return bean;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Class<Costo> getDomainType() {
		// TODO Auto-generated method stub
		return Costo.class;
	}

	@Override
	public Long getId(Costo domainObject) {
		// TODO Auto-generated method stub
		return domainObject.getIdCosto();
	}

	@Override
	public Class<Long> getIdType() {
		// TODO Auto-generated method stub
		return Long.class;
	}

	@Override
	public Object getVersion(Costo domainObject) {
		// TODO Auto-generated method stub
		return domainObject.getVersion();
	}

}
