package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationCollateralDepositEntity;


public interface ApplicationCollateralDepositService {
	List<ApplicationCollateralDepositEntity> findAll();
	Optional<ApplicationCollateralDepositEntity> findById(String id);

	ApplicationCollateralDepositEntity update(String id, ApplicationCollateralDepositEntity cs);

	ApplicationCollateralDepositEntity create(ApplicationCollateralDepositEntity cs);
    
    void delete(String id);
}
