package com.dailypoor.client.view.uiadmincosto;

import com.dailypoor.client.view.uicosto.UICostoImpl;
import com.dailypoor.client.view.uimantcosto.UIMantCostoImpl;
import com.dailypoor.client.view.uisesion.UISesion;
import com.google.gwt.user.client.ui.DeckPanel;

public class UIAdminCosto extends DeckPanel{
	private UICostoImpl uiCosto;
	private UIMantCostoImpl uiMantCosto;
	private UISesion uiSesion;
	
	public UIAdminCosto(UISesion uiSesion){
		this.uiSesion=uiSesion;
		initComponents();
	}
	
	private void initComponents(){
		this.setAnimationEnabled(true);
		uiCosto=new UICostoImpl(this);
		uiMantCosto=new UIMantCostoImpl(this); 
		this.add(uiCosto);
		this.add(uiMantCosto);
		this.showWidget(0);
	}

	public UICostoImpl getUiCosto() {
		return uiCosto;
	}

	public UIMantCostoImpl getUiMantCosto() {
		return uiMantCosto;
	}

	public UISesion getUiSesion() {
		return uiSesion;
	}

	
	
	

}
