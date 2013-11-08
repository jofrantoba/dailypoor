package com.dailypoor.client.view.uicosto;

import com.dailypoor.client.grid.GridCosto;
import com.dailypoor.client.resource.MyResource;
import com.dailypoor.client.view.uiadmincosto.UIAdminCosto;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PushButton;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

public class UICosto extends Composite implements InterUICosto,ClickHandler{
	private LayoutPanel pnlContenedor; 
	private MSearchBox txtSearch;	
	private PushButton btnTodo;
	private PushButton btnNuevo;
	private PushButton btnEliminar;
	private PushButton btnEditar;		
	private FlowPanel pnlInMovil;	
	private FlowPanel pnlSearch;
	private FlowPanel pnlToolBar;
	protected ScrollPanel scroll;
	protected UIAdminCosto uiAdminCosto;
	protected GridCosto grid;
	private FlowPanel gridPanel;
	
	public UICosto(UIAdminCosto uiAdminCosto){
		this.uiAdminCosto=uiAdminCosto;
		initComponents();
		style();
		widgetListener();		
	}
	
	private void initComponents(){
		Window.setMargin("0px");
		grid=new GridCosto();
		gridPanel=new FlowPanel();
		gridPanel.add(grid);
		pnlContenedor=new LayoutPanel();		
		pnlInMovil=new FlowPanel();
		pnlSearch=new FlowPanel();		
		pnlToolBar=new FlowPanel();
		pnlInMovil.add(pnlSearch);
		pnlInMovil.add(pnlToolBar);		
		pnlContenedor.add(pnlInMovil);
		scroll=new ScrollPanel();
		scroll.setScrollingEnabledY(true);
		scroll.setScrollingEnabledX(false);
		scroll.setAutoHandleResize(true);
		scroll.setShowScrollBarX(false);
		scroll.setShowScrollBarY(true);		
		scroll.setWidget(gridPanel);
		//scroll.setHeight("100%");
		pnlContenedor.add(scroll);
		//pnlContenedor.add(gridPanel);
		//pnlContenedor.setHeight("500px");
		//scroll.setHeight("100%");
		txtSearch=new MSearchBox();		
		btnTodo=new PushButton(new Image(MyResource.INSTANCE.getImgTodo32()));
		btnNuevo=new PushButton(new Image(MyResource.INSTANCE.getImgNuevo32()));
		btnEliminar=new PushButton(new Image(MyResource.INSTANCE.getImgEliminar32()));
		btnEditar=new PushButton(new Image(MyResource.INSTANCE.getImgEditar32()));		
		pnlToolBar.add(btnNuevo);
		btnNuevo.setTitle("Nuevo");
		pnlToolBar.add(btnEditar);
		btnEditar.setTitle("Editar");
		pnlToolBar.add(btnEliminar);
		btnEliminar.setTitle("Eliminar");				
		pnlSearch.add(txtSearch);		
		pnlToolBar.add(btnTodo);
		btnTodo.setTitle("Actualizar");		
		initWidget(pnlContenedor);		
	}
	
	private void style(){
		MyResource.INSTANCE.getStlUICosto().ensureInjected();								
		btnTodo.setWidth("9mm");
		btnNuevo.setWidth("9mm");
		btnEditar.setWidth("9mm");
		btnEliminar.setWidth("9mm");		
		pnlInMovil.getElement().getStyle().setDisplay(Style.Display.BLOCK);		
		pnlToolBar.getElement().getStyle().setDisplay(Style.Display.INLINE_BLOCK);
		pnlSearch.getElement().getStyle().setDisplay(Style.Display.INLINE_BLOCK);
		txtSearch.getElement().getStyle().setFloat(Style.Float.LEFT);		
		btnTodo.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnNuevo.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnEditar.getElement().getStyle().setFloat(Style.Float.LEFT);
		btnEliminar.getElement().getStyle().setFloat(Style.Float.LEFT);
		int height=Window.getClientHeight();
		height=height-110;		
		pnlContenedor.setHeight(height+"px");	
		pnlContenedor.setWidth("100%");
	}
	
	private void widgetListener(){
		btnNuevo.addClickHandler(this);
		btnEditar.addClickHandler(this);
		btnEliminar.addClickHandler(this);
		btnTodo.addClickHandler(this);
	}

	@Override
	public void procesoNuevo() {
		// TODO Auto-generated method stub
		uiAdminCosto.getUiMantCosto().loadRegistrar();		
		uiAdminCosto.showWidget(1);
	}

	@Override
	public void procesoEditar() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void procesoEliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procesoActualizar() {
		// TODO Auto-generated method stub
		cargarTabla();		
	}

	@Override
	public void onClick(ClickEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(btnNuevo)){
			procesoNuevo();			
		}else if(event.getSource().equals(btnEditar)){
			procesoEditar();
		}else if(event.getSource().equals(btnEliminar)){
			procesoEliminar();
		}else if(event.getSource().equals(btnTodo)){
			procesoActualizar();
		}
		
	}

	@Override
	public void cargarTabla() {
		// TODO Auto-generated method stub
		
	}
	
	
}
