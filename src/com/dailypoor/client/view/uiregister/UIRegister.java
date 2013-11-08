package com.dailypoor.client.view.uiregister;

import com.dailypoor.client.view.uihome.UIHome;
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
import com.googlecode.mgwt.ui.client.widget.MTextBox;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.WidgetList;

public class UIRegister extends Composite implements InterUIRegister,TouchEndHandler {	
	private FlowPanel pnlContenedor;
	private WidgetList pnlForm;
	protected MTextBox txtNombres;
	protected MTextBox txtApellidos;
	protected MEmailTextBox txtCorreo;
	protected MPasswordTextBox txtClave;
	private Button btnRegistrar;
	private RoundPanel pnlEnlace;
	private Label lnkLogin;
	protected UIHome uiHome;
	
	public UIRegister(UIHome uiHome){
		this.uiHome=uiHome;
		initComponents();
		style();
		widgetListener();
	}
	
	public UIRegister(){	
		initComponents();
		style();
		widgetListener();
	}
	
	private void initComponents(){		
		pnlContenedor=new FlowPanel();
		pnlForm=new WidgetList();
		txtNombres=new MTextBox();
		txtApellidos=new MTextBox();
		txtCorreo=new MEmailTextBox();
		txtClave=new MPasswordTextBox();
		btnRegistrar=new Button("Crear Cuenta");
		pnlEnlace=new RoundPanel();
		lnkLogin=new Label("Iniciar Sesion");
		pnlEnlace.add(lnkLogin);
		pnlForm.add(new FormListEntry("Nombres",txtNombres));
		pnlForm.add(new FormListEntry("Apellidos",txtApellidos));
		pnlForm.add(new FormListEntry("Correo",txtCorreo));
		pnlForm.add(new FormListEntry("Clave",txtClave));
		pnlContenedor.add(pnlForm);
		pnlContenedor.add(btnRegistrar);
		pnlContenedor.add(pnlEnlace);		
		initWidget(pnlContenedor);
	}
	
	private void style(){
		lnkLogin.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lnkLogin.getElement().getStyle().setFontSize(6, Unit.MM);
		pnlEnlace.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		btnRegistrar.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		txtNombres.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		txtNombres.getElement().getStyle().setBorderWidth(1, Unit.PX);
		txtNombres.getElement().getStyle().setWidth(100, Unit.PCT);
		txtApellidos.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		txtApellidos.getElement().getStyle().setBorderWidth(1, Unit.PX);
		txtApellidos.getElement().getStyle().setWidth(100, Unit.PCT);
		txtClave.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		txtClave.getElement().getStyle().setBorderWidth(1, Unit.PX);
		txtClave.getElement().getStyle().setWidth(100, Unit.PCT);
		txtCorreo.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		txtCorreo.getElement().getStyle().setBorderWidth(1, Unit.PX);
		txtCorreo.getElement().getStyle().setWidth(100, Unit.PCT);		
	}
	
	private void widgetListener(){
		btnRegistrar.addTouchEndHandler(this);
		pnlEnlace.addTouchEndHandler(this);
	}

	@Override
	public void crearCuenta() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void irLogin() {
		// TODO Auto-generated method stub
		uiHome.getPnlViews().showWidget(1);
	}

	@Override
	public void onTouchEnd(TouchEndEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(btnRegistrar)){
			crearCuenta();				
		}else if(event.getSource().equals(pnlEnlace)){
			irLogin();	
		}
	}

	@Override
	public void cleanForm() {
		// TODO Auto-generated method stub		
	}
	
		
}
