package com.dailypoor.client.view.uimantcosto;

import java.util.Date;

import com.dailypoor.client.beanproxy.CostoProxy;
import com.dailypoor.client.requestfactory.ContextGestionCosto;
import com.dailypoor.client.requestfactory.FactoryGestion;
import com.dailypoor.client.view.uiadmincosto.UIAdminCosto;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

public class UIMantCostoImpl extends UIMantCosto{
	private final FactoryGestion FACTORY=GWT.create(FactoryGestion.class);
	private final EventBus EVENTBUS = new SimpleEventBus();	

	public UIMantCostoImpl(UIAdminCosto uiAdminCosto) {
		super(uiAdminCosto);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void registrar() {
		// TODO Auto-generated method stub
		Date fecha=new Date();
		ContextGestionCosto context=FACTORY.contextGestionCosto();
		FACTORY.initialize(EVENTBUS);
		CostoProxy bean=context.create(CostoProxy.class);
		bean.setOperacion("I");
		bean.setVersion(fecha.getTime());
		bean.setNombre(txtNombre.getText());
		bean.setCorreo(this.uiAdminCosto.getUiSesion().getBeanUsuario().getCorreo());
		Request<Boolean> request = context.insertarCosto(bean);
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
	public void actualizar() {
		// TODO Auto-generated method stub
		Date fecha=new Date();
		ContextGestionCosto context=FACTORY.contextGestionCosto();
		FACTORY.initialize(EVENTBUS);
		CostoProxy bean=context.create(CostoProxy.class);
		bean.setIdCosto(beanCostoProxy.getIdCosto());
		bean.setVersion(fecha.getTime());
		bean.setNombre(txtNombre.getText());
		bean.setOperacion("A");
		bean.setCorreo(beanCostoProxy.getCorreo());
		Request<Boolean> request = context.actualizarCosto(bean);
		request.fire(new Receiver<Boolean>() {

			@Override
			public void onSuccess(Boolean response) {
				// TODO Auto-generated method stub
				if(response){
					Window.alert("Actualizado Correctamente");
					beanCostoProxy=null;
					irACostos();
				}
			}});
	}			
	
	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		Date fecha=new Date();
		ContextGestionCosto context=FACTORY.contextGestionCosto();
		FACTORY.initialize(EVENTBUS);
		CostoProxy bean=context.create(CostoProxy.class);
		bean.setIdCosto(beanCostoProxy.getIdCosto());
		bean.setVersion(fecha.getTime());
		bean.setNombre(txtNombre.getText());
		bean.setOperacion("E");
		bean.setCorreo(beanCostoProxy.getCorreo());
		Request<Boolean> request = context.eliminarCosto(bean);
		request.fire(new Receiver<Boolean>() {

			@Override
			public void onSuccess(Boolean response) {
				// TODO Auto-generated method stub
				if(response){
					Window.alert("Eliminado Correctamente");
					beanCostoProxy=null;
					irACostos();
				}
			}});
	}

}
