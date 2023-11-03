package com.ikkat.los.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.LoanProductEntity;
import com.ikkat.los.repo.LoanProductRepo;
import com.ikkat.los.service.LoanProductService;

@Service
public class LoanProductImpl implements LoanProductService{
	@Autowired
	private LoanProductRepo repository;
	
	@Override
	public List<LoanProductEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<LoanProductEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public LoanProductEntity update(String id, LoanProductEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public LoanProductEntity create(LoanProductEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
	 repository.deleteById(id);
	}

	@Override
	public List<Object> loanProductTopFive(Date from,Date thru) {
		// TODO Auto-generated method stub
		return repository.loanProductTopFive(from, thru);
	}

	@Override
	public List<Object> loanRangeSize(Date from, Date thru) {
		// TODO Auto-generated method stub
		return repository.loanRangeSize(from, thru);
	}

	@Override
	public Double jumlahapplicantbystatus(Date from,Date thru,String status) {
		// TODO Auto-generated method stub
		return repository.jumlahapplicantbystatus(from,thru,status);
	}

	@Override
	public Double jumlahapplicant(Date from, Date thru) {
		// TODO Auto-generated method stub
		return repository.jumlahapplicant(from, thru);
	}

	@Override
	public LoanProductEntity getLoanProductByexternalid(String externalid) {
		// TODO Auto-generated method stub
		return repository.getLoanProductByexternalid(externalid);
	}

	@Override
	public void updateStatusNotListLoan(String isactive, List<String> listexternalid) {
		// TODO Auto-generated method stub
		repository.updateStatusNotListLoan(isactive, listexternalid);
		
	}

	@Override
	public List<LoanProductEntity> getListLoanProductByIsActive(String isactive) {
		// TODO Auto-generated method stub
		return repository.getListLoanProductByIsActive(isactive);
	}

}
