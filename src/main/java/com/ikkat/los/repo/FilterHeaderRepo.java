package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.FilterHeaderEntity;


@Repository("FilterHeaderRepo")
public interface FilterHeaderRepo extends JpaRepository<FilterHeaderEntity, String>{
	@Query(value =" select * from m_filter_h "
			+ " order by modifieddate desc LIMIT :sizelimit ",nativeQuery = true)
	public List<FilterHeaderEntity> getlistByPage(@Param("sizelimit") int sizelimit);
}
