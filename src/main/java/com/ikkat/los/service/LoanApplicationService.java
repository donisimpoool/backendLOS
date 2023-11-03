package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.LoanapplicationEntity;


public interface LoanApplicationService {
	List<LoanapplicationEntity> findAll();
	Optional<LoanapplicationEntity> findById(String id);

	LoanapplicationEntity update(String id, LoanapplicationEntity cs);

	LoanapplicationEntity create(LoanapplicationEntity cs);
    
    void delete(String id);
}
