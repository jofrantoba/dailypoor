package com.dailypoor.client.view.uimodel;


import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;

public class UIBorderLayout extends FlowPanel {
	
	private FlowPanel pnlContenido;
	private FlowPanel pnlNorte;
	private FlowPanel pnlSur;
	private FlowPanel pnlCentro;
	private FlowPanel pnlEste;
	private FlowPanel pnlOeste;
	
	public UIBorderLayout(){
		initComponents();
		asignarEstilos();
	}
	
	private void initComponents(){
		pnlContenido = new FlowPanel();
		pnlNorte = new FlowPanel();
		pnlSur = new FlowPanel();
		pnlCentro = new FlowPanel();
		pnlEste = new FlowPanel();
		pnlOeste = new FlowPanel();
		
		this.add(pnlNorte);
		this.add(pnlContenido);
		this.add(pnlSur);
		
		pnlContenido.add(pnlOeste);
		pnlContenido.add(pnlCentro);
		pnlContenido.add(pnlEste);
		
	}
	
	private void asignarEstilos(){
		/*this.getElement().setId("pnlContenedor");
		pnlContenido.getElement().setId("pnlContenido");
		pnlNorte.getElement().setId("pnlNorte");
		pnlSur.getElement().setId("pnlSur");
		pnlCentro.getElement().setId("pnlCentro");
		pnlEste.getElement().setId("pnlEste");
		pnlOeste.getElement().setId("pnlOeste");*/
		
		this.getElement().getStyle().setWidth(100,Unit.PCT);
		this.getElement().getStyle().setHeight(100,Unit.PCT);
		
		/*pnlNorte.getElement().getStyle().setWidth(100,Unit.PCT);
		pnlSur.getElement().getStyle().setWidth(100,Unit.PCT);
		
		pnlSur.getElement().getStyle().setProperty("position", "absolute");
		pnlSur.getElement().getStyle().setProperty("bottom", "0px");*/
		
		//pnlNorte.getElement().getStyle().setProperty("background", "url("+MyResource.INSTANCE.getImgBackGroundColor().getSafeUri().asString()+") repeat-x 0px -2600px");
	}

	public FlowPanel getPnlNorte() {
		return pnlNorte;
	}

	public FlowPanel getPnlSur() {
		return pnlSur;
	}

	public FlowPanel getPnlCentro() {
		return pnlCentro;
	}

	public FlowPanel getPnlEste() {
		return pnlEste;
	}

	public FlowPanel getPnlOeste() {
		return pnlOeste;
	}

	public FlowPanel getPnlContenido() {
		return pnlContenido;
	}	
	
	
	
}
