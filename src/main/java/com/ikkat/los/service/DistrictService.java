package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.DistrictEntity;


public interface DistrictService {
	List<DistrictEntity> findAll();
	Optional<DistrictEntity> findById(String id);

	DistrictEntity update(String id, DistrictEntity cs);

	DistrictEntity create(DistrictEntity cs);
    
    void delete(String id);
}
