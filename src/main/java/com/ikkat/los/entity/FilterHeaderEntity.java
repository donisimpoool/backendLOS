package com.ikkat.los.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ikkat.los.enumeration.DateFormatEnum;

@Entity
@Table(name = "m_filter_h", schema = "public")
public class FilterHeaderEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String filterid;
	private String filtername;
	private Timestamp createddate;
	private Timestamp modifieddate;
	private String createby;
	
	@Transient
	private String date;
	
	public String getDate() {
		String temp = "";
		if(this.modifieddate != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatEnum.FORMAT_DATE_MONTH.value());
			temp = dateFormat.format(this.modifieddate.getTime());
		}
		return temp;
	}
	public void setDate(String date) {
		
		this.date = this.filterid;
	}
	public Timestamp getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}
	public Timestamp getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(Timestamp modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public String getFilterid() {
		return filterid;
	}
	public void setFilterid(String filterid) {
		this.filterid = filterid;
	}
	public String getFiltername() {
		return filtername;
	}
	public void setFiltername(String filtername) {
		this.filtername = filtername;
	}
}
