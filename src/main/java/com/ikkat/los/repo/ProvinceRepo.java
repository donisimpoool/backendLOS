package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ProvinceEntity;


@Repository("ProvinceRepo")
public interface ProvinceRepo extends JpaRepository<ProvinceEntity, String>{
	
	@Query(value =" select * from m_province "
			+ " where id_simpool != '' ",nativeQuery = true)
	public List<ProvinceEntity> GetListProvinceNotEmptyIdSimpool();
}
