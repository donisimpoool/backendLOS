package com.ikkat.los.helper.entity;

import java.util.List;

import com.ikkat.los.entity.FilterDetailEntity;
import com.ikkat.los.entity.FilterHeaderEntity;

public class ViewFilterJson {
	List<FilterHeaderEntity> filterheader;
	List<FilterDetailEntity> listdetail; 

	public List<FilterDetailEntity> getListdetail() {
		return listdetail;
	}

	public void setListdetail(List<FilterDetailEntity> listdetail) {
		this.listdetail = listdetail;
	}

	public List<FilterHeaderEntity> getFilterheader() {
		return filterheader;
	}

	public void setFilterheader(List<FilterHeaderEntity> filterheader) {
		this.filterheader = filterheader;
	}
}
