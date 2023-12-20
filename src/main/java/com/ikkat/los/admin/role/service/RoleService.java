package com.ikkat.los.admin.role.service;

import com.ikkat.los.admin.role.entity.BodyRole;
import com.ikkat.los.admin.role.entity.Role;
import com.ikkat.los.admin.role.entity.RoleDetail;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface RoleService {
	List<Role> getAllListRole(long idcompany, long idbranch);
	ReturnData saveRole(BodyRole role, long idcompany, long idbranch);
	ReturnData updateRole(long id,BodyRole role);
	RoleDetail getRoleDetail(long id, long idcompany, long idbranch);
	ReturnData deleteRole(long id);
}
