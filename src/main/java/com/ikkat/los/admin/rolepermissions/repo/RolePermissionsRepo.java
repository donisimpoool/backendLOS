package com.ikkat.los.admin.rolepermissions.repo;

import com.ikkat.los.admin.rolepermissions.entity.RolePermissions;
import com.ikkat.los.admin.rolepermissions.entity.RolePermissionsPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("RolePermissionsRepo")
public interface RolePermissionsRepo extends JpaRepository<RolePermissions, RolePermissionsPK>{

}
