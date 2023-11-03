package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationBankEntity;


public interface ApplicationBankService {
	List<ApplicationBankEntity> findAll();
	Optional<ApplicationBankEntity> findById(String id);

	ApplicationBankEntity update(String id, ApplicationBankEntity cs);

	ApplicationBankEntity create(ApplicationBankEntity cs);
    
    void delete(String id);
}
