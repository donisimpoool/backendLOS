package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.RegenciesEntity;
import com.ikkat.los.entity.RiskLevelEntity;

public interface RiskLevelService {
	List<RiskLevelEntity> getRiskByRangeScore(double score);
	List<RiskLevelEntity> findAll();
	Optional<RiskLevelEntity> findById(long id);

	RiskLevelEntity update(long id, RiskLevelEntity cs);

	RiskLevelEntity create(RiskLevelEntity cs);
    
    void delete(long id);
}
