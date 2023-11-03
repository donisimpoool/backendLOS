package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationBusinessEntity;

public interface ApplicationBusinessService {
	List<ApplicationBusinessEntity> findAll();
	Optional<ApplicationBusinessEntity> findById(String id);

	ApplicationBusinessEntity update(String id, ApplicationBusinessEntity cs);

	ApplicationBusinessEntity create(ApplicationBusinessEntity cs);
    
    void delete(String id);
}
