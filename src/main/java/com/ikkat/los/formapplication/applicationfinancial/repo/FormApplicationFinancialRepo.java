package com.ikkat.los.formapplication.applicationfinancial.repo;

import com.ikkat.los.formapplication.applicationfinancial.entity.ApplicationFinancial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("FormApplicationFinancialRepo")
public interface FormApplicationFinancialRepo extends JpaRepository<ApplicationFinancial, Long> {
}
