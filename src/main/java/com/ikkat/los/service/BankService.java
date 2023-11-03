package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.BankEntity;


public interface BankService {
	List<BankEntity> findAll();
	Optional<BankEntity> findById(String id);

	BankEntity update(String id, BankEntity cs);

	BankEntity create(BankEntity cs);
    
    void delete(String id);
}
