package com.dailypoor.client;

import com.dailypoor.client.view.uihome.UIHome;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.MGWTSettings;

public class Dailypoor implements EntryPoint {
	
	@Override
	public void onModuleLoad() {		
		MGWT.applySettings(MGWTSettings.getAppSetting());
		UIHome ui=new UIHome();
		RootPanel.get().add(ui);
	}
	
}
