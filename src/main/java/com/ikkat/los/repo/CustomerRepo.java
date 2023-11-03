package com.ikkat.los.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.CustomerEntity;
import com.ikkat.los.entity.RunningNumberEntity;


@Repository("CustomerRepo")
public interface CustomerRepo extends JpaRepository<CustomerEntity, String>{
	@Query(value =" select * from m_customer "
			+ " where customerid = :customerid or cif_id = :cfid limit 1 ",nativeQuery = true)
	public CustomerEntity getCustomerByCFOrCustID(@Param("customerid") String customerid,@Param("cfid") String cfid);
	
	@Query(value =" select * from m_customer "
			+ " where lower(REPLACE(name, ' ', '+')) = :name and idnumber = :idnumber and dateofbirth = :dateofbirth limit 1 ",nativeQuery = true)
	public CustomerEntity getcustomerbyFieldPriority(@Param("name") String name,@Param("idnumber") String idnumber,@Param("dateofbirth") Date dateofbirth);
	
}
