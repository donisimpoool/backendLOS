package com.ikkat.los.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.LoanProductEntity;

public interface LoanProductService {
	List<LoanProductEntity> findAll();
	Optional<LoanProductEntity> findById(String id);

	LoanProductEntity update(String id, LoanProductEntity cs);

	LoanProductEntity create(LoanProductEntity cs);
    
    void delete(String id);
    
    List<Object> loanProductTopFive(Date from,Date thru);
    
    List<Object> loanRangeSize(Date from,Date thru);
    
    Double jumlahapplicantbystatus(Date from,Date thru,String status);
    
    Double jumlahapplicant(Date from,Date thru);
    
    LoanProductEntity getLoanProductByexternalid(String externalid);
    
    void updateStatusNotListLoan(String isactive,List<String> listexternalid);
    
    List<LoanProductEntity> getListLoanProductByIsActive(String isactive);
    
}
