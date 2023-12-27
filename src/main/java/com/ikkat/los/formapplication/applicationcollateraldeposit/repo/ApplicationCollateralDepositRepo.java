package com.ikkat.los.formapplication.applicationcollateraldeposit.repo;

import com.ikkat.los.formapplication.applicationcollateraldeposit.entity.ApplicationCollateralDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ApplicationCollateralDepositRepo")
public interface ApplicationCollateralDepositRepo extends JpaRepository<ApplicationCollateralDeposit, Long> {
}
