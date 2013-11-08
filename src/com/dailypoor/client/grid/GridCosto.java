package com.dailypoor.client.grid;

import java.util.ArrayList;
import java.util.List;

import com.dailypoor.client.beanproxy.CostoProxy;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;

public class GridCosto extends CellTable<CostoProxy>{	
	private List<CostoProxy> data=new ArrayList<CostoProxy>();				
	private final SingleSelectionModel<CostoProxy> selectionModel= new SingleSelectionModel<CostoProxy>();
	private ListDataProvider<CostoProxy> dataProvider= new ListDataProvider<CostoProxy>();
	
	public GridCosto(){		
		initComponents();
	}

	
	private void initComponents(){			
		this.setWidth("100%");									
		initColumns();			
		this.setRowCount(data.size(), true);		
		this.setRowData(0,data);
		this.setPageSize(data.size());
		dataProvider.setList(data);
		dataProvider.addDataDisplay(this);
		this.setVisible(true);			 
        this.setSelectionModel(selectionModel);                 
	};
	
	private void initColumns(){
		this.addColumn(nombreCosto,"Mis Costos");							
	}
		
	private	Column<CostoProxy, String> nombreCosto =
	            new Column<CostoProxy, String>(new TextCell()) {
	              @Override
	              public String getValue(CostoProxy object) {
	                return object.getNombre();
	              }
	            };
	            
	
	public List<CostoProxy> getData() {
		return data;
	}


	public void setData(List<CostoProxy> data) {		
		this.data = data;
		this.setRowCount(data.size(), true);
		this.setRowData(0,data);
		this.setPageSize(data.size());
		dataProvider.setList(data);
        dataProvider.refresh();
        int alto=data.size()*15;
        this.setHeight(alto+"mm");                
	}


	public SingleSelectionModel<CostoProxy> getSelectionModel() {
		return selectionModel;
	}
	
	
	
}
