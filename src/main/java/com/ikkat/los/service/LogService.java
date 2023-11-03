package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.LogEntity;

public interface LogService {
	List<LogEntity> findAll();
	
	Optional<LogEntity> findById(long id);
	
	LogEntity update(long id, LogEntity cs);

	LogEntity create(LogEntity cs);
    
    void delete(long id);
}
