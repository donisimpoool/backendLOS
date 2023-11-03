package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ParameterEntity;

public interface ParamaterService {
	List<ParameterEntity> findAll();
	Optional<ParameterEntity> findById(String id);
	ParameterEntity update(String id, ParameterEntity cs);

	ParameterEntity create(ParameterEntity cs);
}
