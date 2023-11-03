package com.ikkat.los.helper.entity;

import java.sql.Timestamp;

public class ActiveUserEntity {
	private String userid;
	private String ip;
	private Timestamp timeexpired;
	private Timestamp timelogin;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getTimeexpired() {
		return timeexpired;
	}
	public void setTimeexpired(Timestamp timeexpired) {
		this.timeexpired = timeexpired;
	}
	public Timestamp getTimelogin() {
		return timelogin;
	}
	public void setTimelogin(Timestamp timelogin) {
		this.timelogin = timelogin;
	}
	
}
