package com.dailypoor.client.view.uilogin;

import com.dailypoor.client.service.ServiceGestionUsuario;
import com.dailypoor.client.service.ServiceGestionUsuarioAsync;
import com.dailypoor.client.view.uihome.UIHome;
import com.dailypoor.server.model.bean.Usuario;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class UILoginImpl extends UILogin{
	private final ServiceGestionUsuarioAsync SERVICE=GWT.create(ServiceGestionUsuario.class);
	
	public UILoginImpl(UIHome uiHome) {
		super(uiHome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		SERVICE.logearUsuario(this.txtCorreo.getText(), this.txtClave.getText(), new AsyncCallback<Usuario>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert(caught.getMessage());
			}

			@Override
			public void onSuccess(Usuario result) {
				// TODO Auto-generated method stub
				Window.alert("Bienvenido a DailyPoor");
				irSesion(result);
			}});
	}
	
	@Override
	public void irSesion(Usuario bean) {
		// TODO Auto-generated method stub
		if(bean!=null && !bean.getIdSesion().isEmpty() && bean.getIdSesion()!=null){
			this.uiHome.getUiSesion().setBeanUsuario(bean);
			this.uiHome.getPnlViews().showWidget(2);
		}
	}
	
}
