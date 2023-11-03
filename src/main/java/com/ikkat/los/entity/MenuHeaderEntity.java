package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menuheader", schema = "public")
public class MenuHeaderEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String menuheaderid;
	private String title;
	private String route;
	private String icon;
	private int level;
	private int indexx;
	private String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
