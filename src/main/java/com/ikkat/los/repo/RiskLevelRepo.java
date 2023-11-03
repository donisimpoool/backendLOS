package com.ikkat.los.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.RiskLevelEntity;

@Repository("RiskLevelRepo")
public interface RiskLevelRepo extends JpaRepository<RiskLevelEntity, Long>{
	
	@Query(value =" select * from m_risk_level "
			+ " where :score >= min and :score <= max ",nativeQuery = true)
	public List<RiskLevelEntity> getRiskByRangeScore(@Param("score") double score);
}
