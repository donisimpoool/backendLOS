package com.ikkat.los.admin.role.repo;

import com.ikkat.los.admin.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("RoleRepo")
public interface RoleRepo extends JpaRepository<Role, Long>{
	
	@Query(value =" select * from m_role "
			+ " where id = :idrole and idcompany = :companyid and idbranch = :branchid and isdelete = false ",nativeQuery = true)
	public List<Role> getRoleById(@Param("idrole") long idrole,@Param("companyid") long companyid,@Param("branchid") long branchid);
	
	@Query(value =" select * from m_role "
			+ " where idcompany = :companyid and idbranch = :branchid and isdelete = false ",nativeQuery = true)
	public List<Role> getAllRole(@Param("companyid") long companyid,@Param("branchid") long branchid);
}
