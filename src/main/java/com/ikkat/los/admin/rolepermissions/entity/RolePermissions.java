package com.ikkat.los.admin.rolepermissions.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "m_role_permissions", schema = "public")
public class RolePermissions {
	
	@EmbeddedId
    private RolePermissionsPK rolePermissionsPK;

	public RolePermissionsPK getRolePermissionsPK() {
		return rolePermissionsPK;
	}

	public void setRolePermissionsPK(RolePermissionsPK rolePermissionsPK) {
		this.rolePermissionsPK = rolePermissionsPK;
	}
	

}
