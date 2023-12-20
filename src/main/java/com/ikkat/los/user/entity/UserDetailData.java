package com.ikkat.los.user.entity;

import com.ikkat.los.admin.userappsrole.entity.UserAppsRoleData;

import java.util.List;

public class UserDetailData {
//	private UserApps user;
	private UserDataDetail user;
	private List<UserAppsRoleData> roles;
public UserDataDetail getUser() {
		return user;
	}
	public void setUser(UserDataDetail user) {
		this.user = user;
	}
	//	public UserApps getUser() {
//		return user;
//	}
//	public void setUser(UserApps user) {
//		this.user = user;
//	}
	public List<UserAppsRoleData> getRoles() {
		return roles;
	}
	public void setRoles(List<UserAppsRoleData> roles) {
		this.roles = roles;
	}
	

}
