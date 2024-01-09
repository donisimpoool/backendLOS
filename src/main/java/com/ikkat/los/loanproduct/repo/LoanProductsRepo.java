package com.ikkat.los.loanproduct.repo;

import com.ikkat.los.loanproduct.entity.LoanProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("LoanProductsRepo")
public interface LoanProductsRepo extends JpaRepository<LoanProduct, Long> {
}
