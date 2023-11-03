package com.ikkat.los.validation;

import java.util.ArrayList;
import java.util.List;

import com.ikkat.los.entity.parameterValidation;
import com.ikkat.los.enumeration.TypeCollateral;
import com.ikkat.los.helper.entity.ValidationEntity;
import com.ikkat.los.jsonmodel.ApplicationCollateralRealEstateJson;
import com.ikkat.los.jsonmodel.CheckUpdateSimpoolJson;
import com.ikkat.los.service.CustomerService;

public class Validation {
	public static boolean checkCollateral(String type,String value) {
		if(value.toUpperCase().equals(type) && !value.equals("")) {
			return true;
		}else if(value.toUpperCase().equals(type) && !value.equals("")) {
			return true;
		}else if(value.toUpperCase().equals(type) && !value.equals("")) {
			return true;
		}
		return false;
	}
	
	public static boolean cekCustomer(CustomerService service,String id) {
		return service.findById(id).isPresent();
	}
	public static String validasi(parameterValidation param) {
		String msg = "";
		if(!param.getValue().contains(param.getFixValue())) {
			msg = "";
		}
		
		return msg;
	}
	
	public static List<ValidationEntity> validationFindCustomer(CheckUpdateSimpoolJson jsonpayload){
		List<ValidationEntity> listreturn = new ArrayList<ValidationEntity>();
		ValidationEntity val = new ValidationEntity();
		if(jsonpayload.getDateofbirth() == 0) {
			val.setErrorparameter("DateOfbirth");
			val.setErrormessages("Date Of birth Not Empty");
			listreturn.add(val);
		}
		
		if(jsonpayload.getFullname().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("Name");
			val.setErrormessages("Name Not Empty");
			listreturn.add(val);
		}
		
		if(jsonpayload.getIdnumber().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("IdNumber");
			val.setErrormessages("ID Number Not Empty");
			listreturn.add(val);
		}
		
		return listreturn;
	}
}
