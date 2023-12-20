package com.ikkat.los.user.entity;

import com.ikkat.los.admin.role.entity.Role;

import java.util.List;

public class TemplateInternalUser {
	private List<Role> roleoptions;

	public List<Role> getRoleoptions() {
		return roleoptions;
	}

	public void setRoleoptions(List<Role> roleoptions) {
		this.roleoptions = roleoptions;
	}
}
