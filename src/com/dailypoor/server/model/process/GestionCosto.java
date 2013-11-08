package com.dailypoor.server.model.process;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import com.dailypoor.server.model.bean.Costo;
import com.dailypoor.server.model.dao.PMF;
import com.dailypoor.server.model.logic.LogicCosto;
import com.dailypoor.shared.BeanParametro;
import com.dailypoor.shared.UnknownException;

public class GestionCosto {
	private static final Logger LOG = Logger
			.getLogger(GestionCosto.class.getName());
	
	public static Boolean insertarCosto(Costo bean)
			throws UnknownException {
		if (bean.getOperacion().equalsIgnoreCase("I")
				&& bean.getIdCosto() == null) {
			BeanParametro parametro = new BeanParametro();			
			parametro.setBean(bean);
			parametro.setTipoOperacion(bean.getOperacion());
			PersistenceManager pm = null;
			Transaction tx = null;
			try {
				pm = PMF.getPMF().getPersistenceManager();
				tx = pm.currentTransaction();
				tx.begin();
				LogicCosto logic = new LogicCosto(pm);
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

	public static Boolean insertarCosto(String nombre,String correo)
			throws UnknownException {
		Costo bean = new Costo();
		bean.setNombre(nombre);
		bean.setCorreo(correo);		
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
			LogicCosto logic = new LogicCosto(pm);
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
	
	public static Boolean actualizarCosto(Costo bean)
			throws UnknownException {
		if (bean.getOperacion().equalsIgnoreCase("A")
				&& bean.getIdCosto() != null) {
			BeanParametro parametro = new BeanParametro();
			parametro.setBean(bean);
			parametro.setTipoOperacion(bean.getOperacion());
			PersistenceManager pm = null;
			Transaction tx = null;
			try {
				pm = PMF.getPMF().getPersistenceManager();
				tx = pm.currentTransaction();
				tx.begin();
				LogicCosto logic = new LogicCosto(pm);
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

	public static Boolean actualizarCosto(Long idCosto,
			String nombre,String correo) throws UnknownException {
		Costo bean = new Costo();
		bean.setIdCosto(idCosto);
		bean.setNombre(nombre);
		bean.setCorreo(correo);
		bean.setOperacion("A");
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
			LogicCosto logic = new LogicCosto(pm);
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

	public static Boolean eliminarCosto(Costo bean)
			throws UnknownException {
		if (bean.getOperacion().equalsIgnoreCase("E")
				&& bean.getIdCosto() != null) {
			BeanParametro parametro = new BeanParametro();
			parametro.setId(bean.getIdCosto());
			parametro.setBean(bean);
			parametro.setTipoOperacion(bean.getOperacion());
			PersistenceManager pm = null;
			Transaction tx = null;
			try {
				pm = PMF.getPMF().getPersistenceManager();
				tx = pm.currentTransaction();
				tx.begin();
				LogicCosto logic = new LogicCosto(pm);
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

	public static Boolean eliminarCosto(Long idCosto)
			throws UnknownException {
		Costo bean = new Costo();
		bean.setIdCosto(idCosto);
		bean.setOperacion("E");
		BeanParametro parametro = new BeanParametro();
		parametro.setId(bean.getIdCosto());
		parametro.setBean(bean);
		parametro.setTipoOperacion(bean.getOperacion());
		PersistenceManager pm = null;
		Transaction tx = null;
		try {
			pm = PMF.getPMF().getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			LogicCosto logic = new LogicCosto(pm);
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

	public static List<Costo> listarCosto()
			throws UnknownException {

		PersistenceManager pm = null;
		try {
			pm = PMF.getPMF().getPersistenceManager();
			LogicCosto logic = new LogicCosto(pm);
			List<Costo> resultado = (List<Costo>) logic
					.getListarBean();
			pm.close();
			return resultado;
		} catch (Exception ex) {
			LOG.warning(ex.getMessage());
			LOG.info(ex.getLocalizedMessage());
			throw new UnknownException(ex.getMessage());
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}

	}
	
	public static List<Costo> listarCosto(String correo)
			throws UnknownException {

		PersistenceManager pm = null;
		try {
			pm = PMF.getPMF().getPersistenceManager();
			LogicCosto logic = new LogicCosto(pm);
			List<Costo> resultado = (List<Costo>) logic
					.getListarBean(correo);
			pm.close();
			return resultado;
		} catch (Exception ex) {
			LOG.warning(ex.getMessage());
			LOG.info(ex.getLocalizedMessage());
			throw new UnknownException(ex.getMessage());
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}

	}
	

	public static Costo getCosto(Long idCosto)
			throws UnknownException {

		PersistenceManager pm = null;
		try {
			pm = PMF.getPMF().getPersistenceManager();
			LogicCosto logic = new LogicCosto(pm);
			Costo resultado = (Costo) logic
					.getBean(idCosto);
			pm.close();
			return resultado;
		} catch (Exception ex) {
			LOG.warning(ex.getMessage());
			LOG.info(ex.getLocalizedMessage());
			throw new UnknownException(ex.getMessage());
		} finally {
			if (!pm.isClosed()) {
				pm.close();
			}
		}

	}

}
