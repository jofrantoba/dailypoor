package com.dailypoor.client.view.uiregister;

import java.util.Date;

import com.dailypoor.client.beanproxy.UsuarioProxy;
import com.dailypoor.client.requestfactory.ContextGestionUsuario;
import com.dailypoor.client.requestfactory.FactoryGestion;
import com.dailypoor.client.view.uihome.UIHome;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.Receiver;

public class UIRegisterImpl extends UIRegister{
	private final FactoryGestion FACTORY=GWT.create(FactoryGestion.class);
	private final EventBus EVENTBUS = new SimpleEventBus();
	
	public UIRegisterImpl(UIHome uiHome) {
		super(uiHome);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void crearCuenta() {
		// TODO Auto-generated method stub		
		Date fecha=new Date();		
		ContextGestionUsuario context=FACTORY.contextGestionUsuario();
		FACTORY.initialize(EVENTBUS);
		UsuarioProxy bean=context.create(UsuarioProxy.class);
		bean.setOperacion("I");
		bean.setVersion(fecha.getTime());
		bean.setNombre(this.txtNombres.getText());
		bean.setApellidos(this.txtApellidos.getText());
		bean.setCorreo(this.txtCorreo.getText());
		bean.setClave(this.txtClave.getText());
		Request<Boolean> request = context.insertarUsuario(bean);
		request.fire(new Receiver<Boolean>() {

			@Override
			public void onSuccess(Boolean response) {
				// TODO Auto-generated method stub
				if(response){
					Window.alert("Registrado Correctamente");	
					cleanForm();
				}
			}});		
	}
	
	
	@Override
	public void cleanForm() {
		// TODO Auto-generated method stub
		this.txtNombres.setText(null);
		this.txtApellidos.setText(null);
		this.txtCorreo.setText(null);
		this.txtClave.setText(null);		
	}
	
}
