package com.ikkat.los.formapplication.applicationcollateralrealestate.repo;

import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.ApplicationCollateralRealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ApplicationCollateralRealEstateRepo")
public interface ApplicationCollateralRealEstateRepo extends JpaRepository<ApplicationCollateralRealEstate, Long> {
}
