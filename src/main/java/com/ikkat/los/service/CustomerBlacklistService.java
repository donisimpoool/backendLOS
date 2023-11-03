package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.CustomerBlacklistEntity;

public interface CustomerBlacklistService {
	List<CustomerBlacklistEntity> findAll();
	Optional<CustomerBlacklistEntity> findById(Long id);

	CustomerBlacklistEntity update(Long id, CustomerBlacklistEntity cs);

	CustomerBlacklistEntity create(CustomerBlacklistEntity cs);
    
    void delete(Long id);
}
