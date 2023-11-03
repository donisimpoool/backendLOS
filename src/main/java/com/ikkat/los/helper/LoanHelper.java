package com.ikkat.los.helper;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.json.simple.parser.ParseException;
import org.springframework.boot.web.client.RestTemplateBuilder;

import com.google.gson.Gson;
import com.ikkat.los.entity.CustomerEntity;
import com.ikkat.los.entity.applicationEntity;
import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.jsonmodel.ApplicationJSON;
import com.ikkat.los.service.CustomerService;
import com.ikkat.los.service.ParamaterService;
import com.ikkat.los.service.UrlService;
import com.ikkat.los.service.applicationService;
import com.ikkat.los.utils.Utils;

public class LoanHelper {
		
	public static String setJsonLoan(HashMap<String, Object> param) throws ParseException, IOException {
		String value = "";
		String appid = (String) param.get("appid");
		applicationService appService = (applicationService) param.get("appService");
		CustomerService custservice = (CustomerService) param.get("custservice");
		UrlService urlservice = (UrlService) param.get("urlservice");
		ParamaterService paramservice = (ParamaterService) param.get("paramservice");
		Optional<applicationEntity> optappLoan = appService.findById(appid);
		if(optappLoan.isPresent()) {
			HashMap<String, Object> mapparam = new HashMap<String, Object>();
			mapparam.put("appLoan", optappLoan.get());
			mapparam.put("custservice", custservice);
			mapparam.put("urlservice", urlservice);
			mapparam.put("paramservice", paramservice);
			Gson gson = new Gson();
			value = gson.toJson(setMapReturn(mapparam));
		}
		return value;
	}
	
	private static HashMap<String, Object> setMapReturn(HashMap<String, Object> mapparam) throws ParseException, IOException{
		HashMap<String, Object> returnmap = new HashMap<String, Object>();
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatEnum.FORMAT_DD_MM_YYYY.value());
		
		UrlService urlservice = (UrlService) mapparam.get("urlservice");
		CustomerService custservice = (CustomerService) mapparam.get("custservice");
		applicationEntity appLoan = (applicationEntity) mapparam.get("appLoan");
		ParamaterService paramservice = (ParamaterService) mapparam.get("paramservice");
		
		String fullname = appLoan.getPersonelapp().getName().replaceAll(" ", "+").toLowerCase();
		String strdate = appLoan.getPersonelapp().getDateofbirth().getYear()+"-"+appLoan.getPersonelapp().getDateofbirth().getMonthValue()+"-"+appLoan.getPersonelapp().getDateofbirth().getDayOfMonth();
		Timestamp tsdate = Utils.stringToTimestamp(strdate, DateFormatEnum.FORMAT_DATE.value());
		Date dateofbirth = new Date(tsdate.getTime());
		CustomerEntity custentity = custservice.getcustomerbyFieldPriority(fullname, appLoan.getPersonelapp().getIdnumber(), dateofbirth);
		String clientid = "";
		boolean flagsend = false;
		if(custentity != null) {
			clientid = custentity.getCif_id();
			if(clientid.equals("")) {
				flagsend = true;
			}
		}else {
			flagsend = true;
		}
		if(flagsend) {
			HashMap<String, Object> mapParamSendCust = new HashMap<String, Object>();
			mapParamSendCust.put("urlService", urlservice);
			mapParamSendCust.put("appjson", appLoan);		
			mapParamSendCust.put("paramservice", paramservice);
			HashMap<String, Object> mapsendcust = CustomerHelper.sendCustomerToSimpool(mapParamSendCust);
			clientid = (String) mapsendcust.get("cfid");
			if(custentity != null) {
				Optional<CustomerEntity> optCust = custservice.findById(custentity.getCustomerid());
				if(optCust.isPresent()) {
					CustomerEntity cust = optCust.get();
					cust.setCif_id(clientid);
					custservice.update(custentity.getCustomerid(), cust);
				}
			}
		}
		
		int loanTermFrequency = appLoan.getLoanapp().getLoanproduct().getDefaulttenor();//new Integer(appLoan.getLoanapp().getLoanproduct().getRepaymentevery()).intValue()+1;
		returnmap.put("loanType", "individual");
		returnmap.put("clientId", clientid);
		returnmap.put("productId", appLoan.getLoanapp().getLoanproduct().getExternalid());
		returnmap.put("loanPurposeId", appLoan.getLoanapp().getLoanproduct().getLoanpurposeid());
		returnmap.put("renewalStatus", appLoan.getLoanapp().getLoanproduct().getRenewalstatus());
		returnmap.put("orientationUsage", appLoan.getLoanapp().getLoanproduct().getOrientationusage());
		returnmap.put("expectedDisbursementDate", dateFormat.format(appLoan.getDate().getTime()));
		returnmap.put("submittedOnDate", dateFormat.format(appLoan.getDate().getTime()));
		returnmap.put("isTakeOver", false);
		returnmap.put("economicSector", appLoan.getLoanapp().getLoanproduct().getEconomisector());
		returnmap.put("economicSectorDetail", appLoan.getLoanapp().getLoanproduct().getEconomisectordetail());
		returnmap.put("debtorCategory", appLoan.getLoanapp().getLoanproduct().getDebtorcategory());
		returnmap.put("projectProvinceCode", appLoan.getAddressapp().getProvincemain().getId_simpool());
		returnmap.put("projectCityCode", appLoan.getAddressapp().getRegenciesmain().getId_simpool());
		returnmap.put("financingCode", appLoan.getLoanapp().getLoanproduct().getFinancingcode());
		returnmap.put("traidCode", appLoan.getLoanapp().getLoanproduct().getTraidcode());
		returnmap.put("principal", new Double(appLoan.getLoanapp().getAmount()).doubleValue());
		returnmap.put("loanTermFrequency", String.valueOf(loanTermFrequency)); // ambil dr mana?
		returnmap.put("loanTermFrequencyType", appLoan.getLoanapp().getLoanproduct().getRepaymentfrequencytype());// ambil dr mana?
		returnmap.put("repaymentEvery", appLoan.getLoanapp().getLoanproduct().getRepaymentevery());
		returnmap.put("repaymentFrequencyType", appLoan.getLoanapp().getLoanproduct().getRepaymentfrequencytype());
		returnmap.put("numberOfRepayments", appLoan.getLoanapp().getTenor());
		returnmap.put("interestRatePerPeriod", new Double(appLoan.getLoanapp().getLoanproduct().getInterestrateperperiod()).intValue());
		returnmap.put("interestType", appLoan.getLoanapp().getLoanproduct().getInteresttype());
		returnmap.put("amortizationType", appLoan.getLoanapp().getLoanproduct().getAmortizationtype());
		returnmap.put("interestCalculationPeriodType", appLoan.getLoanapp().getLoanproduct().getInterestcalculationperiodtype());
		returnmap.put("allowPartialPeriodInterestCalcualtion", false);
		returnmap.put("inArrearsTolerance", "0");
		returnmap.put("graceOnInterestCharged", "0");
		returnmap.put("transactionProcessingStrategyId", appLoan.getLoanapp().getLoanproduct().getTransactionprocessingstrategyid());
		returnmap.put("graceOnPrincipalPayment", "0");
		returnmap.put("graceOnInterestPayment", "0");
		returnmap.put("charges", new ArrayList<Object>());
		returnmap.put("dateFormat", DateFormatEnum.FORMAT_DD_MM_YYYY.value());
		returnmap.put("locale", "in");
		returnmap.put("groupId", "");
		returnmap.put("externalAccountNumber", "");
		returnmap.put("currency", "IDR");
		returnmap.put("enableCollateralCoverage", false);
		returnmap.put("debtorType", "");
		returnmap.put("sinkingFund", "");
		return returnmap;
	}
}
