package com.ikkat.los.formapplication.applicationcollateral.repo;

import com.ikkat.los.formapplication.applicationcollateral.entity.ApplicationCollateral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ApplicationCollateralRepo")
public interface ApplicationCollateralRepo extends JpaRepository<ApplicationCollateral, Long> {
}
