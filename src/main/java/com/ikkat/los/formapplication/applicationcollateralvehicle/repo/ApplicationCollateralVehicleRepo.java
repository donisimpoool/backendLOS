package com.ikkat.los.formapplication.applicationcollateralvehicle.repo;

import com.ikkat.los.formapplication.applicationcollateralvehicle.entity.ApplicationCollateralVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ApplicationCollateralVehicleRepo")
public interface ApplicationCollateralVehicleRepo extends JpaRepository<ApplicationCollateralVehicle, Long> {
}
