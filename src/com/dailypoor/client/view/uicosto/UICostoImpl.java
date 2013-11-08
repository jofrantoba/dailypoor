package com.dailypoor.client.view.uicosto;

import java.util.List;

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

public class UICostoImpl extends UICosto{
	private final FactoryGestion FACTORY = GWT.create(FactoryGestion.class);
	private final EventBus EVENTBUS = new SimpleEventBus();

	public UICostoImpl(UIAdminCosto uiAdminCosto) {
		super(uiAdminCosto);
		//cargarTabla();			
	}
	
	@Override
	public void cargarTabla() {
		// TODO Auto-generated method stub
		ContextGestionCosto context = FACTORY.contextGestionCosto();
		FACTORY.initialize(EVENTBUS);
		Request<List<CostoProxy>> request=context.listarCosto(this.uiAdminCosto.getUiSesion().getBeanUsuario().getCorreo());
		request.fire(new Receiver<List<CostoProxy>>(){

			@Override
			public void onSuccess(List<CostoProxy> response) {
				// TODO Auto-generated method stub
				grid.setData(response);
				grid.getSelectionModel().clear();
				scroll.refresh();
			}});
	}
	
	@Override
	public void procesoEditar() {
		// TODO Auto-generated method stub
		try{
			CostoProxy bean=grid.getSelectionModel().getSelectedObject();					
			uiAdminCosto.getUiMantCosto().setBeanCostoProxy(bean);
			uiAdminCosto.getUiMantCosto().loadActualizar();
			uiAdminCosto.showWidget(1);			
		}catch(Exception ex){
			Window.alert("Seleccione un costo");
		}
	}
	
	@Override
	public void procesoEliminar() {
		// TODO Auto-generated method stub
		try{
			CostoProxy bean=grid.getSelectionModel().getSelectedObject();					
			uiAdminCosto.getUiMantCosto().setBeanCostoProxy(bean);
			uiAdminCosto.getUiMantCosto().loadEliminar();
			uiAdminCosto.showWidget(1);
		}catch(Exception ex){
			Window.alert("Seleccione un costo");
		}
	}

}
