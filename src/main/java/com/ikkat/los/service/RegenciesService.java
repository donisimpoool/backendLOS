package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.RegenciesEntity;

public interface RegenciesService {
	List<RegenciesEntity> findAll();
	Optional<RegenciesEntity> findById(String id);

	RegenciesEntity update(String id, RegenciesEntity cs);

	RegenciesEntity create(RegenciesEntity cs);
    
    void delete(String id);
    
    List<RegenciesEntity> GetListRegenciesNotEmptyIdSimpool();
}
