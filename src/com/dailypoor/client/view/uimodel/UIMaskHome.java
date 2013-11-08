package com.dailypoor.client.view.uimodel;

import com.google.gwt.user.client.ui.Composite;
import com.googlecode.mgwt.ui.client.widget.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.LayoutPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

public class UIMaskHome extends Composite{
	private LayoutPanel pnlContenedor;
	private HeaderPanel pnlHeader;
	private ScrollPanel pnlScrlPanel;
	
	public UIMaskHome(){
		initComponents();
	}
	
	private void initComponents(){
		pnlContenedor=new LayoutPanel();
		pnlHeader=new HeaderPanel();
		pnlScrlPanel=new ScrollPanel();
		pnlScrlPanel.setScrollingEnabledX(false);
		pnlContenedor.add(pnlHeader);
		pnlContenedor.add(pnlScrlPanel);
		initWidget(pnlContenedor);
	}

	public LayoutPanel getPnlContenedor() {
		return pnlContenedor;
	}

	public void setPnlContenedor(LayoutPanel pnlContenedor) {
		this.pnlContenedor = pnlContenedor;
	}

	public HeaderPanel getPnlHeader() {
		return pnlHeader;
	}

	public void setPnlHeader(HeaderPanel pnlHeader) {
		this.pnlHeader = pnlHeader;
	}

	public ScrollPanel getPnlScrlPanel() {
		return pnlScrlPanel;
	}

	public void setPnlScrlPanel(ScrollPanel pnlScrlPanel) {
		this.pnlScrlPanel = pnlScrlPanel;
	}
	
	
}
