package com.dailypoor.client.view.uiproject;

import com.dailypoor.client.resource.MyResource;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.googlecode.mgwt.ui.client.widget.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

public class UIProject extends Composite{
	private FlowPanel pnlContenedor; 
	private MSearchBox txtSearch;
	private PushButton btnFiltro;
	private PushButton btnTodo;
	private PushButton btnNuevo;
	private PushButton btnEliminar;
	private PushButton btnEditar;
	private PushButton btnReport;
	private PushButton btnEnviar;
	private FlowPanel pnlInMovil;	
	private FlowPanel pnlSearch;
	private FlowPanel pnlToolBar;
	private ScrollPanel pnlScrlPanel;
	
	public UIProject(){
		initComponents();
		style();
	}
	
	private void initComponents(){
		Window.setMargin("0px");
		pnlContenedor=new FlowPanel();
		pnlInMovil=new FlowPanel();
		pnlSearch=new FlowPanel();		
		pnlToolBar=new FlowPanel();
		pnlInMovil.add(pnlSearch);
		pnlInMovil.add(pnlToolBar);		
		pnlContenedor.add(pnlInMovil);
		pnlScrlPanel=new ScrollPanel();
		pnlScrlPanel.setScrollingEnabledX(false);
		pnlContenedor.add(pnlScrlPanel);		
		txtSearch=new MSearchBox();
		btnFiltro=new PushButton(new Image(MyResource.INSTANCE.getImgFiltro32()));
		btnTodo=new PushButton(new Image(MyResource.INSTANCE.getImgTodo32()));
		btnNuevo=new PushButton(new Image(MyResource.INSTANCE.getImgNuevo32()));
		btnEliminar=new PushButton(new Image(MyResource.INSTANCE.getImgEliminar32()));
		btnEditar=new PushButton(new Image(MyResource.INSTANCE.getImgEditar32()));
		btnReport=new PushButton(new Image(MyResource.INSTANCE.getImgReporte32()));
		btnEnviar=new PushButton(new Image(MyResource.INSTANCE.getImgEnviar32()));
		pnlToolBar.add(btnNuevo);
		btnNuevo.setTitle("Nuevo");
		pnlToolBar.add(btnEditar);
		btnEditar.setTitle("Editar");
		pnlToolBar.add(btnEliminar);
		btnEliminar.setTitle("Eliminar");
		pnlToolBar.add(btnEnviar);
		btnEnviar.setTitle("Enviar a Correo");
		pnlToolBar.add(btnReport);
		btnReport.setTitle("Ver Reporte");
		pnlSearch.add(txtSearch);
		pnlToolBar.add(btnFiltro);		
		btnFiltro.setTitle("Filtro");
		pnlToolBar.add(btnTodo);
		btnTodo.setTitle("Actualizar");
		initWidget(pnlContenedor);		
	}
	
	private void style(){
		MyResource.INSTANCE.getStlUIProject().ensureInjected();						
		btnFiltro.setWidth("9mm");
		btnTodo.setWidth("9mm");
		btnNuevo.setWidth("9mm");
		btnEditar.setWidth("9mm");
		btnEliminar.setWidth("9mm");
		btnEnviar.setWidth("9mm");
		btnReport.setWidth("9mm");
		pnlInMovil.getElement().getStyle().setDisplay(Style.Display.BLOCK);
		pnlToolBar.getElement().getStyle().setDisplay(Style.Display.INLINE_BLOCK);
		pnlSearch.getElement().getStyle().setDisplay(Style.Display.INLINE_BLOCK);
		txtSearch.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnFiltro.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnTodo.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnNuevo.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnEditar.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnEliminar.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnEnviar.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnReport.getElement().getStyle().setFloat(Style.Float.LEFT);			
	}
}
