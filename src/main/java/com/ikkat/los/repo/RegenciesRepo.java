package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.RegenciesEntity;

@Repository("RegenciesRepo")
public interface RegenciesRepo extends JpaRepository<RegenciesEntity, String>{
	
	@Query(value =" select * from m_regencies "
			+ " where id_simpool != '' ",nativeQuery = true)
	public List<RegenciesEntity> GetListRegenciesNotEmptyIdSimpool();
}
