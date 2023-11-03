package com.ikkat.los.jsonmodel;

import com.ikkat.los.entity.UserEntity;
import com.ikkat.los.enumeration.EnumUserType;
import com.ikkat.los.utils.Encryptor;

public class UserJson {
	private long id;
	private String userid;
	private String password;
	private String name;
	private String ruleid;
	private String level;
	private String isapproval;
	private String created;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getIsapproval() {
		return isapproval;
	}
	public void setIsapproval(String isapproval) {
		this.isapproval = isapproval;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRuleid() {
		return ruleid;
	}
	public void setRuleid(String ruleid) {
		this.ruleid = ruleid;
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
	
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public UserEntity setvalue() {
		UserEntity entity = new UserEntity();
		entity.setUserid(this.userid);
		entity.setPassword(Encryptor.encrypt(this.password));
		entity.setName(this.name);
		entity.setRuleid(this.ruleid);
		entity.setLevel(new Integer(this.level));
		entity.setIsapproval(this.isapproval);
		entity.setUsertype(EnumUserType.USER.value());
		return entity;
	}
}
