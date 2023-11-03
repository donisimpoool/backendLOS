package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.RunningNumberEntity;

@Repository("RunningNumberRepo")
public interface RunningNumberRepo extends JpaRepository<RunningNumberEntity, Long>{
	
	@Query(value =" select * from runningnumber "
			+ " where paramater = :paramater limit 1 ",nativeQuery = true)
	public RunningNumberEntity getlistRunningNumberEntity(@Param("paramater") String paramater);
}
