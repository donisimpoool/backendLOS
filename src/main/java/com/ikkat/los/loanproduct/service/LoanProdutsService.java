package com.ikkat.los.loanproduct.service;

import com.ikkat.los.formapplication.applicationscore.entity.ApplicationScoreData;
import com.ikkat.los.loanproduct.entity.BodyLoanDashboard;
import com.ikkat.los.loanproduct.entity.LoanRangeSize;
import com.ikkat.los.loanproduct.entity.LoanTopFive;

import java.util.List;

public interface LoanProdutsService {
    List<LoanTopFive> getListLoanDashboardTopFive(Long idcompany, BodyLoanDashboard body);
    List<LoanRangeSize> getListLoanDashboardRangeSize(Long idcompany, BodyLoanDashboard body);
}
