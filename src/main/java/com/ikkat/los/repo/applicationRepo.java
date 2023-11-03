package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.applicationEntity;

@Repository("applicationRepo")
public interface applicationRepo extends JpaRepository<applicationEntity, String>{
	@Query(value="SELECT * FROM application a WHERE a.status= :status",nativeQuery = true)
	List<applicationEntity> findbystatus(@Param("status") String status);
	
	@Query(value="SELECT * FROM application a WHERE a.status= :status and a.isdraft= :isdraft",nativeQuery = true)
	List<applicationEntity> findbyIsDraft(@Param("status") String status,@Param("isdraft") String isdraft);
	
	@Query(value="SELECT * FROM application a WHERE a.status= :status LIMIT :sizelimit ",nativeQuery = true)
	List<applicationEntity> findbystatusperpage(@Param("status") String status,@Param("sizelimit") int sizelimit);
	
	@Query(value="SELECT * FROM application a WHERE a.isdraft= :isdraft",nativeQuery = true)
	List<applicationEntity> findbyOnlyIsDraft(@Param("isdraft") String isdraft);
}
