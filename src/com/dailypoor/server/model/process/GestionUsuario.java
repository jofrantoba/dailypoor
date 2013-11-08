package com.dailypoor.server.model.process;

import java.util.Date;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import com.dailypoor.server.locator.LocatorUsuario;
import com.dailypoor.server.model.bean.Usuario;
import com.dailypoor.server.model.dao.PMF;
import com.dailypoor.server.model.logic.LogicUsuario;
import com.dailypoor.shared.BeanParametro;
import com.dailypoor.shared.UnknownException;

public class GestionUsuario {
	private static final Logger LOG = Logger
			.getLogger(GestionUsuario.class.getName());
	
	public static Boolean insertarUsuario(Usuario bean)
			throws UnknownException {
		if (bean.getOperacion().equalsIgnoreCase("I")
				&& bean.getCorreo() != null) {			
			BeanParametro parametro = new BeanParametro();			
			parametro.setBean(bean);
			parametro.setTipoOperacion(bean.getOperacion());
			PersistenceManager pm = null;
			Transaction tx = null;
			try {
				pm = PMF.getPMF().getPersistenceManager();
				tx = pm.currentTransaction();
				tx.begin();
				LogicUsuario logic = new LogicUsuario(pm);
				Boolean resultado = logic.mantenimiento(parametro);
				if (resultado) {
					tx.commit();
					pm.close();
					return true;
				} else {
					tx.rollback();
					pm.close();
					return false;
				}
			} catch (Exception ex) {
				LOG.warning(ex.getMessage());
				LOG.info(ex.getLocalizedMessage());
				throw new UnknownException(ex.getMessage());
			} finally {
				if (!pm.isClosed()) {
					if (tx.isActive()) {
						tx.rollback();
					}
					pm.close();
				}
			}
		} else {
			throw new UnknownException("Verifique Catalogo de Servicio");
		}
	}

	public static Boolean insertarUsuario(String correo, String clave,String nombres,String apellidos)
			throws UnknownException {
		Usuario bean = new Usuario();
		bean.setCorreo(correo);
		bean.setClave(clave);
		bean.setNombre(nombres);
		bean.setApellidos(apellidos);
		bean.setOperacion("I");
		bean.setVersion((new Date()).getTime());
		BeanParametro parametro = new BeanParametro();
		parametro.setBean(bean);
		parametro.setTipoOperacion(bean.getOperacion());
		PersistenceManager pm = null;
		Transaction tx = null;
		try {
			pm = PMF.getPMF().getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			LogicUsuario logic = new LogicUsuario(pm);
			Boolean resultado = logic.mantenimiento(parametro);
			if (resultado) {
				tx.commit();
				pm.close();
				return true;
			} else {
				tx.rollback();
				pm.close();
				return false;
			}
		} catch (Exception ex) {
			LOG.warning(ex.getMessage());
			LOG.info(ex.getLocalizedMessage());
			throw new UnknownException(ex.getMessage());
		} finally {
			if (!pm.isClosed()) {
				if (tx.isActive()) {
					tx.rollback();
				}
				pm.close();
			}
		}
	}
	
	public static Usuario logearUsuario(String correo,String clave) throws UnknownException{		
		LocatorUsuario loc=new LocatorUsuario();
		Usuario bean=loc.find(Usuario.class,correo);
		if(bean!=null && bean.getClave().equalsIgnoreCase(clave)){
			return bean;
		}else{
			throw new UnknownException("Usuario o clave incorrectos");
		}
	}


}
