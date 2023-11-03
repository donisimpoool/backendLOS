package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationBusinessEntity;
import com.ikkat.los.entity.ApplicationCollateralRealEstateEntity;

public interface ApplicationCollateralRealEstateService {
	List<ApplicationCollateralRealEstateEntity> findAll();
	Optional<ApplicationCollateralRealEstateEntity> findById(String id);

	ApplicationCollateralRealEstateEntity update(String id, ApplicationCollateralRealEstateEntity cs);

	ApplicationCollateralRealEstateEntity create(ApplicationCollateralRealEstateEntity cs);
    
    void delete(String id);
}
