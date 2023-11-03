package com.ikkat.los.validation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ikkat.los.helper.entity.ValidationEntity;
import com.ikkat.los.jsonmodel.ApplicationJSON;

public class ValidationLoanApp {

	public static List<ValidationEntity> validationLoanApp(ApplicationJSON jsonpayload){
		int maxMsg = 10;
		List<ValidationEntity> listreturn = new ArrayList<ValidationEntity>();
		ValidationEntity val = new ValidationEntity();
		if(jsonpayload.getAppLoan().getLoanproductID().equals("0") || jsonpayload.getAppLoan().getLoanproductID().equals("")) {
			val.setErrorparameter("LoanProductID");
			val.setErrormessages("Loan = Product harus diisi");
			listreturn.add(val);
		}
		if(jsonpayload.getAppLoan().getLoanAmount().equals("0") || jsonpayload.getAppLoan().getLoanAmount().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("LoanAmount");
			val.setErrormessages("Loan = Amount harus lebih besar dari 0");
			listreturn.add(val);
		}
		if(jsonpayload.getAppLoan().getPurposeofloan().equals("0") || jsonpayload.getAppLoan().getPurposeofloan().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("PurposeOfLoan");
			val.setErrormessages("Loan = Purpose harus diisi");
			listreturn.add(val);
		}
		if(jsonpayload.getAppLoan().getTenor() == 0 ) {
			val = new ValidationEntity();
			val.setErrorparameter("Tenor");
			val.setErrormessages("Loan = Tenor harus lebih besar dari 0");
			listreturn.add(val);
		}
		
		if(jsonpayload.getAppPersonel().getFullname().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("Name");
			val.setErrormessages("Personal = Full Name Harus Diisi");
			listreturn.add(val);
		}
		if(jsonpayload.getAppPersonel().getMobilephone().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("MobilePhone");
			val.setErrormessages("Personal = MobilePhone Harus Diisi");
			listreturn.add(val);
		}
		if(jsonpayload.getAppPersonel().getPlaceofbirth().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("PlaceOfBirth");
			val.setErrormessages("Personal = Place Of Birth Harus Diisi");
			listreturn.add(val);
		}
		boolean flagdateofbirth = true;
		if (String.valueOf(jsonpayload.getAppPersonel().getDateofbirth()) == "0" || jsonpayload.getAppPersonel().getDateofbirth() == 0 || String.valueOf(jsonpayload.getAppPersonel().getDateofbirth()) == "") {
			val = new ValidationEntity();
			val.setErrorparameter("DateOfBirth");
			val.setErrormessages("Personal = Date Of Birth Harus Diisi");
			listreturn.add(val);
			flagdateofbirth = false;
		}
		
		boolean flaggender = true;
		if(jsonpayload.getAppPersonel().getGender().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("Gender");
			val.setErrormessages("Personal = Gender Harus Diisi");
			listreturn.add(val);
			flaggender = false;
		}
		if(jsonpayload.getAppPersonel().getIdtype().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("IdType");
			val.setErrormessages("Personal = Type ID Harus Diisi");
			listreturn.add(val);
		}
		if(jsonpayload.getAppPersonel().getIdnumber().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("IdNumber");
			val.setErrormessages("Personal = Number ID Harus Diisi");
			listreturn.add(val);
		}else {
			if(jsonpayload.getAppPersonel().getIdtype().equals("KTP")) {
				String idnumber = jsonpayload.getAppPersonel().getIdnumber();
				if (idnumber.length() > 16 || idnumber.length() < 16) {
					val = new ValidationEntity();
					val.setErrorparameter("IdNumber");
					val.setErrormessages("Personal = Number ID Harus 16 Character");
					listreturn.add(val);
				}else {
					idnumber = idnumber.substring(6, 12);
                    String datektp = idnumber.substring(0, 2);
                    String monthktp = idnumber.substring(2, 4);
                    String yearktp = idnumber.substring(4, 6);
                    if (flagdateofbirth && flaggender) {
                    	Timestamp tempdate = new Timestamp(jsonpayload.getAppPersonel().getDateofbirth());
                    	int month = (tempdate.getMonth() + 1);
                        int date = tempdate.getDate();
                        int year = tempdate.getYear()+1900;
                        String strMonth = String.valueOf(month);
                        String strDate = String.valueOf(date);
                        String strYear = String.valueOf(year);
                        if (month < 10) {
                        	strMonth = "0" + month;
                        }
                        if (date < 10) {
                        	strDate = "0" + date;
                        }
                        strYear = strYear.toString().substring(2, 4);
                        if (jsonpayload.getAppPersonel().getGender() == "F") {
                            date += 40;
                        }
                        System.out.println(datektp+" = "+strDate+" | "+monthktp+" = "+strMonth+" | "+yearktp+" = "+strYear);
                        if (!datektp.equals(strDate) || !monthktp.equals(strMonth) || !yearktp.equals(strYear)) {
                        	val = new ValidationEntity();
        					val.setErrorparameter("IdNumber");
        					val.setErrormessages("Personal = Number ID Tidak Sesuai");
        					listreturn.add(val);
                        }
                    }else {
                    	val = new ValidationEntity();
    					val.setErrorparameter("IdNumber");
    					val.setErrormessages("Personal = Number ID Tidak Sesuai");
    					listreturn.add(val);
                    }
				}
			}
		}
		if (jsonpayload.getAppPersonel().getEducation().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("Education");
			val.setErrormessages("Personal = Education Harus Diisi");
			listreturn.add(val);
        }
		if (jsonpayload.getAppPersonel().getMaritalstatus().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("MaritalStatus");
			val.setErrormessages("Personal = maritalstatus Harus Diisi");
			listreturn.add(val);
		}
		if (String.valueOf(jsonpayload.getAppPersonel().getNumberofdependant()).equals("") || jsonpayload.getAppPersonel().getNumberofdependant() == 0) {
            if (!jsonpayload.getAppPersonel().getMaritalstatus().equals("") && !jsonpayload.getAppPersonel().getMaritalstatus().equals("Single")) {
            	val = new ValidationEntity();
    			val.setErrorparameter("Numberofdependant");
    			val.setErrormessages("Personal = numberofdependant Harus Diisi");
    			listreturn.add(val);                
            }
        }
		if (jsonpayload.getAppPersonel().getEmail().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("Email");
			val.setErrormessages("Personal = email Harus Diisi");
			listreturn.add(val);
        }
		if (jsonpayload.getAppPersonel().getReligionid().equals("")) {
			val = new ValidationEntity();
			val.setErrorparameter("Religion");
			val.setErrormessages("Personal = Religion Harus Diisi");
			listreturn.add(val);
        }
        if (jsonpayload.getAppPersonel().getTaxnumber().equals("")) {
        	val = new ValidationEntity();
			val.setErrorparameter("TaxNumber");
			val.setErrormessages("Personal = Tax Number Harus Diisi");
			listreturn.add(val);
        }
        
        if (jsonpayload.getAppAddress1().getMainaddress().equals("")) {
        	val = new ValidationEntity();
			val.setErrorparameter("Main Address");
			val.setErrormessages("Personal = Main Address Harus Diisi");
			listreturn.add(val);
        }
        if (jsonpayload.getAppAddress1().getProvince().equals("")) {
        	val = new ValidationEntity();
			val.setErrorparameter("Province");
			val.setErrormessages("Main Addres = province Harus Diisi");
			listreturn.add(val);
        }
        
        if (jsonpayload.getAppAddress1().getPostalcode().equals("")) {
        	val = new ValidationEntity();
			val.setErrorparameter("Postalcode");
			val.setErrormessages("Main Addres = postalcode Harus Diisi");
			listreturn.add(val);
        }
        if (jsonpayload.getAppAddress1().getOwnershipstatus().equals("")) {
        	val = new ValidationEntity();
			val.setErrorparameter("Ownershipstatus");
			val.setErrormessages("Main Addres = ownershipstatus Harus Diisi");
			listreturn.add(val);
        }
//        if (jsonpayload.getAppAddress1().getCollateral() == "") {
//        	val = new ValidationEntity();
//			val.setErrorparameter("Collateral");
//			val.setErrormessages("Main Addres = collateral Harus Diisi");
//			listreturn.add(val);
//        }
        if (jsonpayload.getAppAddress1().getLivedinyears() == "") {
        	val = new ValidationEntity();
			val.setErrorparameter("livedinyears");
			val.setErrormessages("Main Addres = livedinyears Harus Diisi");
			listreturn.add(val);
        }
        if (jsonpayload.getAppAddress1().getIdregencies().equals("0")) {
        	val = new ValidationEntity();
			val.setErrorparameter("City");
			val.setErrormessages("Main Addres = City Harus Diisi");
			listreturn.add(val);
        }
        if (jsonpayload.getAppAddress1().getIddistrict().equals("0")) {
        	val = new ValidationEntity();
			val.setErrorparameter("District");
			val.setErrormessages("Main Addres = District Harus Diisi");
			listreturn.add(val);
        }
        if (jsonpayload.getAppAddress1().getLocation().equals("")) {
        	val = new ValidationEntity();
			val.setErrorparameter("District");
			val.setErrormessages("Main Addres = location Harus Diisi");
			listreturn.add(val);
        }
        if (jsonpayload.getAppAddress1().getRt().equals("")) {
        	val = new ValidationEntity();
			val.setErrorparameter("RT");
			val.setErrormessages("Main Addres = RT Harus Diisi");
			listreturn.add(val);
        }else {
        	try {
        		int rt = new Integer(jsonpayload.getAppAddress1().getRt());
        	}catch (Exception e) {
        		val = new ValidationEntity();
    			val.setErrorparameter("RT");
    			val.setErrormessages("Main Addres = RT Harus Diisi");
    			listreturn.add(val);
				// TODO: handle exception
			}
        }
        if (jsonpayload.getAppAddress1().getRw().equals("")) {
        	val = new ValidationEntity();
			val.setErrorparameter("RW");
			val.setErrormessages("Main Addres = RW Harus Diisi");
			listreturn.add(val);
        }else {
        	try {
        		int rw = new Integer(jsonpayload.getAppAddress1().getRw());
        	}catch (Exception e) {
        		val = new ValidationEntity();
    			val.setErrorparameter("RW");
    			val.setErrormessages("Main Addres = RW Harus Diisi");
    			listreturn.add(val);
				// TODO: handle exception
			}
        }
        if (jsonpayload.getAppAddress1().getIdvillage() == 0 || String.valueOf(jsonpayload.getAppAddress1().getIdvillage()).equals("")) {
        	val = new ValidationEntity();
			val.setErrorparameter("Kelurahan");
			val.setErrormessages("Main Addres = Kelurahan Harus Diisi");
			listreturn.add(val);
        }
        
        if (!jsonpayload.getAppAddress2().getMainaddress().equals("")) {
        	if (jsonpayload.getAppAddress2().getProvince().equals("")) {
        		val = new ValidationEntity();
    			val.setErrorparameter("province");
    			val.setErrormessages("Second Addres = province Harus Diisi");
    			listreturn.add(val);
        	}
        	
        	if (jsonpayload.getAppAddress2().getPostalcode().equals("")) {
        		val = new ValidationEntity();
    			val.setErrorparameter("postalcode");
    			val.setErrormessages("Second Addres = postalcode Harus Diisi");
    			listreturn.add(val);
        	}
        	
        	if (jsonpayload.getAppAddress2().getOwnershipstatus().equals("")) {
        		val = new ValidationEntity();
    			val.setErrorparameter("ownershipstatus");
    			val.setErrormessages("Second Addres = ownershipstatus Harus Diisi");
    			listreturn.add(val);
        	}
        	
        	if (jsonpayload.getAppAddress2().getCollateral().equals("")) {
        		val = new ValidationEntity();
    			val.setErrorparameter("ownershipstatus");
    			val.setErrormessages("Second Addres = collateral Harus Diisi");
    			listreturn.add(val);
        	}
        	if (jsonpayload.getAppAddress2().getIdregencies().equals("0")) {
        		val = new ValidationEntity();
    			val.setErrorparameter("city");
    			val.setErrormessages("Second Addres = city Harus Diisi");
    			listreturn.add(val);
        	}
        	if (jsonpayload.getAppAddress2().getIddistrict().equals("0")) {
        		val = new ValidationEntity();
    			val.setErrorparameter("District");
    			val.setErrormessages("Second Addres = District Harus Diisi");
    			listreturn.add(val);
        	}
        }
        

		   	 if (jsonpayload.getAppFamily().getEmergencycontact().equals("")) {
		   		 val = new ValidationEntity();
	    		 val.setErrorparameter("emergencycontact");
	    		 val.setErrormessages("Family = emergencycontact Harus Diisi");
	    		 listreturn.add(val);
		        }
		   	 
		   	 if (jsonpayload.getAppFamily().getAddressemergencycontact().equals("")) {
		   		 val = new ValidationEntity();
	    		 val.setErrorparameter("addressemergency");
	    		 val.setErrormessages("Family = address emergency contact Harus Diisi");
	    		 listreturn.add(val);
		        }
		   	 if (jsonpayload.getAppFamily().getMobilephoneemergencycontact().equals("")) {
		   		 val = new ValidationEntity();
	    		 val.setErrorparameter("MobilePhoneEmergency");
	    		 val.setErrormessages("Family = Mobile Phone Harus Diisi");
	    		 listreturn.add(val);
		          
		        }
		   	 
		   	 
		   	if (jsonpayload.getAppBusiness().getCompanyaddress().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("companyAddress");
	    		val.setErrormessages("Business = company address Harus Diisi");
	    		listreturn.add(val);
	        }
		   	
		   	if (jsonpayload.getAppBusiness().getProvince().equals("0")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("province");
	    		val.setErrormessages("Business = province Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBusiness().getDivision().equals("0")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("division");
	    		val.setErrormessages("Business = division Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBusiness().getPosition().equals("0")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("position");
	    		val.setErrormessages("Business = position Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBusiness().getDuration().equals("0") || jsonpayload.getAppBusiness().getDuration().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("duration");
	    		val.setErrormessages("Business = duration Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBusiness().getTotalnumberemp().equals("0") || jsonpayload.getAppBusiness().getTotalnumberemp().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("totalnumber");
	    		val.setErrormessages("Business = total number employee Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBusiness().getBusinessline().equals("0") || jsonpayload.getAppBusiness().getBusinessline().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("businessline");
	    		val.setErrormessages("Business = businessline Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBusiness().getIdregencies().equals("0")|| jsonpayload.getAppBusiness().getIdregencies().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("City");
	    		val.setErrormessages("Business = City Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBusiness().getIddistrict().equals("0") || jsonpayload.getAppBusiness().getIddistrict().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("District");
	    		val.setErrormessages("Business = District Harus Diisi");
	    		listreturn.add(val);
	        }
		   	
		   	if (jsonpayload.getAppFinancial().getTypeincome().equals("0") || jsonpayload.getAppFinancial().getTypeincome().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("TypeIncome");
	    		val.setErrormessages("Financial = Type Income Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppFinancial().getMainincome().equals("0") || jsonpayload.getAppFinancial().getMainincome().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("MainIncome");
	    		val.setErrormessages("Financial = Main Income Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppFinancial().getSideincome().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("SideIncome");
	    		val.setErrormessages("Financial = Side Income Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppFinancial().getExpense().equals("0") || jsonpayload.getAppFinancial().getExpense().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("Expense");
	    		val.setErrormessages("Financial = Expense Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppFinancial().getAddtionalexpense().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("AddtionalExpense");
	    		val.setErrormessages("Financial = addtional expense Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppFinancial().getVehicleowner().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("vehicleowner");
	    		val.setErrormessages("Financial = vehicleowner Harus Diisi");
	    		listreturn.add(val);
	        } else {
	            if (jsonpayload.getAppFinancial().getVehicleowner().equals("Y")) {
	                if (jsonpayload.getAppFinancial().getTypevehicle().equals("")) {
	                	val = new ValidationEntity();
	    	    		val.setErrorparameter("TypeVehicle");
	    	    		val.setErrormessages("Financial = Type Vehicle Harus Diisi");
	    	    		listreturn.add(val);
	                }
	            }
	        }
		   	
		   	if (jsonpayload.getAppBank().getBank().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("Bank");
	    		val.setErrormessages("Bank = Bank Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBank().getAcctype().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("AccType");
	    		val.setErrormessages("Bank = Acc Type Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBank().getAccnumber().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("AccNumber");
	    		val.setErrormessages("Bank = Acc Number Harus Diisi");
	    		listreturn.add(val);
	        }
		   	if (jsonpayload.getAppBank().getIscc().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("CreditCard");
	    		val.setErrormessages("Bank = Credit Card Harus Diisi");
	    		listreturn.add(val);
	        } else {
	            if (jsonpayload.getAppBank().getIscc().equals("Y")) {
	                if (jsonpayload.getCreditcard().getIssuerid().equals("0")) {
	                	val = new ValidationEntity();
	    	    		val.setErrorparameter("Issuer");
	    	    		val.setErrormessages("Bank = Issuer Harus Diisi");
	    	    		listreturn.add(val);
	                }
	                if (jsonpayload.getCreditcard().getNumbercreditcard().equals("")) {
	                	val = new ValidationEntity();
	    	    		val.setErrorparameter("NumberCreditCard");
	    	    		val.setErrormessages("Bank = Number Credit Card Harus Diisi");
	    	    		listreturn.add(val);
	                }
	            }
	        }
		   	if (jsonpayload.getAppCollateral().getValueC().equals("")) {
		   		val = new ValidationEntity();
	    		val.setErrorparameter("Collateral");
	    		val.setErrormessages("Collateral = Collateral Harus Diisi");
	    		listreturn.add(val);
	        }else {
	        	if (jsonpayload.getAppCollateral().getValueC().equals("RealEstate")) {
	        		if (jsonpayload.getAppCollateralRealEstate().getTyperealestate().equals("")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("TypeCollateral");
	    	    		val.setErrormessages("Collateral Real Estate = Type Collateral Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralRealEstate().getCondition().equals("")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("condition");
	    	    		val.setErrormessages("Collateral Real Estate = condition Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralRealEstate().getYear().equals("0")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("year");
	    	    		val.setErrormessages("Collateral Real Estate = year Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralRealEstate().getRooms().equals("0") || jsonpayload.getAppCollateralRealEstate().getRooms().equals("")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("rooms");
	    	    		val.setErrormessages("Collateral Real Estate = rooms Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralRealEstate().getAddress().equals("")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("address");
	    	    		val.setErrormessages("Collateral Real Estate = address Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralRealEstate().getProvinceid().equals("0")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("province");
	    	    		val.setErrormessages("Collateral Real Estate = province Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralRealEstate().getRegenciesid().equals("0")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("city");
	    	    		val.setErrormessages("Collateral Real Estate = city Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralRealEstate().getDistrictid().equals("0")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("district");
	    	    		val.setErrormessages("Collateral Real Estate = district Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralRealEstate().getSize().equals("")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("size");
	    	    		val.setErrormessages("Collateral Real Estate = size Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralRealEstate().getProofofownership().equals("")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("proofofownership");
	    	    		val.setErrormessages("Collateral Real Estate = proofofownership Harus Diisi");
	    	    		listreturn.add(val);
	                }
	        	}else if(jsonpayload.getAppCollateral().getValueC().equals("Vehicle")) {
	        		 if (jsonpayload.getAppCollateralVehicle().getTypevehicle().equals("")) {
	        			val = new ValidationEntity();
	    	    		val.setErrorparameter("TypeVehicle");
	    	    		val.setErrormessages("Collateral Vehicle = Type Vehicle Harus Diisi");
	    	    		listreturn.add(val);
	                 }
	        		 if (jsonpayload.getAppCollateralVehicle().getBrand().equals("")) {
        			 	val = new ValidationEntity();
	    	    		val.setErrorparameter("brand");
	    	    		val.setErrormessages("Collateral Vehicle = brand Harus Diisi");
	    	    		listreturn.add(val);
	                 }
	        		 if (jsonpayload.getAppCollateralVehicle().getTypetransmision().equals("")) {
	        			 val = new ValidationEntity();
	    	    		 val.setErrorparameter("typetransmision");
	    	    		 val.setErrormessages("Collateral Vehicle = typetransmision Harus Diisi");
	    	    		 listreturn.add(val);
	                 }
	        		 if (jsonpayload.getAppCollateralVehicle().getYear().equals("0")) {
	        			 val = new ValidationEntity();
	    	    		 val.setErrorparameter("year");
	    	    		 val.setErrormessages("Collateral Vehicle = year Harus Diisi");
	    	    		 listreturn.add(val);
	                 }
	        		 if (jsonpayload.getAppCollateralVehicle().getMileage().equals("")) {
	        			 val = new ValidationEntity();
	    	    		 val.setErrorparameter("mileage");
	    	    		 val.setErrormessages("Collateral Vehicle = mileage Harus Diisi");
	    	    		 listreturn.add(val);
	                 }
	        		 if (jsonpayload.getAppCollateralVehicle().getModel().equals("")) {
	        			 val = new ValidationEntity();
	    	    		 val.setErrorparameter("model");
	    	    		 val.setErrormessages("Collateral Vehicle = model Harus Diisi");
	    	    		 listreturn.add(val);
	                 }
	        	}else if(jsonpayload.getAppCollateral().getValueC().equals("Deposit")) {
	        		if (jsonpayload.getAppCollateralDeposit().getBankid().equals("0")) {
	        			 val = new ValidationEntity();
	    	    		 val.setErrorparameter("bank");
	    	    		 val.setErrormessages("Collateral Deposit = bank Harus Diisi");
	    	    		 listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralDeposit().getAmount().equals("0") || jsonpayload.getAppCollateralDeposit().getAmount().equals("")) {
	        			 val = new ValidationEntity();
	    	    		 val.setErrorparameter("Amount");
	    	    		 val.setErrormessages("Collateral Deposit = Amount Harus Diisi");
	    	    		 listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralDeposit().getCurrency().equals("")) {
	        			 val = new ValidationEntity();
	    	    		 val.setErrorparameter("currency");
	    	    		 val.setErrormessages("Collateral Deposit = currency Harus Diisi");
	    	    		 listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralDeposit().getAccountnumber().equals("")) {
	        			 val = new ValidationEntity();
	    	    		 val.setErrorparameter("accountnumber");
	    	    		 val.setErrormessages("Collateral Deposit = accountnumber Harus Diisi");
	    	    		 listreturn.add(val);
	                }
	        		if (jsonpayload.getAppCollateralDeposit().getDuedate() == 0|| String.valueOf(jsonpayload.getAppCollateralDeposit().getDuedate()).equals("")) {
	        			 val = new ValidationEntity();
	    	    		 val.setErrorparameter("duedate");
	    	    		 val.setErrormessages("Collateral Deposit = due date Harus Diisi");
	    	    		 listreturn.add(val);
	                }
	        	}
	        }
		   	
		   	if(listreturn.size() > maxMsg) {
		   		List<ValidationEntity> templistreturn = new ArrayList<ValidationEntity>();
		   		templistreturn = listreturn.subList(0, maxMsg);
		   		listreturn = new ArrayList<ValidationEntity>();
		   		listreturn = templistreturn;
		   	}
		return listreturn;
		
        }
}
