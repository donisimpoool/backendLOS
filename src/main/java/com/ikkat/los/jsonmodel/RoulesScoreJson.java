package com.ikkat.los.jsonmodel;

import java.util.Date;

import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.utils.Utils;

public class RoulesScoreJson {
	private long id;
	private String typeroules;
	private double minvalue;
	private double maxvalue;
	private String value;
	private double valuenumber;
	private double score;
	private String groups;
	private String nameroules;
	private String userid;
	
	public RoulesScoreEntity setEntity() {
		long now = new Date().getTime();
		String scoreid = String.valueOf(Utils.generateNumber());
		RoulesScoreEntity entity = new RoulesScoreEntity();
		entity.setId(new Long(scoreid).longValue());
		entity.setMinvalue(this.minvalue);
		entity.setMaxvalue(this.maxvalue);
		entity.setValue(this.value);
		entity.setValuenumber(this.valuenumber);
		entity.setScore(this.score);
		entity.setGroups(this.groups);
		entity.setTyperoules(this.typeroules);
		entity.setNameroules(this.nameroules);
		entity.setIsroulestemplate(false);
		entity.setCreatedby(this.userid);
		entity.setCreateddate(Utils.longToZonedDateTime(now));
		entity.setModifieddate(Utils.longToZonedDateTime(now));
		return entity;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getTyperoules() {
		return typeroules;
	}
	public void setTyperoules(String typeroules) {
		this.typeroules = typeroules;
	}
	public double getMinvalue() {
		return minvalue;
	}
	public void setMinvalue(double minvalue) {
		this.minvalue = minvalue;
	}
	public double getMaxvalue() {
		return maxvalue;
	}
	public void setMaxvalue(double maxvalue) {
		this.maxvalue = maxvalue;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public double getValuenumber() {
		return valuenumber;
	}
	public void setValuenumber(double valuenumber) {
		this.valuenumber = valuenumber;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public String getNameroules() {
		return nameroules;
	}
	public void setNameroules(String nameroules) {
		this.nameroules = nameroules;
	}
	
}
