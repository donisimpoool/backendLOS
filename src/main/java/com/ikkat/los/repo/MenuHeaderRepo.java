package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.MenuHeaderEntity;

@Repository("MenuHeaderRepo")
public interface MenuHeaderRepo extends JpaRepository<MenuHeaderEntity, String>{
	
	@Query(value =" select * from menuheader "
			+ " where level <= :level and type = :type order by indexx ",nativeQuery = true)
	public List<MenuHeaderEntity> getListMenuHeader(@Param("level") int level,@Param("type") String type);
}
