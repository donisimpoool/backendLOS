package com.ikkat.los.helper.entity;

import java.util.ArrayList;
import java.util.List;

import com.ikkat.los.entity.MenuHeaderEntity;
import com.ikkat.los.entity.MenuItemsEntity;
import com.ikkat.los.service.MenuItemsService;

public class ListMenu {
	private String title;
	private String route;
	private String icon;
	private String firstrouteopen;
	private List<ListMenuItems> menuitem;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public List<ListMenuItems> getMenuitem() {
		return menuitem;
	}
	public void setMenuitem(List<ListMenuItems> menuitem) {
		this.menuitem = menuitem;
	}
	
	public String getFirstrouteopen() {
		return firstrouteopen;
	}
	public void setFirstrouteopen(String firstrouteopen) {
		this.firstrouteopen = firstrouteopen;
	}
	public ListMenu setlist(MenuHeaderEntity mh,MenuItemsService menuitemsservice,int level) {
		 List<MenuItemsEntity> listmi = menuitemsservice.getListMenuItems(level, mh.getMenuheaderid());
		ListMenu listmenu = new ListMenu();
		List<ListMenuItems> listtempmi = new ArrayList<ListMenuItems>();
		String firstroute = "";
		for(MenuItemsEntity mi : listmi) {
			ListMenuItems tempmi = new ListMenuItems();
			tempmi.setTitle(mi.getTitle());
			tempmi.setRoute(mi.getRoute());
			tempmi.setIcon(mi.getIcon());
			listtempmi.add(tempmi);
			if(firstroute.equals("")) {
				firstroute = mi.getRoute();
			}
		}
		listmenu.setTitle(mh.getTitle());
		listmenu.setRoute(mh.getRoute());
		listmenu.setIcon(mh.getIcon());
		listmenu.setMenuitem(listtempmi);
		listmenu.setFirstrouteopen(firstroute);
		return listmenu;
	}
}
