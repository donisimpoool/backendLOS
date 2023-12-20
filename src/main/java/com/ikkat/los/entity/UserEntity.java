//package com.ikkat.los.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Transient;
//
//@Entity
//@Table(name = "user", schema = "public")
//public class UserEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
//	private String userid;
//	private String password;
//	private String name;
//	private String ruleid;
//	private int level;
//	private String isapproval;
//	private String usertype;
//	private int limitsizefile; //nilai dalam MB
//	private String companyid;
//	public String getCompanyid() {
//		return companyid;
//	}
//	public void setCompanyid(String companyid) {
//		this.companyid = companyid;
//	}
//	public int getLimitsizefile() {
//		return limitsizefile;
//	}
//	public void setLimitsizefile(int limitsizefile) {
//		this.limitsizefile = limitsizefile;
//	}
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getUserid() {
//		return userid;
//	}
//	public void setUserid(String userid) {
//		this.userid = userid;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getRuleid() {
//		return ruleid;
//	}
//	public void setRuleid(String ruleid) {
//		this.ruleid = ruleid;
//	}
//	public int getLevel() {
//		return level;
//	}
//	public void setLevel(int level) {
//		this.level = level;
//	}
//	public String getIsapproval() {
//		return isapproval;
//	}
//	public void setIsapproval(String isapproval) {
//		this.isapproval = isapproval;
//	}
//	public String getUsertype() {
//		return usertype;
//	}
//	public void setUsertype(String usertype) {
//		this.usertype = usertype;
//	}
//
//
//}
