package com.ikkat.los.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ikkat.los.entity.LoanProductEntity;
import com.ikkat.los.service.LoanProductService;
import com.ikkat.los.utils.Utils;

public class LoanProductHelper {
	
	public static String insertSyncLoanProductFromSimpool(HashMap<String, Object> mapParam) {
		JSONArray jsonarray = (JSONArray) mapParam.get("jsonarray");
		LoanProductService service = (LoanProductService) mapParam.get("service");
		String value = "";
		List<String> listexternalid = new ArrayList<String>();
		for(int x=0; x < jsonarray.size(); x++) {
			JSONObject item = (JSONObject) jsonarray.get(x);
			Long externalid = (Long) item.get("id");//
			Long repaymentEvery = (Long) item.get("repaymentEvery");
			
			Long economicSector = (Long) item.get("economicSector");
			String economicSectorDetail = (String) item.get("economicSectorDetail");
			Long loanPurposeId = (Long) item.get("loanPurposeId");
			String loanname = (String) item.get("name");
			Double defaultamount = (Double) item.get("principal");
			Double minamount = (Double) item.get("minPrincipal");
			Double maxamount = (Double) item.get("maxPrincipal");
			Long defaulttenor = (Long) item.get("numberOfRepayments");
			Long mintenor = (Long) item.get("minNumberOfRepayments");
			Long maxtenor = (Long) item.get("maxNumberOfRepayments");
			String renewalstatus = (String) item.get("renewalStatus");
			String orientationusage = (String) item.get("orientationUsage");
			String debtorcategory = (String) item.get("debtorCategory");
			String financingcode = (String) item.get("financingCode");
			String traidcode = (String) item.get("traidCode");
			Double interestrateperperiod = (Double) item.get("interestRatePerPeriod");
			
			JSONObject jsoninteresttype = (JSONObject) item.get("interestType");
			Long interesttype = (Long) jsoninteresttype.get("id");
			
			JSONObject jsonamortizationType = (JSONObject) item.get("amortizationType");
			Long amortizationtype = (Long) jsonamortizationType.get("id");
			
			JSONObject jsoninterestCalculationPeriodType = (JSONObject) item.get("interestCalculationPeriodType");
			Long interestcalculationperiodtype = (Long) jsoninterestCalculationPeriodType.get("id");
			
			Long transactionprocessingstrategyid = (Long) item.get("transactionProcessingStrategyId");
			
			
			//repaymentFrequencyType
			JSONObject objrepaymentFrequencyType = (JSONObject) item.get("repaymentFrequencyType");
			Long repaymentFrequencyType = (Long) objrepaymentFrequencyType.get("id");
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("loanPurposeId", loanPurposeId);
			map.put("defaultamount", defaultamount);
			map.put("defaulttenor", defaulttenor);
			map.put("loanname", loanname);
			map.put("minamount", minamount);
			map.put("maxamount", maxamount);
			map.put("maxtenor", maxtenor);
			map.put("mintenor", mintenor);
			map.put("externalid", externalid);
			map.put("renewalstatus", renewalstatus);
			map.put("orientationusage", orientationusage);
			map.put("debtorcategory", debtorcategory);
			map.put("financingcode", financingcode);
			map.put("traidcode", traidcode);
			map.put("interestrateperperiod", interestrateperperiod);
			map.put("interesttype", interesttype);
			map.put("amortizationtype", amortizationtype);
			map.put("interestcalculationperiodtype", interestcalculationperiodtype);
			map.put("transactionprocessingstrategyid", transactionprocessingstrategyid);
			map.put("economicSector", economicSector);
			map.put("economicSectorDetail", economicSectorDetail);
			map.put("repaymentEvery", repaymentEvery);
			map.put("repaymentFrequencyType", repaymentFrequencyType);
			listexternalid.add(String.valueOf(externalid));
			LoanProductEntity loan = service.getLoanProductByexternalid(String.valueOf(externalid));
			if(loan == null) {
				loan = new LoanProductEntity();
				loan = SetEntity(map,1);
				service.create(loan);
			}else {
				Optional<LoanProductEntity> optLoan = service.findById(loan.getLoanProductId());
				if(optLoan.isPresent()) {
					map.put("loan", optLoan.get());
					LoanProductEntity getloan = SetEntity(map, 2);
					service.update(loan.getLoanProductId(), getloan);
				}
			}
		}
		service.updateStatusNotListLoan("N", listexternalid);
		
		return value;
	}
	
	public static LoanProductEntity SetEntity(HashMap<String, Object> map,int type) {
		String id = String.valueOf(Utils.generateNumber());
		double defaultamount = (Double) map.get("defaultamount");
		Long loanPurposeId = (Long) map.get("loanPurposeId");
		Long defaulttenor = (Long) map.get("defaulttenor");
		String loanname = (String) map.get("loanname");
		double minamount = (Double) map.get("minamount");
		double maxamount = (Double) map.get("maxamount");
		Long maxtenor = (Long) map.get("maxtenor");
		Long mintenor = (Long) map.get("mintenor");
		Long externalid = (Long) map.get("externalid");
		String renewalstatus = (String) map.get("renewalstatus");
		String orientationusage = (String) map.get("orientationusage");
		String debtorcategory = (String) map.get("debtorcategory");
		String financingcode = (String) map.get("financingcode");
		String traidcode = (String) map.get("traidcode");
		Double interestrateperperiod = (Double) map.get("interestrateperperiod");
		Long interesttype = (Long) map.get("interesttype");
		Long amortizationtype = (Long) map.get("amortizationtype");
		Long interestcalculationperiodtype = (Long) map.get("interestcalculationperiodtype");
		Long transactionprocessingstrategyid = (Long) map.get("transactionprocessingstrategyid");
		Long economicSector = (Long) map.get("economicSector");
		String economicSectorDetail = (String) map.get("economicSectorDetail");
		Long repaymentEvery = (Long) map.get("repaymentEvery");
		Long repaymentFrequencyType = (Long) map.get("repaymentFrequencyType");
		
		LoanProductEntity entity = new LoanProductEntity();
		if(type == 1) {
			entity.setLoanProductId(id);
			entity.setDefaultamount(defaultamount);
			entity.setDefaulttenor(defaulttenor.intValue());
			entity.setFilterid_h("");
			entity.setHasCollateral(false);
			entity.setLoanDescription("");
			entity.setLoanName(loanname);
			entity.setMaxreject(0);
			entity.setMaxtenor(maxtenor.intValue());
			entity.setMintenor(mintenor.intValue());
			entity.setMinamount(minamount);
			entity.setMaxamount(maxamount);
			entity.setExternalid(externalid.toString());
			entity.setIsactive("Y");
			entity.setRenewalstatus(renewalstatus);
			entity.setOrientationusage(orientationusage);
			entity.setDebtorcategory(debtorcategory);
			entity.setFinancingcode(financingcode);
			entity.setTraidcode(traidcode);
			entity.setInterestrateperperiod(interestrateperperiod.toString());
			entity.setInteresttype(interesttype.toString());
			entity.setAmortizationtype(amortizationtype.toString());
			entity.setInterestcalculationperiodtype(interestcalculationperiodtype.toString());
			entity.setTransactionprocessingstrategyid(transactionprocessingstrategyid.toString());
			entity.setLoanpurposeid(loanPurposeId.toString());
			entity.setEconomisector(economicSector.toString());
			entity.setEconomisectordetail(economicSectorDetail);
			entity.setRepaymentevery(repaymentEvery.toString());
			entity.setRepaymentfrequencytype(repaymentFrequencyType.toString());
		}else if(type == 2) {
			entity = (LoanProductEntity) map.get("loan");
			entity.setDefaultamount(defaultamount);
			entity.setDefaulttenor(defaulttenor.intValue());
			entity.setLoanName(loanname);
			entity.setMaxtenor(maxtenor.intValue());
			entity.setMintenor(mintenor.intValue());
			entity.setMinamount(minamount);
			entity.setMaxamount(maxamount);
			entity.setIsactive("Y");
			entity.setRenewalstatus(renewalstatus);
			entity.setOrientationusage(orientationusage);
			entity.setDebtorcategory(debtorcategory);
			entity.setFinancingcode(financingcode);
			entity.setTraidcode(traidcode);
			entity.setInterestrateperperiod(interestrateperperiod.toString());
			entity.setInteresttype(interesttype.toString());
			entity.setAmortizationtype(amortizationtype.toString());
			entity.setInterestcalculationperiodtype(interestcalculationperiodtype.toString());
			entity.setTransactionprocessingstrategyid(transactionprocessingstrategyid.toString());
			entity.setLoanpurposeid(loanPurposeId.toString());
			entity.setEconomisector(economicSector.toString());
			entity.setEconomisectordetail(economicSectorDetail);
			entity.setRepaymentevery(repaymentEvery.toString());
			entity.setRepaymentfrequencytype(repaymentFrequencyType.toString());
		}
		return entity;
	}
}
