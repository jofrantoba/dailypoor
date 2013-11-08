package com.dailypoor.client.view.uisesion;

import com.dailypoor.client.resource.MyResource;
import com.dailypoor.client.view.uiadmincosto.UIAdminCosto;
import com.dailypoor.client.view.uihome.UIHome;
import com.dailypoor.client.view.uimodel.UICostoTabBar;
import com.dailypoor.client.view.uimodel.UIProyectoTabBar;
import com.dailypoor.client.view.uiproject.UIProject;
import com.dailypoor.server.model.bean.Usuario;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;

public class UISesion extends Composite{
	private FlowPanel pnlContenedor;
	private TabPanel tabPanel;
	private UIProyectoTabBar tabBarProyecto;
	private UICostoTabBar tabBarCosto;
	private UIProject uiProyecto;
	private UIAdminCosto uiAdminCosto;
	public UIHome uiHome;
	private Usuario beanUsuario;
	
	public UISesion(UIHome uiHome){
		this.uiHome=uiHome;
		initComponents();		
		style();
	}
	
	private void initComponents(){
		uiProyecto=new UIProject();
		uiAdminCosto=new UIAdminCosto(this);
		tabBarProyecto=new UIProyectoTabBar();
		tabBarCosto=new UICostoTabBar();				
		pnlContenedor=new FlowPanel();
		tabPanel=new TabPanel();
		tabPanel.add(tabBarProyecto, uiProyecto);
		tabPanel.add(tabBarCosto, uiAdminCosto);
		tabPanel.setDisplayTabBarOnTop(true);
		pnlContenedor.add(tabPanel);				
		initWidget(pnlContenedor);
	}
	
	private void style(){
		MyResource.INSTANCE.getStlUISesion().ensureInjected();		
		tabPanel.addStyleName(MyResource.INSTANCE.getStlUISesion().tabBar());
		tabBarProyecto.addStyleName(MyResource.INSTANCE.getStlUISesion().buttonBar());
		tabBarCosto.addStyleName(MyResource.INSTANCE.getStlUISesion().buttonBar());
	}

	public Usuario getBeanUsuario() {
		return beanUsuario;
	}

	public void setBeanUsuario(Usuario beanUsuario) {
		this.beanUsuario = beanUsuario;
	}			
	
}
