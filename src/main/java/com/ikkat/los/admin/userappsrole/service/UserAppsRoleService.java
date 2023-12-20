package com.ikkat.los.admin.userappsrole.service;

import com.ikkat.los.admin.userappsrole.entity.UserAppsRole;
import com.ikkat.los.admin.userappsrole.entity.UserAppsRoleData;
import com.ikkat.los.admin.userappsrole.entity.UserAppsRolePK;

import java.util.Collection;
import java.util.List;

public interface UserAppsRoleService {
	Object saveUserAppsRole(UserAppsRolePK userAppsRolePK);
	Object saveUserAppsRoleList(List<UserAppsRole> listUserAppsRole);
	Collection<UserAppsRoleData> getListUserAppsRole(long iduserapps);
	Object deleteAllUserAppsRolePKPK(List<UserAppsRolePK> listPK);
}
