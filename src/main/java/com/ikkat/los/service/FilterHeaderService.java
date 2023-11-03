package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.FilterHeaderEntity;


public interface FilterHeaderService {
	List<FilterHeaderEntity> findAll();
	Optional<FilterHeaderEntity> findById(String id);

	FilterHeaderEntity update(String id, FilterHeaderEntity cs);

	FilterHeaderEntity create(FilterHeaderEntity cs);
    
    void delete(String id);
    
    List<FilterHeaderEntity> getlistByPage(int sizelimit);
}
