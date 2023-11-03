package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ProvinceEntity;

public interface ProvinceService {
	List<ProvinceEntity> findAll();
	Optional<ProvinceEntity> findById(String id);

	ProvinceEntity update(String id, ProvinceEntity cs);

	ProvinceEntity create(ProvinceEntity cs);
    
    void delete(String id);
    
    List<ProvinceEntity> GetListProvinceNotEmptyIdSimpool();
}
