package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.BusinessFilterConditionsEntity;

public interface BusinessFilterConditionService {
	List<BusinessFilterConditionsEntity> findAll();
	Optional<BusinessFilterConditionsEntity> findById(Long id);

	BusinessFilterConditionsEntity update(Long id, BusinessFilterConditionsEntity bf);

	BusinessFilterConditionsEntity create(BusinessFilterConditionsEntity bf);
	
	List<BusinessFilterConditionsEntity> create(List<BusinessFilterConditionsEntity> bfc);
    
    void delete(Long id);
}
