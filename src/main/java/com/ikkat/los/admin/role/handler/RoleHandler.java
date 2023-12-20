package com.ikkat.los.admin.role.handler;


import com.ikkat.los.admin.role.entity.BodyRole;
import com.ikkat.los.admin.role.entity.Role;
import com.ikkat.los.admin.role.entity.RoleDetail;
import com.ikkat.los.admin.role.entity.RolePermissionData;
import com.ikkat.los.admin.role.repo.RoleRepo;
import com.ikkat.los.admin.role.service.RoleService;
import com.ikkat.los.admin.rolepermissions.entity.RolePermissions;
import com.ikkat.los.admin.rolepermissions.entity.RolePermissionsPK;
import com.ikkat.los.admin.rolepermissions.service.RolePermissionService;
import com.ikkat.los.shared.ReturnData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoleHandler implements RoleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleHandler.class);
	@Autowired
	private RoleRepo repository;
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Override
	public List<Role> getAllListRole(long idcompany, long idbranch) {
		// TODO Auto-generated method stub
		return repository.getAllRole(idcompany, idbranch);
	}

	@Override
	public ReturnData saveRole(BodyRole role, long idcompany, long idbranch) {
		// TODO Auto-generated method stub
		Timestamp ts = new Timestamp(new Date().getTime());
		Role table = new Role();
		table.setNama(role.getNama());
		table.setDescriptions(role.getDescriptions());
		table.setIdcompany(idcompany);
		table.setIdbranch(idbranch);
		table.setIsdelete(false);
		table.setCreated(ts);
		table.setModified(ts);
		
		Role returntable = repository.saveAndFlush(table);
		
		List<RolePermissions> listrolepermissions = new ArrayList<RolePermissions>();
		if(role.getPermissions().length > 0) {
			for (int i = 0; i < role.getPermissions().length; i++) {
				RolePermissionsPK rolePermissionPK = new RolePermissionsPK();
				rolePermissionPK.setIdrole(returntable.getId());
				rolePermissionPK.setIdpermissions(role.getPermissions()[i]);
				rolePermissionPK.setIdbranch(returntable.getIdbranch());
				rolePermissionPK.setIdcompany(returntable.getIdcompany());
				
				RolePermissions rolePermission = new RolePermissions();
				rolePermission.setRolePermissionsPK(rolePermissionPK);
				
				listrolepermissions.add(rolePermission);
			}
			 rolePermissionService.saveRolePermissionsList(listrolepermissions);
		}
		
		
		ReturnData data = new ReturnData();
		data.setId(returntable.getId());
		return data;
	}

	@Override
	public ReturnData updateRole(long id, BodyRole role) {
		// TODO Auto-generated method stub
		Timestamp ts = new Timestamp(new Date().getTime());
		Role table = repository.getOne(id);
		table.setNama(role.getNama());
		table.setDescriptions(role.getDescriptions());
//		table.setIdcompany(1);
//		table.setIdbranch(1);
//		table.setIsdelete(false);
//		table.setCreated(ts);
		table.setModified(ts);
		
		Role returntable = repository.saveAndFlush(table);
		
		List<RolePermissionsPK> listdelete = new ArrayList<RolePermissionsPK>();
		List<RolePermissionData> listrolepermission = new ArrayList<RolePermissionData>(rolePermissionService.getListRolePermissions(id).size());
		if(listrolepermission.size() > 0) {
			for(RolePermissionData rolePermissionData : listrolepermission) {
				RolePermissionsPK rolepermissionPK = new RolePermissionsPK();
				rolepermissionPK.setIdcompany(returntable.getIdcompany());
				rolepermissionPK.setIdbranch(returntable.getIdbranch());
				rolepermissionPK.setIdpermissions(rolePermissionData.getId());
				rolepermissionPK.setIdrole(returntable.getId());
				listdelete.add(rolepermissionPK);
			}
			rolePermissionService.deleteAllrolePermissionsByListPK(listdelete);
		}
		
		List<RolePermissions> listrolepermissions = new ArrayList<RolePermissions>();
		if(role.getPermissions().length > 0) {
			for (int i = 0; i < role.getPermissions().length; i++) {
				RolePermissionsPK rolePermissionPK = new RolePermissionsPK();
				rolePermissionPK.setIdrole(returntable.getId());
				rolePermissionPK.setIdpermissions(role.getPermissions()[i]);
				rolePermissionPK.setIdbranch(returntable.getIdbranch());
				rolePermissionPK.setIdcompany(returntable.getIdcompany());
				
				RolePermissions rolePermission = new RolePermissions();
				rolePermission.setRolePermissionsPK(rolePermissionPK);
				
				listrolepermissions.add(rolePermission);
			}
			 rolePermissionService.saveRolePermissionsList(listrolepermissions);
		}
		
		ReturnData data = new ReturnData();
		data.setId(returntable.getId());
		
		return data;
	}

	@Override
	public RoleDetail getRoleDetail(long id, long idcompany, long idbranch) {
		// TODO Auto-generated method stub
		RoleDetail data = new RoleDetail();
		List<Role> value = repository.getRoleById(id, idcompany, idbranch);
		if(value != null && value.size() > 0) {
			List<RolePermissionData> listrolepermission = new ArrayList<RolePermissionData>(rolePermissionService.getListRolePermissions(id).size());
			data.setRole(value.get(0));
			data.setPermissions(listrolepermission);
		}else {
			data.setRole(null);
			data.setPermissions(null);
		}
		return data;
	}

	@Override
	public ReturnData deleteRole(long id) {
		// TODO Auto-generated method stub
		Timestamp ts = new Timestamp(new Date().getTime());
		Role table = repository.getOne(id);
		table.setIsdelete(true);
		table.setModified(ts);
		Role returntable = repository.saveAndFlush(table);
		
		ReturnData data = new ReturnData();
		data.setId(returntable.getId());
		return data;
	}

	

}
