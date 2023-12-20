package com.ikkat.los.admin.userappsrole.repo;

import com.ikkat.los.admin.userappsrole.entity.UserAppsRole;
import com.ikkat.los.admin.userappsrole.entity.UserAppsRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserAppsRoleRepo")
public interface UserAppsRoleRepo extends JpaRepository<UserAppsRole, UserAppsRolePK>{

}
