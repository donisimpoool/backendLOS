package com.ikkat.los.service;

import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.ApplicationCollateralEntity;
import com.ikkat.los.entity.ApplicationCollateralVehicleEntity;


public interface ApplicationCollateralService {
	List<ApplicationCollateralEntity> findAll();
	Optional<ApplicationCollateralEntity> findById(String id);

	ApplicationCollateralEntity update(String id, ApplicationCollateralEntity cs);

	ApplicationCollateralEntity create(ApplicationCollateralEntity cs);
    
    void delete(String id);
    
    List<ApplicationCollateralVehicleEntity> findAllCollateralVehicle();
	Optional<ApplicationCollateralVehicleEntity> findCollateralVehicleById(String id);

	ApplicationCollateralVehicleEntity updateCollateralVehicle(String id, ApplicationCollateralVehicleEntity cs);

	ApplicationCollateralVehicleEntity createCollateralVehicle(ApplicationCollateralVehicleEntity cs);
    
    void deleteCollateralVehicle(String id);
}
