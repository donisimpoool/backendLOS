package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ReligionEntity;

public interface ReligionService {
	List<ReligionEntity> findAll();
	Optional<ReligionEntity> findById(String id);

	ReligionEntity update(String id, ReligionEntity cs);

	ReligionEntity create(ReligionEntity cs);
    
    void delete(String id);
}
