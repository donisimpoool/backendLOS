package com.ikkat.los.formapplication.applicationloan.service;

import com.ikkat.los.formapplication.applicationloan.entity.ApplicationLoanData;
import com.ikkat.los.formapplication.applicationloan.entity.BodyApplicationLoan;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface ApplicationLoanService {
    List<ApplicationLoanData> getListAll(Long idcompany);
    ApplicationLoanData getId(Long id,Long idcompany);
    List<ApplicationLoanData> getByIdApplication(Long idapplication,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, Long idapplication, BodyApplicationLoan body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplicationLoan body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
}
