package com.ikkat.los.repo;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.FilterDetailEntity;
import com.ikkat.los.entity.FilterDetailEntityPK;


@Repository("FilterDetailRepo")
public interface FilterDetailRepo extends JpaRepository<FilterDetailEntity, FilterDetailEntityPK>{
	@Query(value =" select * from m_filter_d "
			+ " where filterid_h = :filterhid ",nativeQuery = true)
	public List<FilterDetailEntity> listdetailByHeaderid(@Param("filterhid") String filterhid);
	
	@Query(value =" select * from m_filter_d "
			+ " where filterid_h in :listid ",nativeQuery = true)
	public List<FilterDetailEntity> listdetailByListHeaderid(@Param("listid") List<String> listid);
	
	@Query(value =" DELETE FROM m_filter_d "
			+ " where filterid_h in :listid ",nativeQuery = true)
	int deleteByListHeaderID(@Param("listid") List<String> listid);
	
	@Modifying
	@Transactional
	@Query(value =" delete from m_filter_d "
			+ " where filterid_h = :filterhid ",nativeQuery = true)
	void deleteByHeaderID(@Param("filterhid") String filterhid);
}
