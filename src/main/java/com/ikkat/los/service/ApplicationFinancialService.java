package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationFinancialEntity;


public interface ApplicationFinancialService {
	List<ApplicationFinancialEntity> findAll();
	Optional<ApplicationFinancialEntity> findById(String id);

	ApplicationFinancialEntity update(String id, ApplicationFinancialEntity cs);

	ApplicationFinancialEntity create(ApplicationFinancialEntity cs);
    
    void delete(String id);
}
