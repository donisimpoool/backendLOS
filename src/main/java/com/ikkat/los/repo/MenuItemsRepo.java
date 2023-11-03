package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.MenuItemsEntity;

@Repository("MenuItemsRepo")
public interface MenuItemsRepo extends JpaRepository<MenuItemsEntity, String>{
	
	@Query(value =" select * from menuitems "
			+ " where level <= :level and menuheaderid = :menuheaderid order by indexx ",nativeQuery = true)
	public List<MenuItemsEntity> getListMenuItems(@Param("level") int level,@Param("menuheaderid") String menuheaderid);
}
