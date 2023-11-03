package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.ProvinceEntity;
import com.ikkat.los.entity.SubDistrictEntity;

@Repository("SubDistrictRepo")
public interface SubDistrictRepo extends JpaRepository<SubDistrictEntity, Long> {
	
	@Query(value =" select * from m_subdistrict "
			+ " where iddistrict != '' and iddistrict notnull ",nativeQuery = true)
	public List<SubDistrictEntity> GetListSubDistrict();
	
	@Query(value =" select * from m_subdistrict "
			+ " where iddistrict = :iddistrict ",nativeQuery = true)
	public List<SubDistrictEntity> GetListByDistrict(@Param("iddistrict") String iddistrict);
}
