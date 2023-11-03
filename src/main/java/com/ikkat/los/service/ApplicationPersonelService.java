package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.applicationPersonelEntity;


public interface ApplicationPersonelService {
	List<applicationPersonelEntity> findAll();
	Optional<applicationPersonelEntity> findById(String id);

	applicationPersonelEntity update(String id, applicationPersonelEntity cs);

	applicationPersonelEntity create(applicationPersonelEntity cs);
    
    void delete(String id);
}
