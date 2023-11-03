package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ProvinceSimpoolEntity;

public interface ProvinceSimpoolService {
	List<ProvinceSimpoolEntity> findAll();
	Optional<ProvinceSimpoolEntity> findById(String id);

	ProvinceSimpoolEntity update(String id, ProvinceSimpoolEntity cs);

	ProvinceSimpoolEntity create(ProvinceSimpoolEntity cs);
    
    void delete(String id);
}
