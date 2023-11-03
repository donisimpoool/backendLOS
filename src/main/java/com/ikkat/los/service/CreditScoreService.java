package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.CreditScoreEntity;

public interface CreditScoreService {
	List<CreditScoreEntity> findAll();
	Optional<CreditScoreEntity> findById(Long id);

	CreditScoreEntity update(Long id, CreditScoreEntity cs);

	CreditScoreEntity create(CreditScoreEntity cs);
    
    void delete(Long id);
}
