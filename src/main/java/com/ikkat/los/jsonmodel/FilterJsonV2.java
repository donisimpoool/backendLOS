package com.ikkat.los.jsonmodel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.FilterDetailEntity;
import com.ikkat.los.entity.FilterDetailEntityPK;
import com.ikkat.los.entity.FilterHeaderEntity;
import com.ikkat.los.entity.RunningNumberEntity;
import com.ikkat.los.service.RunningNumberService;
import com.ikkat.los.utils.Utils;

public class FilterJsonV2 {
	private String id;
	private String name;
	private String createby;
	private List<FilterDetailJson> filterdetail;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public List<FilterDetailJson> getFilterdetail() {
		return filterdetail;
	}
	public void setFilterdetail(List<FilterDetailJson> filterdetail) {
		this.filterdetail = filterdetail;
	}
	
	public HashMap<String, Object> mapentity(RunningNumberService runningnumber){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Date dt = new Date();
		Timestamp ts = new Timestamp(dt.getTime());
		String filterid = "";
		if(this.id.equals("")) {
			long number = Utils.GetRunningNumber(runningnumber, "filter");
			filterid = Utils.RunningNumber2("FR", number);
		}else {
			filterid = this.id;
		}
		FilterHeaderEntity filterheader = new FilterHeaderEntity();
		filterheader.setFilterid(filterid);
		filterheader.setFiltername(this.name);
		filterheader.setCreateddate(ts);
		filterheader.setModifieddate(ts);
		filterheader.setCreateby(this.createby);
		int count = 1;
		List<FilterDetailEntity> listdetail = new ArrayList<FilterDetailEntity>();
		for(FilterDetailJson fd : this.filterdetail) {
			FilterDetailEntityPK pk = new FilterDetailEntityPK();
			pk.setFilterid_h(filterid);
			pk.setFilterid_d(Utils.RunningNumber2("FRD", count));
			FilterDetailEntity fde = new FilterDetailEntity();
			fde.setId(pk);
			fde.setAction(fd.getAction());
			fde.setDescription(fd.getDescription());
			fde.setField(fd.getField());
			fde.setOperand(fd.getOperand());
			fde.setValue(fd.getValue());
			count++;
			listdetail.add(fde);
		}
		map.put("header", filterheader);
		map.put("detail", listdetail);
		return map;
	}
	
	
}
