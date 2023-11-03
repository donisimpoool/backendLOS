package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.LineBusinessEntity;

public interface LineBusinessService {
	List<LineBusinessEntity> findAll();
	Optional<LineBusinessEntity> findById(String id);

	LineBusinessEntity update(String id, LineBusinessEntity cs);

	LineBusinessEntity create(LineBusinessEntity cs);
    
    void delete(String id);
}
