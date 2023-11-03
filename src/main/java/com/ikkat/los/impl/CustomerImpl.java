package com.ikkat.los.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ikkat.los.entity.CustomerEntity;
import com.ikkat.los.repo.CustomerRepo;
import com.ikkat.los.service.CustomerService;

@Service
public class CustomerImpl implements CustomerService {
	@Autowired
	private CustomerRepo repository;
	
	@Override
	public List<CustomerEntity> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Optional<CustomerEntity> findById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public CustomerEntity update(String id, CustomerEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public CustomerEntity create(CustomerEntity cs) {
		// TODO Auto-generated method stub
		return repository.save(cs);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public CustomerEntity getCustomerByCFOrCustID(String customerid, String cfid) {
		// TODO Auto-generated method stub
		return repository.getCustomerByCFOrCustID(customerid, cfid);
	}

	@Override
	public CustomerEntity getcustomerbyFieldPriority(String name, String idnumber, Date dateofbirth) {
		// TODO Auto-generated method stub
		return repository.getcustomerbyFieldPriority(name, idnumber, dateofbirth);
	}

}
