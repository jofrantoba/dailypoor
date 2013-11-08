package com.dailypoor.client.requestfactory;

import java.util.List;

import com.dailypoor.client.beanproxy.CostoProxy;
import com.dailypoor.server.model.process.GestionCosto;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(value=GestionCosto.class)
public interface ContextGestionCosto extends RequestContext{
	Request<Boolean> insertarCosto(CostoProxy bean);
	Request<Boolean> actualizarCosto(CostoProxy bean);
	Request<Boolean> eliminarCosto(CostoProxy bean);
	Request<List<CostoProxy>> listarCosto();
	Request<List<CostoProxy>> listarCosto(String correo);
}
