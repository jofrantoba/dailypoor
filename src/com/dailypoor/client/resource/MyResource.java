package com.dailypoor.client.resource;

import com.dailypoor.client.resource.cssresource.UICostoCss;
import com.dailypoor.client.resource.cssresource.UIProjectCss;
import com.dailypoor.client.resource.cssresource.UISesionCss;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MyResource extends ClientBundle{	
	public static final MyResource INSTANCE=GWT.create(MyResource.class);
	
	@Source("image/todo32.png")
	ImageResource getImgTodo32();
	
	@Source("image/back32.png")
	ImageResource getImgBack32();
	
	@Source("image/filtro32.png")
	ImageResource getImgFiltro32();
	
	@Source("image/proyecto32.png")
	ImageResource getImgProyecto32();
	
	@Source("image/costo32.png")
	ImageResource getImgCosto32();
	
	@Source("image/detallecosto32.png")
	ImageResource getImgDetalleCosto32();
	
	@Source("image/editar32.png")
	ImageResource getImgEditar32();
	
	@Source("image/eliminar32.png")
	ImageResource getImgEliminar32();
	
	@Source("image/enviar32.png")
	ImageResource getImgEnviar32();
	
	@Source("image/nuevo32.png")
	ImageResource getImgNuevo32();
	
	@Source("image/reporte32.png")
	ImageResource getImgReporte32();

	@Source("style/UISesion.css")
	UISesionCss getStlUISesion();
	
	@Source("style/UIProject.css")
	UIProjectCss getStlUIProject();
	
	@Source("style/UICosto.css")
	UICostoCss getStlUICosto();
}
