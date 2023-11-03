package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.RunningNumberEntity;

public interface RunningNumberService {
	List<RunningNumberEntity> findAll();
	
	Optional<RunningNumberEntity> findById(long id);
	
	RunningNumberEntity update(long id, RunningNumberEntity cs);

	RunningNumberEntity create(RunningNumberEntity cs);
    
    void delete(long id);
    
    RunningNumberEntity getlistRunningNumberEntity(String paramater);
}
