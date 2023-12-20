package com.ikkat.los.admin.rolepermissions.service;

import com.ikkat.los.admin.rolepermissions.entity.RolePermissionData;
import com.ikkat.los.admin.rolepermissions.entity.RolePermissions;
import com.ikkat.los.admin.rolepermissions.entity.RolePermissionsPK;

import java.util.Collection;
import java.util.List;

public interface RolePermissionService {
	Object saveRolePermissions(RolePermissions rolePermissions);
	Object saveRolePermissionsList(List<RolePermissions> listrolePermissions);
	Collection<RolePermissionData> getListRolePermissions(long idrole);
	Object deleteAllrolePermissionsByListPK(List<RolePermissionsPK> listPK);
}
