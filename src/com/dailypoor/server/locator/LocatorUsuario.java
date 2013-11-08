package com.dailypoor.server.locator;

import javax.jdo.PersistenceManager;

import com.dailypoor.server.model.bean.Usuario;
import com.dailypoor.server.model.dao.PMF;
import com.dailypoor.server.model.dao.Querys;
import com.google.web.bindery.requestfactory.shared.Locator;

public class LocatorUsuario extends Locator<Usuario,String>{

	@Override
	public Usuario create(Class<? extends Usuario> clazz) {
		// TODO Auto-generated method stub
		return new Usuario();
	}

	@Override
	public Usuario find(Class<? extends Usuario> clazz, String id) {
		// TODO Auto-generated method stub
		PersistenceManager pm = PMF.getPMF().getPersistenceManager();
		Querys query = new Querys(pm);
		try{
			Usuario bean = (Usuario) query.getBean(clazz, id);
			pm.close();
			return bean;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Class<Usuario> getDomainType() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

	@Override
	public String getId(Usuario domainObject) {
		// TODO Auto-generated method stub
		return domainObject.getCorreo();
	}

	@Override
	public Class<String> getIdType() {
		// TODO Auto-generated method stub
		return String.class;
	}

	@Override
	public Object getVersion(Usuario domainObject) {
		// TODO Auto-generated method stub
		return domainObject.getVersion();
	}

}