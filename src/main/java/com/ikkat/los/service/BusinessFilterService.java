package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.BusinessFilterConditionsEntity;
import com.ikkat.los.entity.BusinessFilterEntity;

public interface BusinessFilterService {
	List<BusinessFilterEntity> findAll();
	Optional<BusinessFilterEntity> findById(Long id);

	BusinessFilterEntity update(Long id, BusinessFilterEntity bf);

	BusinessFilterEntity create(BusinessFilterEntity bf);
	    
    void delete(Long id);
}
