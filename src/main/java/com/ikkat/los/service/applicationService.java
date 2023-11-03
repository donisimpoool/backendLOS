package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.ikkat.los.entity.applicationEntity;


public interface applicationService {
	List<applicationEntity> findAll();
	Optional<applicationEntity> findById(String id);

	applicationEntity update(String id, applicationEntity cs);

	applicationEntity create(applicationEntity cs);
    
    void delete(String id);
    
    List<applicationEntity> findByStatus(String status);
    
    List<applicationEntity> findbystatusperpage(String status,int sizelimit);
    
    List<applicationEntity> findbyIsDraft(String status,String isdraft);
    
    List<applicationEntity> findbyOnlyIsDraft(String isdraft);
}
