package com.dailypoor.client.view.uimantcosto;

import com.dailypoor.client.beanproxy.CostoProxy;
import com.dailypoor.client.view.uiadmincosto.UIAdminCosto;
import com.dailypoor.client.view.uimodel.UIBorderLayout;
import com.dailypoor.client.view.uimodel.UIButtonBack;
import com.dailypoor.shared.ModeOperation;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable.CellFormatter;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.googlecode.mgwt.dom.client.event.touch.TouchEndEvent;
import com.googlecode.mgwt.dom.client.event.touch.TouchEndHandler;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MTextBox;

public class UIMantCosto extends UIBorderLayout implements TouchEndHandler,InterUIMantCosto{
	private Label lblTitulo;	
	private FlexTable headerFlex;
	private FlexTable footFlex;
	private Grid pnlForm; 
	//private WidgetList pnlForm;
	protected MTextBox txtId;
	protected MTextBox txtNombre;
	private Button btnProcess;
	private UIButtonBack btnAtras;
	protected ModeOperation mode;
	protected UIAdminCosto uiAdminCosto;	
	private Label lblId;
	private Label lblNombre;
	protected CostoProxy beanCostoProxy;
	
	public UIMantCosto(UIAdminCosto uiAdminCosto){
		this.uiAdminCosto=uiAdminCosto;
		initComponents();
		style();
		widgetListener();
	}
	
	public UIMantCosto() {
		// TODO Auto-generated constructor stub
		initComponents();
		style();
		widgetListener();		
	}

	private void initComponents(){	
		lblId=new Label("Id Costo");
		lblNombre=new Label("Nombre");
		lblTitulo=new Label("MODO");
		headerFlex=new FlexTable();
		footFlex=new FlexTable();		
		FlexCellFormatter headCellFormatter = headerFlex.getFlexCellFormatter();
		FlexCellFormatter footCellFormatter = footFlex.getFlexCellFormatter();
		headerFlex.setWidth("100%");
		headerFlex.setHeight("12mm");
		footFlex.setWidth("100%");	
		footFlex.setHeight("12mm");
		btnAtras=new UIButtonBack();		
		pnlForm=new Grid(2,2);
		CellFormatter formatterGrid=pnlForm.getCellFormatter();
		formatterGrid.getElement(0, 0).getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		formatterGrid.getElement(0, 0).getStyle().setBorderWidth(1, Unit.PX);		
		formatterGrid.getElement(1, 0).getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		formatterGrid.getElement(1, 0).getStyle().setBorderWidth(1, Unit.PX);
		formatterGrid.getElement(0, 1).getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		formatterGrid.getElement(0, 1).getStyle().setBorderWidth(1, Unit.PX);
		formatterGrid.getElement(1, 1).getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		formatterGrid.getElement(1, 1).getStyle().setBorderWidth(1, Unit.PX);
		txtId=new MTextBox();
		txtNombre=new MTextBox();
		btnProcess=new Button("Aceptar");
		footFlex.setWidget(0, 0, btnProcess);
		pnlForm.setWidget(0, 0, lblId);
		pnlForm.setWidget(0, 1, txtId);
		pnlForm.setWidget(1, 0, lblNombre);
		pnlForm.setWidget(1, 1, txtNombre);
		headerFlex.setWidget(0, 1, lblTitulo);
		headerFlex.setWidget(0, 0, btnAtras);
		footCellFormatter.setHorizontalAlignment(
		        0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		headCellFormatter.setHorizontalAlignment(
		        0, 0, HasHorizontalAlignment.ALIGN_LEFT);
		headCellFormatter.setHorizontalAlignment(
		        0, 1, HasHorizontalAlignment.ALIGN_CENTER);
		headCellFormatter.setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_TOP);
		headCellFormatter.setWidth(0, 0, "32px");
		super.getPnlNorte().add(headerFlex);		
		super.getPnlCentro().add(pnlForm);		
		super.getPnlSur().add(footFlex);
		
	}
	
	private void style(){
		btnAtras.setWidth("9mm");
		btnProcess.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		btnProcess.getElement().getStyle().setWidth(90, Unit.PCT);
		btnAtras.getElement().getStyle().setCursor(Style.Cursor.POINTER);
		txtId.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		txtId.getElement().getStyle().setBorderWidth(1, Unit.PX);
		txtId.getElement().getStyle().setWidth(97, Unit.PCT);	
		txtId.getElement().getStyle().setMargin(5, Unit.PX);
		lblId.getElement().getStyle().setMargin(5, Unit.PX);
		//lblId.getElement().getStyle().setColor("#000");
		txtNombre.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		txtNombre.getElement().getStyle().setBorderWidth(1, Unit.PX);
		txtNombre.getElement().getStyle().setWidth(97, Unit.PCT);
		txtNombre.getElement().getStyle().setMargin(5, Unit.PX);
		lblNombre.getElement().getStyle().setMargin(5, Unit.PX);
		//lblNombre.getElement().getStyle().setColor("#000");
		lblTitulo.getElement().getStyle().setFontWeight(Style.FontWeight.BOLD);
		//lblTitulo.getElement().getStyle().setColor("#000");
		lblTitulo.getElement().getStyle().setFontSize(5, Unit.MM);		
		pnlForm.getElement().getStyle().setWidth(100, Unit.PCT);
		super.getPnlNorte().getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		super.getPnlNorte().getElement().getStyle().setBorderWidth(1, Unit.PX);
		//super.getPnlSur().getElement().getStyle().setDisplay(Style.Display.BLOCK);
		//super.getPnlSur().getElement().getStyle().setTextAlign(Style.TextAlign.CENTER);
		/*pnlForm.getElement().getStyle().setBorderStyle(Style.BorderStyle.SOLID);
		pnlForm.getElement().getStyle().setBorderWidth(1, Unit.PX);*/
	}
	
	private void widgetListener(){
		btnProcess.addTouchEndHandler(this);
		btnAtras.addTouchEndHandler(this);
	}
	

	@Override
	public void onTouchEnd(TouchEndEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource().equals(btnProcess)){
			if(mode==ModeOperation.MODE_INSERT){
				registrar();
			}else if(mode==ModeOperation.MODE_UPDATE){
				actualizar();
			}else if(mode==ModeOperation.MODE_DELETE){
				eliminar();
			}else if(mode==ModeOperation.MODE_DETAIL){
				
			}
		}else if(event.getSource().equals(btnAtras)){
			irACostos();	
		}
	}

	@Override
	public void registrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void irACostos() {
		// TODO Auto-generated method stub
		uiAdminCosto.getUiCosto().cargarTabla();		
		uiAdminCosto.showWidget(0);
	}	

	public MTextBox getTxtId() {
		return txtId;
	}

	public void setTxtId(MTextBox txtId) {
		this.txtId = txtId;
	}

	public MTextBox getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(MTextBox txtNombre) {
		this.txtNombre = txtNombre;
	}

	@Override
	public void cleanForm() {
		// TODO Auto-generated method stub
		txtNombre.setText(null);
	}

	@Override
	public void loadRegistrar() {
		// TODO Auto-generated method stub
		this.mode=ModeOperation.MODE_INSERT;
		lblTitulo.setText(this.mode.toString());
		txtId.setReadOnly(true);
		txtId.setText("Id Generado");
		txtNombre.setText(null);
		txtNombre.setFocus(true);
		txtNombre.setReadOnly(false);
		txtNombre.selectAll();
	}

	@Override
	public void loadActualizar() {
		// TODO Auto-generated method stub
		this.mode=ModeOperation.MODE_UPDATE;
		lblTitulo.setText(this.mode.toString());
		txtId.setReadOnly(true);
		txtId.setText(beanCostoProxy.getIdCosto().toString());
		txtNombre.setText(beanCostoProxy.getNombre());
		txtNombre.setReadOnly(false);
		txtNombre.setFocus(true);
		txtNombre.selectAll();
	}

	@Override
	public void loadEliminar() {
		// TODO Auto-generated method stub
		this.mode=ModeOperation.MODE_DELETE;
		lblTitulo.setText(this.mode.toString());
		txtId.setReadOnly(true);
		txtId.setText(beanCostoProxy.getIdCosto().toString());
		txtNombre.setReadOnly(true);
		txtNombre.setText(beanCostoProxy.getNombre());				
	}
	
	public void setBeanCostoProxy(CostoProxy beanCostoProxy) {
		this.beanCostoProxy = beanCostoProxy;		
	}
	

}
