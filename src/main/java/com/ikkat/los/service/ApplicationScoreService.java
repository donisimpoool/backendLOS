package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationScoreEntity;


public interface ApplicationScoreService {
	List<ApplicationScoreEntity> findAll();
	Optional<ApplicationScoreEntity> findById(String id);

	ApplicationScoreEntity update(String id, ApplicationScoreEntity cs);

	ApplicationScoreEntity create(ApplicationScoreEntity cs);
    
    void delete(String id);
}
