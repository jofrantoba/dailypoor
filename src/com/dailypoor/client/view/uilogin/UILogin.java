package com.dailypoor.client.view.uilogin;

import com.dailypoor.client.view.uihome.UIHome;
import com.dailypoor.server.model.bean.Usuario;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.dom.client.event.touch.TouchEndEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchEndHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.FormListEntry;
import com.googlecode.mgwt.ui.client.widget.MEmailTextBox;
import com.googlecode.mgwt.ui.client.widget.MPasswordTextBox;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class UILogin extends Composite implements InterUILogin,TouchEndHandler {	
	private FlowPanel pnlContenedor;
	private WidgetList pnlForm;	
	protected MEmailTextBox txtCorreo;
	protected MPasswordTextBox txtClave;
	private Button btnLogin;
	private RoundPanel pnlEnlace;
	private Label lnkCuenta;
	protected UIHome uiHome;
	
	public UILogin(UIHome uiHome){
		this.uiHome=uiHome;
		initComponents();
		style();
		widgetListener();		
	}
	
	private void initComponents(){		
		pnlContenedor=new FlowPanel();
		pnlForm=new WidgetList();		
		txtCorreo=new MEmailTextBox();
		txtClave=new MPasswordTextBox();
		btnLogin=new Button("Iniciar Sesion");
		pnlEnlace=new RoundPanel();
		lnkCuenta=new Label("Crear Cuenta");
		pnlEnlace.add(lnkCuenta);		
		pnlForm.add(new FormListEntry("Correo",txtCorreo));
		pnlForm.add(new FormListEntry("Clave",txtClave));
		pnlContenedor.add(pnlForm);
		pnlContenedor.add(btnLogin);
		pnlContenedor.add(pnlEnlace);			
		initWidget(pnlContenedor);
	}
	
	private void style(){
		lnkCuenta.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lnkCuenta.getElement().getStyle().setFontSize(6, Unit.MM);
		pnlEnlace.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		btnLogin.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		txtCorreo.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		txtCorreo.getElement().getStyle().setBorderWidth(1, Unit.PX);
		txtCorreo.getElement().getStyle().setWidth(100, Unit.PCT);
		txtClave.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		txtClave.getElement().getStyle().setBorderWidth(1, Unit.PX);
		txtClave.getElement().getStyle().setWidth(100, Unit.PCT);
	}
	
	private void widgetListener(){
		btnLogin.addTouchEndHandler(this);
		pnlEnlace.addTouchEndHandler(this);
	}	

	@Override
	public void onTouchEnd(TouchEndEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(btnLogin)){
			login();
		}else if(event.getSource().equals(pnlEnlace)){
			irCuenta();	
		}
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void irCuenta() {
		// TODO Auto-generated method stub
		uiHome.getPnlViews().showWidget(0);
	}	

	@Override
	public void irSesion(Usuario bean) {
		// TODO Auto-generated method stub
		
	}
	
		
}
