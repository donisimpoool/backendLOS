package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.FilterEntity;


public interface FilterService {
	List<FilterEntity> findAll();
	Optional<FilterEntity> findById(long id);

	FilterEntity update(long id, FilterEntity cs);

	FilterEntity create(FilterEntity cs);
    
    void delete(long id);
}
