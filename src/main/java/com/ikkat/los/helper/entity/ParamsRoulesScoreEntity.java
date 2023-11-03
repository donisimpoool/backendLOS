package com.ikkat.los.helper.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.ikkat.los.jsonmodel.ApplicationFInancialJson;
import com.ikkat.los.jsonmodel.ApplicationJSON;

public class ParamsRoulesScoreEntity {
	private int valuenumberage;
	private String valuegender;
	private String valuemaritalstatus;
	private int valuenumberofdependant;
	private String valueeducation;
	private int valuecompanysize;
	private String valueindustrysector;
	private String valuejobtittle;
	private int valuedurationwork;
	private String valueincometype;
	private String valuepropertypossession;
	private double valuedebtincomeratio;
	private String valuecreditcardowner;
	private String valueliveownershipstatus;
	private String valuelocation;
	private String valuevehicleowner;
	private String valueprovinceid;
	private String regenciesid;
	private double netincome;
	private String filterid;
	private int maxreject;
	private double valueexpense;
	private double valueaddtionalexpense;
	private double valuemainincome;
	private double valuesideincome;
	private double valueloanamount;
	private int valuetenor;
	private String valueposition;
	
	public ParamsRoulesScoreEntity setvalue(ApplicationJSON jsonPayload) {
		int age = 0;
		long dateofbirth = jsonPayload.getAppPersonel().getDateofbirth();
		System.out.println("dateofbirth : "+dateofbirth);
		if(dateofbirth > 0) {
			Timestamp tsDateBirth = new Timestamp(dateofbirth);
			Date dt = new Date();
			Timestamp tsNow = new Timestamp(dt.getTime());
			long miliseconds = tsNow.getTime() - dateofbirth;
			Long days = TimeUnit.DAYS.convert(miliseconds, TimeUnit.MILLISECONDS) / 365;
			System.out.println("days : "+days);
			if(days > 0) {
				age = days.intValue();
			}
		}
		
		String OwnershipStatus = "N";
		String CreditCardOwner = "N";
		if(jsonPayload.getAppAddress1().getOwnershipstatus().equals("own")) {
			OwnershipStatus = "Y";
		}
		if(jsonPayload.getAppBank().getIscc().equals("Y")) {
			CreditCardOwner = "Y";
		}
		
		ParamsRoulesScoreEntity params = new ParamsRoulesScoreEntity();
		params.setValuenumberage(age);
		params.setValuegender(jsonPayload.getAppPersonel().getGender());
		params.setValuemaritalstatus(jsonPayload.getAppPersonel().getMaritalstatus());
		params.setValuenumberofdependant(jsonPayload.getAppPersonel().getNumberofdependant());
		params.setValueeducation(jsonPayload.getAppPersonel().getEducation());
		params.setValuecompanysize(new Integer(jsonPayload.getAppBusiness().getTotalnumberemp()));
		params.setValueindustrysector(jsonPayload.getAppBusiness().getBusinessline());
		params.setValuejobtittle(jsonPayload.getAppBusiness().getPosition());
		params.setValuedurationwork(new Integer( jsonPayload.getAppBusiness().getDuration()));
		params.setValueincometype(jsonPayload.getAppFinancial().getTypeincome());
		params.setValuepropertypossession(OwnershipStatus);
		params.setValuedebtincomeratio(debtincomeratio(new Double(jsonPayload.getAppFinancial().getMainincome()),new Double(jsonPayload.getAppLoan().getLoanAmount()),new Integer(jsonPayload.getAppLoan().getTenor())));
		params.setValuecreditcardowner(CreditCardOwner);
		params.setValueliveownershipstatus(jsonPayload.getAppAddress1().getOwnershipstatus());
		String typevehicle = "No";
		if(!jsonPayload.getAppFinancial().getTypevehicle().equals("")) {
			typevehicle = jsonPayload.getAppFinancial().getTypevehicle();
		}
		params.setValuevehicleowner(typevehicle);
		params.setValuelocation(jsonPayload.getAppAddress1().getLocation());
		params.setValueprovinceid(jsonPayload.getAppAddress1().getProvince());
		params.setRegenciesid(jsonPayload.getAppAddress1().getIdregencies());
		params.setNetincome(netincome(jsonPayload.getAppFinancial()));
		params.setFilterid(jsonPayload.getAppLoan().getFilterid());
		params.setMaxreject(jsonPayload.getAppLoan().getMaxreject());
		
		if(jsonPayload.getAppFinancial().getExpense() != null && !jsonPayload.getAppFinancial().getExpense().contentEquals("")) {
			params.setValueexpense(new Double(jsonPayload.getAppFinancial().getExpense()).doubleValue());
		}else {
			params.setValueexpense(0);
		}
		if(jsonPayload.getAppFinancial().getAddtionalexpense() != null && !jsonPayload.getAppFinancial().getAddtionalexpense().contentEquals("")) {
			params.setValueaddtionalexpense(new Double(jsonPayload.getAppFinancial().getAddtionalexpense()).doubleValue());
		}else {
			params.setValueaddtionalexpense(0);
		}
		if(jsonPayload.getAppFinancial().getMainincome() != null && !jsonPayload.getAppFinancial().getMainincome().contentEquals("")) {
			params.setValuemainincome(new Double(jsonPayload.getAppFinancial().getMainincome()).doubleValue());
		}else {
			params.setValuemainincome(0);
		}
		if(jsonPayload.getAppFinancial().getSideincome() != null && !jsonPayload.getAppFinancial().getSideincome().contentEquals("")) {
			params.setValuesideincome(new Double(jsonPayload.getAppFinancial().getSideincome()).doubleValue());
		}else {
			params.setValuesideincome(0);
		}
		
		if(jsonPayload.getAppLoan().getLoanAmount() != null && !jsonPayload.getAppLoan().getLoanAmount().contentEquals("")) {
			params.setValueloanamount(new Double(jsonPayload.getAppLoan().getLoanAmount()).doubleValue());
		}else {
			params.setValueloanamount(0.0);
		}
		params.setValuetenor(jsonPayload.getAppLoan().getTenor());
		params.setValueposition(jsonPayload.getAppBusiness().getDivision());
		return params;
	}
	
	public String getValueposition() {
		return valueposition;
	}

	public void setValueposition(String valueposition) {
		this.valueposition = valueposition;
	}

	public double getValueloanamount() {
		return valueloanamount;
	}

	public void setValueloanamount(double valueloanamount) {
		this.valueloanamount = valueloanamount;
	}

	public int getValuetenor() {
		return valuetenor;
	}

	public void setValuetenor(int valuetenor) {
		this.valuetenor = valuetenor;
	}

	public double getValueexpense() {
		return valueexpense;
	}

	public void setValueexpense(double valueexpense) {
		this.valueexpense = valueexpense;
	}

	public double getValueaddtionalexpense() {
		return valueaddtionalexpense;
	}

	public void setValueaddtionalexpense(double valueaddtionalexpense) {
		this.valueaddtionalexpense = valueaddtionalexpense;
	}

	public double getValuemainincome() {
		return valuemainincome;
	}

	public void setValuemainincome(double valuemainincome) {
		this.valuemainincome = valuemainincome;
	}

	public double getValuesideincome() {
		return valuesideincome;
	}

	public void setValuesideincome(double valuesideincome) {
		this.valuesideincome = valuesideincome;
	}

	public int getMaxreject() {
		return maxreject;
	}

	public void setMaxreject(int maxreject) {
		this.maxreject = maxreject;
	}

	private double netincome(ApplicationFInancialJson jsonpay) {
		double value = 0.0;
		double income =new Double(jsonpay.getMainincome()).doubleValue() + new Double(jsonpay.getSideincome()).doubleValue();
		double expense = new Double(jsonpay.getExpense()).doubleValue() + new Double(jsonpay.getAddtionalexpense()).doubleValue();
		value = income - expense;
		return value;
	}
	private double debtincomeratio(double income, double pinjaman,int tenor) {
		double val = 100.0;
		double cicilanperbulan = pinjaman;
		if(tenor > 0) {
			cicilanperbulan = cicilanperbulan / new Double(tenor);
		}
		if(income > 0) {
			val = cicilanperbulan / income;
			val = val * 100.0;
		}
		return val;
	}
	
	public String getFilterid() {
		return filterid;
	}

	public void setFilterid(String filterid) {
		this.filterid = filterid;
	}

	public double getNetincome() {
		return netincome;
	}

	public void setNetincome(double netincome) {
		this.netincome = netincome;
	}

	public String getValueprovinceid() {
		return valueprovinceid;
	}

	public void setValueprovinceid(String valueprovinceid) {
		this.valueprovinceid = valueprovinceid;
	}

	public String getRegenciesid() {
		return regenciesid;
	}

	public void setRegenciesid(String regenciesid) {
		this.regenciesid = regenciesid;
	}

	public double getValuenumberage() {
		return valuenumberage;
	}
	public void setValuenumberage(int valuenumberage) {
		this.valuenumberage = valuenumberage;
	}
	public String getValuegender() {
		return valuegender;
	}
	public void setValuegender(String valuegender) {
		this.valuegender = valuegender;
	}
	public String getValuemaritalstatus() {
		return valuemaritalstatus;
	}
	public void setValuemaritalstatus(String valuemaritalstatus) {
		this.valuemaritalstatus = valuemaritalstatus;
	}
	public int getValuenumberofdependant() {
		return valuenumberofdependant;
	}
	public void setValuenumberofdependant(int valuenumberofdependant) {
		this.valuenumberofdependant = valuenumberofdependant;
	}
	public String getValueeducation() {
		return valueeducation;
	}
	public void setValueeducation(String valueeducation) {
		this.valueeducation = valueeducation;
	}
	public int getValuecompanysize() {
		return valuecompanysize;
	}
	public void setValuecompanysize(int valuecompanysize) {
		this.valuecompanysize = valuecompanysize;
	}
	public String getValueindustrysector() {
		return valueindustrysector;
	}
	public void setValueindustrysector(String valueindustrysector) {
		this.valueindustrysector = valueindustrysector;
	}
	public String getValuejobtittle() {
		return valuejobtittle;
	}
	public void setValuejobtittle(String valuejobtittle) {
		this.valuejobtittle = valuejobtittle;
	}
	public int getValuedurationwork() {
		return valuedurationwork;
	}
	public void setValuedurationwork(int valuedurationwork) {
		this.valuedurationwork = valuedurationwork;
	}
	public String getValueincometype() {
		return valueincometype;
	}
	public void setValueincometype(String valueincometype) {
		this.valueincometype = valueincometype;
	}
	public String getValuepropertypossession() {
		return valuepropertypossession;
	}
	public void setValuepropertypossession(String valuepropertypossession) {
		this.valuepropertypossession = valuepropertypossession;
	}
	public double getValuedebtincomeratio() {
		return valuedebtincomeratio;
	}
	public void setValuedebtincomeratio(double valuedebtincomeratio) {
		this.valuedebtincomeratio = valuedebtincomeratio;
	}
	public String getValuecreditcardowner() {
		return valuecreditcardowner;
	}
	public void setValuecreditcardowner(String valuecreditcardowner) {
		this.valuecreditcardowner = valuecreditcardowner;
	}
	public String getValueliveownershipstatus() {
		return valueliveownershipstatus;
	}
	public void setValueliveownershipstatus(String valueliveownershipstatus) {
		this.valueliveownershipstatus = valueliveownershipstatus;
	}
	public String getValuelocation() {
		return valuelocation;
	}
	public void setValuelocation(String valuelocation) {
		this.valuelocation = valuelocation;
	}
	public String getValuevehicleowner() {
		return valuevehicleowner;
	}
	public void setValuevehicleowner(String valuevehicleowner) {
		this.valuevehicleowner = valuevehicleowner;
	}
	
}
