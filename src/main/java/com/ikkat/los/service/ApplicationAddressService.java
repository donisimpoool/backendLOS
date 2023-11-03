package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationAddressEntity;


public interface ApplicationAddressService {
	List<ApplicationAddressEntity> findAll();
	Optional<ApplicationAddressEntity> findById(String id);

	ApplicationAddressEntity update(String id, ApplicationAddressEntity cs);

	ApplicationAddressEntity create(ApplicationAddressEntity cs);
    
    void delete(String id);
}
