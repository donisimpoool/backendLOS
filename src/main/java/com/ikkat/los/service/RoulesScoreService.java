package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.helper.entity.ParamsRoulesScoreEntity;

public interface RoulesScoreService {
	List<RoulesScoreEntity> findAll();
	
	Optional<RoulesScoreEntity> findById(long id);
	
	double CalculateScore(ParamsRoulesScoreEntity params,String education,String industrysector,
//			String jobtittle,
			double debtincomeratio);
	RoulesScoreEntity update(long id, RoulesScoreEntity cs);

	RoulesScoreEntity create(RoulesScoreEntity cs);
    
    void delete(long id);
    
    List<RoulesScoreEntity> getlistroulesByTemplate(boolean isroulestemplate);
    
    List<RoulesScoreEntity> getlistroulesByTemplateByPage(boolean isroulestemplate,int sizelimit);
    
    List<Object> getlistroulesMaxScore(boolean isroulestemplate);
    
    RoulesScoreEntity getroulesByGroup(boolean isroulestemplate,String groups,String value);
}
