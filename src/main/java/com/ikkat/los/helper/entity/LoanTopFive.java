package com.ikkat.los.helper.entity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LoanTopFive {
	private String loanid;
	private String loanname;
	private String loandescription;
	private int jumlahloan;
	public String getLoanname() {
		return loanname;
	}
	public void setLoanname(String loanname) {
		this.loanname = loanname;
	}
	public String getLoandescription() {
		return loandescription;
	}
	public void setLoandescription(String loandescription) {
		this.loandescription = loandescription;
	}
	public int getJumlahloan() {
		return jumlahloan;
	}
	public void setJumlahloan(int jumlahloan) {
		this.jumlahloan = jumlahloan;
	}
	
	public String getLoanid() {
		return loanid;
	}
	public void setLoanid(String loanid) {
		this.loanid = loanid;
	}
	public List<LoanTopFive> SetLoanTopFive(List<Object> listobj){
		List<LoanTopFive> listLoan = new ArrayList<LoanTopFive>();
		for(Object obj : listobj) {
			LoanTopFive loan = new LoanTopFive();
			Object[] arobj = (Object[]) obj;
			LoanRangeSize entity = new LoanRangeSize();
			String loanid = String.valueOf(arobj[0]);
			String loandesc = String.valueOf(arobj[1]);
			String loanname = String.valueOf(arobj[2]);
			BigInteger jmlloan = (BigInteger) arobj[29];
			loan.setLoanid(loanid);
			loan.setLoanname(loanname);
			loan.setLoandescription(loandesc);
			loan.setJumlahloan(jmlloan.intValue());
			listLoan.add(loan);
		}
		return listLoan;
	}
}
