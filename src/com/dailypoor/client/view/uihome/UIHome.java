package com.dailypoor.client.view.uihome;

import com.dailypoor.client.view.uilogin.UILoginImpl;
import com.dailypoor.client.view.uimodel.UIMaskHome;
import com.dailypoor.client.view.uiregister.UIRegisterImpl;
import com.dailypoor.client.view.uisesion.UISesion;
import com.google.gwt.user.client.ui.DeckPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

public class UIHome extends UIMaskHome{	
	private DeckPanel pnlViews;
	private UIRegisterImpl uiRegister;
	private UILoginImpl uiLogin;
	private UISesion uiSesion;	
	
	public UIHome(){
		initComponents();
		style();		
	}
	
	private void initComponents(){		
		pnlViews=new DeckPanel();
		pnlViews.setAnimationEnabled(true);
		uiRegister=new UIRegisterImpl(this);
		uiLogin=new UILoginImpl(this);
		uiSesion=new UISesion(this);
		pnlViews.add(uiRegister);
		pnlViews.add(uiLogin);
		pnlViews.add(uiSesion);
		pnlViews.showWidget(1);				
		//this.getPnlScrlPanel().setWidget(pnlViews);		
		this.getPnlHeader().setCenter("DailyPoor");			
		this.getPnlContenedor().remove(1);
		this.getPnlContenedor().add(pnlViews);
	}
	
	private void style(){
		/*int height=Window.getClientHeight();
		height=height/45-12;
		String pxHeight=String.valueOf(height)+"mm";
		this.getPnlScrlPanel().setSize("100%",pxHeight);*/		
	}

	public DeckPanel getPnlViews() {
		return pnlViews;
	}

	public UIRegisterImpl getUiRegister() {
		return uiRegister;
	}

	public UILoginImpl getUiLogin() {
		return uiLogin;
	}

	public UISesion getUiSesion() {
		return uiSesion;
	}
	
	public ScrollPanel getScroll() {
		return this.getPnlScrlPanel();
	} 
	
}
