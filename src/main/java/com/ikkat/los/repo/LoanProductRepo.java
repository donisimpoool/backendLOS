package com.ikkat.los.repo;


import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.LoanProductEntity;

@Repository("LoanProductRepo")
public interface LoanProductRepo extends JpaRepository<LoanProductEntity, String>{
	@Query(value =" select mloan.*,count(apploan.applicationid) from m_loan_product as mloan"
			+ " join application_loan as apploan on mloan.loan_product_id = apploan.loanproductid"
			+ " join application as app on app.applicationid = apploan.applicationid"
			+ " where app.date >= :from and app.date <= :thru "
			+ " GROUP BY mloan.loan_product_id"
			+ " order by count(mloan.loan_product_id) DESC limit 5 ",nativeQuery = true)
	public List<Object> loanProductTopFive(@Param("from") Date from, @Param("thru") Date thru);
	
	@Query(value =" select mloan.*,sum(apploan.amount) as sumloan from m_loan_product as mloan"
			+ " join application_loan as apploan on mloan.loan_product_id = apploan.loanproductid"
			+ " join application as app on app.applicationid = apploan.applicationid"
			+ " where app.date >= :from and app.date <= :thru "
			+ " GROUP BY mloan.loan_product_id"
			+ " order by sumloan DESC ",nativeQuery = true)
	public List<Object> loanRangeSize(@Param("from") Date from, @Param("thru") Date thru);
	
	@Query(value =" select count(app.applicationid) from application as app "
			+ " where app.status = :status and "
			+ " app.date >= :from and app.date <= :thru ",nativeQuery = true)
	public Double jumlahapplicantbystatus(@Param("from") Date from, @Param("thru") Date thru,@Param("status") String status);
	
	@Query(value =" select count(app.applicationid) from application as app "
			+ " where app.date >= :from and app.date <= :thru ",nativeQuery = true)
	public Double jumlahapplicant(@Param("from") Date from, @Param("thru") Date thru);
	
	@Query(value =" select * from m_loan_product "
			+ " where externalid = :externalid limit 1 ",nativeQuery = true)
	public LoanProductEntity getLoanProductByexternalid(@Param("externalid") String externalid);
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =" update m_loan_product set isactive = :isactive "
			+ " where externalid not in (:listexternalid) ",nativeQuery = true)
	void updateStatusNotListLoan(@Param("isactive") String isactive,@Param("listexternalid") List<String> listexternalid);
	
	@Query(value =" select * from m_loan_product where isactive = :isactive ",nativeQuery = true)
	public List<LoanProductEntity> getListLoanProductByIsActive(@Param("isactive") String isactive);
}
