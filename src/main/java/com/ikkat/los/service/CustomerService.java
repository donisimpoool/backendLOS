package com.ikkat.los.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.ikkat.los.entity.CustomerEntity;


public interface CustomerService {
	List<CustomerEntity> findAll();
	Optional<CustomerEntity> findById(String id);

	CustomerEntity update(String id, CustomerEntity cs);

	CustomerEntity create(CustomerEntity cs);
    
    void delete(String id);
    
    CustomerEntity getCustomerByCFOrCustID(String customerid,String cfid);
    
    CustomerEntity getcustomerbyFieldPriority(String name,String idnumber,Date dateofbirth);
}
