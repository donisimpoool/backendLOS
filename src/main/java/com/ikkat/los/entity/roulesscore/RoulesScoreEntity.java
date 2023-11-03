package com.ikkat.los.entity.roulesscore;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ikkat.los.utils.Utils;

@Entity
@Table(name = "roulesscore", schema = "public")
public class RoulesScoreEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	private double minvalue;
	private double maxvalue;
	private String value;
	private double valuenumber;
	private double score;
	private String groups;
	private String typeroules;
	private boolean isroulestemplate;
	private String nameroules;
	private String createdby;
	private ZonedDateTime createddate;
	private ZonedDateTime modifieddate;
	
	@Transient
	private String date;
	
	public String getDate() {
		String temp = "";
		if(this.modifieddate != null) {
			String hour = this.modifieddate.getHour()+"";
			String minute = this.modifieddate.getMinute()+"";
			if(this.modifieddate.getHour() < 10) {
				hour = "0"+this.modifieddate.getHour();
			}
			if(this.modifieddate.getMinute() < 10) {
				minute = "0"+this.modifieddate.getMinute();
			}
			temp = this.modifieddate.getDayOfMonth() +"-"+Utils.namabulan3(this.modifieddate.getMonthValue())+"-"+this.modifieddate.getYear()+" "+hour+":"+minute; 
		}
		return temp;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public ZonedDateTime getCreateddate() {
		return createddate;
	}
	public void setCreateddate(ZonedDateTime createddate) {
		this.createddate = createddate;
	}
	public ZonedDateTime getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(ZonedDateTime modifieddate) {
		this.modifieddate = modifieddate;
	}
	public boolean isIsroulestemplate() {
		return isroulestemplate;
	}
	public void setIsroulestemplate(boolean isroulestemplate) {
		this.isroulestemplate = isroulestemplate;
	}
	public String getNameroules() {
		return nameroules;
	}
	public void setNameroules(String nameroules) {
		this.nameroules = nameroules;
	}
	public String getTyperoules() {
		return typeroules;
	}
	public void setTyperoules(String typeroules) {
		this.typeroules = typeroules;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
}
