package com.ikkat.los.user.repo;

import com.ikkat.los.user.entity.ParamUser;
import com.ikkat.los.user.entity.UserApps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("UserAppsRepo")
public interface UserAppsRepo extends JpaRepository<UserApps, Long> {
	@Query(value =" select * from user "
			+ " where userid = :#{#params.username} and password = :#{#params.password}  ",nativeQuery = true)
	public List<UserApps> getUserLogin(@Param("params") ParamUser params);
	
	@Query(value =" select * from user "
			+ " where userid = :user ",nativeQuery = true)
	public List<UserApps> getUserLoginByUsername(@Param("user") String user);
	
	@Query(value =" select * from user "
			+ " where id = :iduser and companyid = :companyid and branchid = :branchid  ",nativeQuery = true)
	public List<UserApps> getUserById(@Param("iduser") long user,@Param("companyid") String companyid,@Param("branchid") long branchid);
}
