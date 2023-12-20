package com.ikkat.los.user.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user", schema = "public")
public class UserApps implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="user_id_seq")
	private long id;	
	private String userid;
	private String password;
	private String name;
	private long ruleid;
	private long level;
	private String isapproval;
	private String usertype;
	private long limitsizefile;
	private long companyid;
	private long branchid;
	private boolean isactive;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getRuleid() {
		return ruleid;
	}

	public void setRuleid(long ruleid) {
		this.ruleid = ruleid;
	}

	public long getLevel() {
		return level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public String getIsapproval() {
		return isapproval;
	}

	public void setIsapproval(String isapproval) {
		this.isapproval = isapproval;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public long getLimitsizefile() {
		return limitsizefile;
	}

	public void setLimitsizefile(long limitsizefile) {
		this.limitsizefile = limitsizefile;
	}

	public long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}

	public long getBranchid() {
		return branchid;
	}

	public void setBranchid(long branchid) {
		this.branchid = branchid;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
}
