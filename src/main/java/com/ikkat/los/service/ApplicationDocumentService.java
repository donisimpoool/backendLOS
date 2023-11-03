package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationDocumentEntity;


public interface ApplicationDocumentService {
	List<ApplicationDocumentEntity> findAll();
	Optional<ApplicationDocumentEntity> findById(String id);

	ApplicationDocumentEntity update(String id, ApplicationDocumentEntity cs);

	ApplicationDocumentEntity create(ApplicationDocumentEntity cs);
    
    void delete(String id);
    
}
