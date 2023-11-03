package com.ikkat.los.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikkat.los.entity.ApplicationCollateralDepositEntity;
import com.ikkat.los.entity.ApplicationCollateralRealEstateEntity;

public interface ApplicationCollateralDepositRepo extends JpaRepository<ApplicationCollateralDepositEntity, String>{

}
