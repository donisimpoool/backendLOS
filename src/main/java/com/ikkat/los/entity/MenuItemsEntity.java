package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menuitems", schema = "public")
public class MenuItemsEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String menuheaderid;
	private String title;
	private String route;
	private String icon;
	private int level;
	private int indexx;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenuheaderid() {
		return menuheaderid;
	}
	public void setMenuheaderid(String menuheaderid) {
		this.menuheaderid = menuheaderid;
	}
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getIndexx() {
		return indexx;
	}
	public void setIndexx(int indexx) {
		this.indexx = indexx;
	}
	
}
