package com.ikkat.los.formapplication.applicationloan.repo;

import com.ikkat.los.formapplication.applicationloan.entity.ApplicationLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FormApplicationLoanRepo")
public interface FormApplicationLoanRepo extends JpaRepository<ApplicationLoan, Long> {
}
