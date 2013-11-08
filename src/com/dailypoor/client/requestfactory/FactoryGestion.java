package com.dailypoor.client.requestfactory;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface FactoryGestion extends RequestFactory{
	ContextGestionUsuario contextGestionUsuario();
	ContextGestionCosto contextGestionCosto();
}
