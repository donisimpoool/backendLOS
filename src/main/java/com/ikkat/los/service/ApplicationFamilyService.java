package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationFamilyEntity;

public interface ApplicationFamilyService {
	List<ApplicationFamilyEntity> findAll();
	Optional<ApplicationFamilyEntity> findById(String id);

	ApplicationFamilyEntity update(String id, ApplicationFamilyEntity cs);

	ApplicationFamilyEntity create(ApplicationFamilyEntity cs);
    
    void delete(String id);
}
