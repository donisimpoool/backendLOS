package com.ikkat.los.jsonmodel;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ikkat.los.entity.ApplicationAddressEntity;
import com.ikkat.los.entity.ApplicationBankEntity;
import com.ikkat.los.entity.ApplicationBusinessEntity;
import com.ikkat.los.entity.ApplicationCollateralDepositEntity;
import com.ikkat.los.entity.ApplicationCollateralEntity;
import com.ikkat.los.entity.ApplicationCollateralRealEstateEntity;
import com.ikkat.los.entity.ApplicationCollateralVehicleEntity;
import com.ikkat.los.entity.ApplicationFamilyEntity;
import com.ikkat.los.entity.ApplicationFinancialEntity;
import com.ikkat.los.entity.ApplicationScoreEntity;
import com.ikkat.los.entity.CustomerEntity;
import com.ikkat.los.entity.LoanapplicationEntity;
import com.ikkat.los.entity.RiskLevelEntity;
import com.ikkat.los.entity.RunningNumberEntity;
import com.ikkat.los.entity.applicationEntity;
import com.ikkat.los.entity.applicationPersonelEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.enumeration.TypeCollateral;
import com.ikkat.los.helper.entity.ParamsRoulesScoreEntity;
import com.ikkat.los.service.ApplicationAddressService;
import com.ikkat.los.service.ApplicationBankService;
import com.ikkat.los.service.ApplicationBusinessService;
import com.ikkat.los.service.ApplicationCollateralDepositService;
import com.ikkat.los.service.ApplicationCollateralRealEstateService;
import com.ikkat.los.service.ApplicationCollateralService;
import com.ikkat.los.service.ApplicationFamilyService;
import com.ikkat.los.service.ApplicationFinancialService;
import com.ikkat.los.service.ApplicationPersonelService;
import com.ikkat.los.service.ApplicationScoreService;
import com.ikkat.los.service.FilterDetailService;
import com.ikkat.los.service.FilterHeaderService;
import com.ikkat.los.service.LoanApplicationService;
import com.ikkat.los.service.RiskLevelService;
import com.ikkat.los.service.RunningNumberService;
import com.ikkat.los.service.applicationService;
import com.ikkat.los.utils.Utils;
import com.ikkat.los.validation.Validation;

public class ApplicationJSON {
	
	private String applicationID;
	private String status;
	private int score;
	private applicationLoanJson appLoan;
	private ApplicationPersonelJson appPersonel;
	private ApplicationAddress1Json appAddress1;
	private ApplicationAddress2Json appAddress2;
	private ApplicationFamilyJson appFamily;
	private ApplicationBusinessJson appBusiness;
	private ApplicationFInancialJson appFinancial;
	private ApplicationBankJson appBank;
	private ApplicationCollateralJson appCollateral;
	private ApplicationCollateralRealEstateJson appCollateralRealEstate;
	private ApplicationCollateralVehicleJson appCollateralVehicle;
	private ApplicationCollateralDepositJson appCollateralDeposit;
	private String isdraft;
	private CreditCardJson creditcard;
	private String createdby;

	public CreditCardJson getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(CreditCardJson creditcard) {
		this.creditcard = creditcard;
	}
	public String getIsdraft() {
		return isdraft;
	}
	public void setIsdraft(String isdraft) {
		this.isdraft = isdraft;
	}
	public ApplicationCollateralDepositJson getAppCollateralDeposit() {
		return appCollateralDeposit;
	}
	public void setAppCollateralDeposit(ApplicationCollateralDepositJson appCollateralDeposit) {
		this.appCollateralDeposit = appCollateralDeposit;
	}
	public ApplicationCollateralVehicleJson getAppCollateralVehicle() {
		return appCollateralVehicle;
	}
	public void setAppCollateralVehicle(ApplicationCollateralVehicleJson appCollateralVehicle) {
		this.appCollateralVehicle = appCollateralVehicle;
	}
	public ApplicationCollateralRealEstateJson getAppCollateralRealEstate() {
		return appCollateralRealEstate;
	}
	public void setAppCollateralRealEstate(ApplicationCollateralRealEstateJson appCollateralRealEstate) {
		this.appCollateralRealEstate = appCollateralRealEstate;
	}
	public ApplicationCollateralJson getAppCollateral() {
		return appCollateral;
	}
	public void setAppCollateral(ApplicationCollateralJson appCollateral) {
		this.appCollateral = appCollateral;
	}
	public ApplicationBankJson getAppBank() {
		return appBank;
	}
	public void setAppBank(ApplicationBankJson appBank) {
		this.appBank = appBank;
	}
	public ApplicationFInancialJson getAppFinancial() {
		return appFinancial;
	}
	public void setAppFinancial(ApplicationFInancialJson appFinancial) {
		this.appFinancial = appFinancial;
	}
	public ApplicationBusinessJson getAppBusiness() {
		return appBusiness;
	}
	public void setAppBusiness(ApplicationBusinessJson appBusiness) {
		this.appBusiness = appBusiness;
	}
	public ApplicationFamilyJson getAppFamily() {
		return appFamily;
	}
	public void setAppFamily(ApplicationFamilyJson appFamily) {
		this.appFamily = appFamily;
	}
	public ApplicationAddress1Json getAppAddress1() {
		return appAddress1;
	}
	public void setAppAddress1(ApplicationAddress1Json appAddress1) {
		this.appAddress1 = appAddress1;
	}
	public ApplicationAddress2Json getAppAddress2() {
		return appAddress2;
	}
	public void setAppAddress2(ApplicationAddress2Json appAddress2) {
		this.appAddress2 = appAddress2;
	}
	public ApplicationPersonelJson getAppPersonel() {
		return appPersonel;
	}
	public void setAppPersonel(ApplicationPersonelJson appPersonel) {
		this.appPersonel = appPersonel;
	}
	public applicationLoanJson getAppLoan() {
		return appLoan;
	}
	public void setAppLoan(applicationLoanJson appLoan) {
		this.appLoan = appLoan;
	}
	public String getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public ApplicationJSON setValueEntity(HashMap<String, Object> hash) {
		ApplicationJSON appJson = new ApplicationJSON();
		
		return appJson;
	}
	
	public HashMap<String, Object> actionupdate(HashMap<String, Object> params) {
		HashMap<String, Object> mapreturn = new HashMap<String, Object>();
		long now = System.currentTimeMillis();
		boolean isupdate = true;
		RunningNumberService runnumberservice = (RunningNumberService) params.get("runnumberservice");
		applicationService appService = (applicationService) params.get("appService");
		ApplicationScoreService appScoreService = (ApplicationScoreService) params.get("appScoreService");
		LoanApplicationService loanApplicationService = (LoanApplicationService) params.get("loanApplicationService");
		ApplicationPersonelService appPersonelService = (ApplicationPersonelService) params.get("appPersonelService");
		ApplicationAddressService appAddressService = (ApplicationAddressService) params.get("appAddressService");
		ApplicationFamilyService appFamilyService = (ApplicationFamilyService) params.get("appFamilyService");
		ApplicationBusinessService appBusinessService = (ApplicationBusinessService) params.get("appBusinessService");
		ApplicationFinancialService appFinancialService = (ApplicationFinancialService) params.get("appFinancialService");
		ApplicationBankService appBankService = (ApplicationBankService) params.get("appBankService");
		ApplicationCollateralService appCollateralService = (ApplicationCollateralService) params.get("appCollateralService");
		ApplicationCollateralRealEstateService appCollateralRealEstateService = (ApplicationCollateralRealEstateService) params.get("appCollateralRealEstateService");
		ApplicationCollateralDepositService appCollateralDepositService = (ApplicationCollateralDepositService) params.get("appCollateralDepositService");
		HashMap<String, Object> mapscore = (HashMap<String, Object>) params.get("mapscore");
		
		String id = this.applicationID;
		if(id.equals("")) {
			isupdate = false;
			HashMap<String, Object> mapcreate = getvalueEntity(runnumberservice);
			mapreturn.put("mapcreate", mapcreate);
		}else {
			Optional<applicationEntity> OptappEntity = appService.findById(id);
			if(OptappEntity.isPresent()) {
				int score = (int) mapscore.get("hasilscore");
				String status = (String) mapscore.get("status");
				String ruleEnginecomments = (String) mapscore.get("ruleEnginecomments");
				RiskLevelEntity risk = (RiskLevelEntity) mapscore.get("risk");
				
				applicationEntity appEntity = OptappEntity.get();
				appEntity.setScore(score);
				appEntity.setStatus(status);
				appEntity.setIsdraft(this.isdraft);
				appEntity.setRisklevelid(risk.getId());
				appEntity.setScorecardcomments("");
				appEntity.setRuleenginecomments(ruleEnginecomments);
				appEntity.setModieddate(Utils.longToZonedDateTime(now));
				appEntity.setDate(new Timestamp(new Date().getTime()));
				appEntity.setIsexport(false);
				appEntity.setCreatedby(this.createdby);
				appService.update(id, appEntity);
			}
			Optional<ApplicationScoreEntity> OptappScore = appScoreService.findById(id);
			if(OptappScore.isPresent()) {
				HashMap<String, Double> detailscore = (HashMap<String, Double>) mapscore.get("detailscore");
				
				ApplicationScoreEntity appScore = OptappScore.get();
				appScore.setPropertypossession(detailscore.get("propertypossession").intValue());
				appScore.setNumberofdependant(detailscore.get("numberofdependant").intValue());
				appScore.setGender(detailscore.get("gender").intValue());
				appScore.setLocation(detailscore.get("location").intValue());
				appScore.setLiveownershipstatus(detailscore.get("liveownershipstatus").intValue());
				appScore.setVehicleowner(detailscore.get("vehicleowner").intValue());
				appScore.setMaritalstatus(detailscore.get("maritalstatus").intValue());
				appScore.setCompanysize(detailscore.get("companysize").intValue());
				appScore.setCreditcardowner(detailscore.get("creditcardowner").intValue());
				appScore.setDebtincomeratio(detailscore.get("debtincomeratio").intValue());
				appScore.setIndustrysector(detailscore.get("industrysector").intValue());
				appScore.setEducation(detailscore.get("education").intValue());
				appScore.setIncometype(detailscore.get("incometype").intValue());
				appScore.setAge(detailscore.get("age").intValue());
				appScore.setDurationwork(detailscore.get("durationwork").intValue());
				appScore.setJobtittle(detailscore.get("jobtittle").intValue());
				appScore.setPosition(detailscore.get("position").intValue());
				appScoreService.update(id, appScore);
			}
			
			Optional<LoanapplicationEntity> OptappLoan = loanApplicationService.findById(id);
			if(OptappLoan.isPresent()) {
				LoanapplicationEntity appLoanEntity = OptappLoan.get();
				appLoanEntity.setLoanproductID(this.appLoan.getLoanproductID());
				appLoanEntity.setPurposeofloan(this.appLoan.getPurposeofloan());
				appLoanEntity.setTenor(this.appLoan.getTenor());
				appLoanEntity.setAmount(new Double(this.appLoan.getLoanAmount()));
				loanApplicationService.update(id, appLoanEntity);
			}
			
			Optional<applicationPersonelEntity> OptappPersonel = appPersonelService.findById(id);
			if(OptappPersonel.isPresent()) {
				applicationPersonelEntity appPersonelEntity = OptappPersonel.get();
				appPersonelEntity.setDateofbirth(Utils.longToZonedDateTime(this.appPersonel.getDateofbirth()));
				appPersonelEntity.setEducation(this.appPersonel.getEducation());
				appPersonelEntity.setEmail(this.appPersonel.getEmail());
				appPersonelEntity.setGender(this.appPersonel.getGender());
				appPersonelEntity.setLandlinephone(this.appPersonel.getLandlinephone());
				appPersonelEntity.setMaritalstatus(this.appPersonel.getMaritalstatus());
				appPersonelEntity.setMobilephone(this.appPersonel.getMobilephone());
				appPersonelEntity.setName(this.appPersonel.getFullname());
				appPersonelEntity.setPlaceofbirth(this.appPersonel.getPlaceofbirth());
				appPersonelEntity.setTypeid(this.appPersonel.getIdtype());
				appPersonelEntity.setIdnumber(this.appPersonel.getIdnumber());
				appPersonelEntity.setNumberofdependant(this.appPersonel.getNumberofdependant());
				appPersonelEntity.setReligionid(this.appPersonel.getReligionid());
				appPersonelEntity.setTaxnumber(this.appPersonel.getTaxnumber());
				appPersonelService.update(id, appPersonelEntity);
			}
			Optional<ApplicationAddressEntity> OptappAddress = appAddressService.findById(id);
			if(OptappAddress.isPresent()) {
				ApplicationAddressEntity appAddressEntity = OptappAddress.get();
				appAddressEntity.setMainaddress(this.appAddress1.getMainaddress());
				appAddressEntity.setProvinceid(this.appAddress1.getProvince());
				appAddressEntity.setPostalcode(this.appAddress1.getPostalcode());
				appAddressEntity.setOwnershipstatus(this.appAddress1.getOwnershipstatus());
				appAddressEntity.setUsedforcollateral(this.appAddress1.getOwnershipstatus());
				appAddressEntity.setLiveinaddress(this.appAddress1.getLivedinyears());
				appAddressEntity.setIdregencies(this.appAddress1.getIdregencies());
				appAddressEntity.setIddistrict(this.appAddress1.getIddistrict());
				appAddressEntity.setLocation(this.appAddress1.getLocation());
				appAddressEntity.setRt(this.appAddress1.getRt());
				appAddressEntity.setRw(this.appAddress1.getRw());
				appAddressEntity.setVillagesid(this.appAddress1.getIdvillage());
				
				appAddressEntity.setSecondaddress(this.appAddress2.getMainaddress());
				appAddressEntity.setSecondprovinceid(this.appAddress2.getProvince());
				appAddressEntity.setSecondpostalcode(this.appAddress2.getPostalcode());
				appAddressEntity.setSecondownershipstatus(this.appAddress2.getOwnershipstatus());
				appAddressEntity.setSecondusedforcollateral(this.appAddress2.getCollateral());
				appAddressEntity.setSecondidregencies(this.appAddress2.getIdregencies());
				appAddressEntity.setSecondiddistrict(this.appAddress2.getIddistrict());
				appAddressService.update(id, appAddressEntity);
			}
			
			Optional<ApplicationFamilyEntity> OptFamily = appFamilyService.findById(id);
			if(OptFamily.isPresent()) {
				ApplicationFamilyEntity appFamilyEntity = OptFamily.get();
				appFamilyEntity.setContactemergency(this.appFamily.getEmergencycontact());
				appFamilyEntity.setAddressemergencycontact(this.appFamily.getAddressemergencycontact());
				appFamilyEntity.setMobileemergency(this.appFamily.getMobilephoneemergencycontact());
				appFamilyEntity.setMothername(this.appFamily.getMothername());
				appFamilyService.update(id,appFamilyEntity);
			}
			
			Optional<ApplicationBusinessEntity> OptBusinees = appBusinessService.findById(id);
			if(OptBusinees.isPresent()) {
				ApplicationBusinessEntity appBusinessEntity = OptBusinees.get();
				appBusinessEntity.setCompanyname(this.appBusiness.getCompanyname());
				appBusinessEntity.setCompanyaddress(this.appBusiness.getCompanyaddress());
				appBusinessEntity.setProvinceid(this.appBusiness.getProvince());
				appBusinessEntity.setDivision(this.appBusiness.getDivision());
				appBusinessEntity.setPosition(this.appBusiness.getPosition());
				appBusinessEntity.setDuration(new Integer(this.appBusiness.getDuration()).intValue());
				appBusinessEntity.setNumberofemployees(new Integer(this.appBusiness.getTotalnumberemp()).intValue());
				appBusinessEntity.setBusinessline(this.appBusiness.getBusinessline());
				appBusinessEntity.setIdregencies(this.appBusiness.getIdregencies());
				appBusinessEntity.setIddistrict(this.appBusiness.getIddistrict());
				appBusinessService.update(id, appBusinessEntity);
			}
			
			Optional<ApplicationFinancialEntity> OptFinancial = appFinancialService.findById(id);
			if(OptFinancial.isPresent()) {
				ApplicationFinancialEntity appFinancialEntity = OptFinancial.get();
				appFinancialEntity.setTypeincome(this.appFinancial.getTypeincome());
				appFinancialEntity.setMainincome(new Double(this.appFinancial.getMainincome()));
				appFinancialEntity.setSideincome(new Double(this.appFinancial.getSideincome()));
				appFinancialEntity.setExpense(new Double(this.appFinancial.getExpense()));
				appFinancialEntity.setAdditionalexpense(new Double(this.appFinancial.getAddtionalexpense()));
				appFinancialEntity.setVehicleowner(this.appFinancial.getVehicleowner());
				appFinancialEntity.setTypevehicle(this.appFinancial.getTypevehicle());
				appFinancialService.update(id, appFinancialEntity);
			}
			
			Optional<ApplicationBankEntity> OptBank = appBankService.findById(id);
			if(OptBank.isPresent()) {
				ApplicationBankEntity appBankEntity = OptBank.get();
				appBankEntity.setBankid(this.appBank.getBank());
				appBankEntity.setAccounttype(this.appBank.getAcctype());
				appBankEntity.setAccountnumber(this.appBank.getAccnumber());
				appBankEntity.setIscreditcard(this.appBank.getIscc());
				appBankEntity.setBankcc(this.creditcard.getIssuerid());
				appBankEntity.setNumbercc(this.creditcard.getNumbercreditcard());
				appBankEntity.setTypecredittcard(this.creditcard.getTypecredittcard());
				appBankService.update(id,appBankEntity);
			}
			
			Optional<ApplicationCollateralEntity> OptCollateral = appCollateralService.findById(id);
			if(OptCollateral.isPresent()) {
				ApplicationCollateralEntity appCollateralEntity = OptCollateral.get();
				appCollateralEntity.setCollateral(this.appCollateral.getValueC());
				appCollateralService.update(id, appCollateralEntity);
			}
			
			boolean isrealestate = Validation.checkCollateral(TypeCollateral.REALESTATE.value(),
					this.getAppCollateral().getValueC());
			boolean isvehicle = Validation.checkCollateral(TypeCollateral.VEHICLE.value(),
					this.getAppCollateral().getValueC());
			boolean isdeposit = Validation.checkCollateral(TypeCollateral.DEPOSIT.value(),
					this.getAppCollateral().getValueC());
			
			Optional<ApplicationCollateralRealEstateEntity> OptCollateralRE = appCollateralRealEstateService.findById(id);
			if(OptCollateralRE.isPresent()) {
				appCollateralRealEstateService.delete(id);
				if(isrealestate) {
					ApplicationCollateralRealEstateEntity appCollateralRealEstateEntity =  new ApplicationCollateralRealEstateEntity();
					appCollateralRealEstateEntity.setApplicationid(id);
					appCollateralRealEstateEntity.setAddress(this.appCollateralRealEstate.getAddress());
					appCollateralRealEstateEntity.setCondition(this.appCollateralRealEstate.getCondition());
					appCollateralRealEstateEntity.setDistrictid(this.appCollateralRealEstate.getDistrictid());
					appCollateralRealEstateEntity.setProofofownership(this.appCollateralRealEstate.getProofofownership());
					appCollateralRealEstateEntity.setProvinceid(this.appCollateralRealEstate.getProvinceid());
					appCollateralRealEstateEntity.setRegenciesid(this.appCollateralRealEstate.getRegenciesid());
					appCollateralRealEstateEntity.setRooms(new Integer(this.appCollateralRealEstate.getRooms()));
					appCollateralRealEstateEntity.setSize(this.appCollateralRealEstate.getSize());
					appCollateralRealEstateEntity.setTyperealestate(this.appCollateralRealEstate.getTyperealestate());
					appCollateralRealEstateEntity.setYear(new Integer(this.appCollateralRealEstate.getYear()));
					appCollateralRealEstateService.create(appCollateralRealEstateEntity);
				}
			}
			Optional<ApplicationCollateralVehicleEntity> OptCollateralVehicle = appCollateralService.findCollateralVehicleById(id);
			if(OptCollateralVehicle.isPresent()) {
				appCollateralService.deleteCollateralVehicle(id);
				if(isvehicle) {
					ApplicationCollateralVehicleEntity appCollateralVehicleEntity = new ApplicationCollateralVehicleEntity();
					appCollateralVehicleEntity.setApplicationid(id);
					appCollateralVehicleEntity.setBrand(this.appCollateralVehicle.getBrand());
					appCollateralVehicleEntity.setMileage(this.appCollateralVehicle.getMileage());
					appCollateralVehicleEntity.setTypetransmision(this.appCollateralVehicle.getTypetransmision());
					appCollateralVehicleEntity.setTypevehicle(this.appCollateralVehicle.getTypevehicle());
					appCollateralVehicleEntity.setYear(this.appCollateralVehicle.getYear());
					appCollateralVehicleEntity.setModel(this.appCollateralVehicle.getModel());
					appCollateralService.createCollateralVehicle(appCollateralVehicleEntity);
				}
			}
			
			Optional<ApplicationCollateralDepositEntity> OptCollateralDeposit = appCollateralDepositService.findById(id);
			if(OptCollateralDeposit.isPresent()) {
				appCollateralDepositService.delete(id);
				if(isdeposit) {
					ApplicationCollateralDepositEntity appCollateralDepositEntity = new ApplicationCollateralDepositEntity();
					appCollateralDepositEntity.setApplicationid(id);
					appCollateralDepositEntity.setAccountnumber(this.appCollateralDeposit.getAccountnumber());
					appCollateralDepositEntity.setAmount(new Double(appCollateralDeposit.getAmount()));
					appCollateralDepositEntity.setBankid(this.appCollateralDeposit.getBankid());
					appCollateralDepositEntity.setCurrency(this.appCollateralDeposit.getCurrency());
					appCollateralDepositEntity.setDuedate(Utils.longToZonedDateTime(this.appCollateralDeposit.getDuedate()));
					appCollateralDepositService.create(appCollateralDepositEntity);
				}
			}
			
			
		}
		mapreturn.put("appid", id);
		mapreturn.put("isupdate", isupdate);
		return mapreturn;
	}
	
	public HashMap<String, Object> getvalueEntity(RunningNumberService service){
		long now = System.currentTimeMillis();
		String appID = "";
		if(this.applicationID.equals("")) {
			long number = Utils.GetRunningNumber(service, "application");
			appID = Utils.RunningNumber(number);
		}else {
			appID = this.applicationID;
		}
		
		HashMap<String, Object> val = new HashMap<>();
		applicationEntity appEntity = new applicationEntity();
		appEntity.setApplicationID(appID);
		appEntity.setScore(this.score);
		appEntity.setStatus(this.status);
		appEntity.setCreateddate(Utils.longToZonedDateTime(now));
		appEntity.setModieddate(Utils.longToZonedDateTime(now));
		appEntity.setDate(new Timestamp(new Date().getTime()));
		appEntity.setIsexport(false);
		appEntity.setCreatedby(this.createdby);
		
		LoanapplicationEntity appLoanEntity = new LoanapplicationEntity();
		appLoanEntity.setApplicationID(appID);
		appLoanEntity.setLoanproductID(this.appLoan.getLoanproductID());
		appLoanEntity.setPurposeofloan(this.appLoan.getPurposeofloan());
		appLoanEntity.setTenor(this.appLoan.getTenor());
		appLoanEntity.setAmount(new Double(this.appLoan.getLoanAmount()));
		
		applicationPersonelEntity appPersonelEntity = new applicationPersonelEntity();
		appPersonelEntity.setApplicationID(appID);
		appPersonelEntity.setDateofbirth(Utils.longToZonedDateTime(this.appPersonel.getDateofbirth()));
		appPersonelEntity.setEducation(this.appPersonel.getEducation());
		appPersonelEntity.setEmail(this.appPersonel.getEmail());
		appPersonelEntity.setGender(this.appPersonel.getGender());
		appPersonelEntity.setLandlinephone(this.appPersonel.getLandlinephone());
		appPersonelEntity.setMaritalstatus(this.appPersonel.getMaritalstatus());
		appPersonelEntity.setMobilephone(this.appPersonel.getMobilephone());
		appPersonelEntity.setName(this.appPersonel.getFullname());
		appPersonelEntity.setPlaceofbirth(this.appPersonel.getPlaceofbirth());
		appPersonelEntity.setTypeid(this.appPersonel.getIdtype());
		appPersonelEntity.setIdnumber(this.appPersonel.getIdnumber());
		appPersonelEntity.setNumberofdependant(this.appPersonel.getNumberofdependant());
		appPersonelEntity.setReligionid(this.appPersonel.getReligionid());
		appPersonelEntity.setTaxnumber(this.appPersonel.getTaxnumber());
		
		ApplicationAddressEntity appAddressEntity = new ApplicationAddressEntity();
		appAddressEntity.setApplicationid(appID);
		appAddressEntity.setMainaddress(this.appAddress1.getMainaddress());
		appAddressEntity.setProvinceid(this.appAddress1.getProvince());
		appAddressEntity.setPostalcode(this.appAddress1.getPostalcode());
		appAddressEntity.setOwnershipstatus(this.appAddress1.getOwnershipstatus());
		appAddressEntity.setUsedforcollateral(this.appAddress1.getOwnershipstatus());
		appAddressEntity.setLiveinaddress(this.appAddress1.getLivedinyears());
		appAddressEntity.setIdregencies(this.appAddress1.getIdregencies());
		appAddressEntity.setIddistrict(this.appAddress1.getIddistrict());
		appAddressEntity.setLocation(this.appAddress1.getLocation());
		appAddressEntity.setRt(this.appAddress1.getRt());
		appAddressEntity.setRw(this.appAddress1.getRw());
		appAddressEntity.setVillagesid(this.appAddress1.getIdvillage());
		
		appAddressEntity.setSecondaddress(this.appAddress2.getMainaddress());
		appAddressEntity.setSecondprovinceid(this.appAddress2.getProvince());
		appAddressEntity.setSecondpostalcode(this.appAddress2.getPostalcode());
		appAddressEntity.setSecondownershipstatus(this.appAddress2.getOwnershipstatus());
		appAddressEntity.setSecondusedforcollateral(this.appAddress2.getCollateral());
		appAddressEntity.setSecondidregencies(this.appAddress2.getIdregencies());
		appAddressEntity.setSecondiddistrict(this.appAddress2.getIddistrict());
		
		ApplicationFamilyEntity appFamilyEntity = new ApplicationFamilyEntity();
		appFamilyEntity.setApplicationid(appID);
		appFamilyEntity.setContactemergency(this.appFamily.getEmergencycontact());
		appFamilyEntity.setAddressemergencycontact(this.appFamily.getAddressemergencycontact());
		appFamilyEntity.setMobileemergency(this.appFamily.getMobilephoneemergencycontact());
		appFamilyEntity.setMothername(this.appFamily.getMothername());
		
		ApplicationBusinessEntity appBusinessEntity = new ApplicationBusinessEntity();
		appBusinessEntity.setApplicationid(appID);
		appBusinessEntity.setCompanyname(this.appBusiness.getCompanyname());
		appBusinessEntity.setCompanyaddress(this.appBusiness.getCompanyaddress());
		appBusinessEntity.setProvinceid(this.appBusiness.getProvince());
		appBusinessEntity.setDivision(this.appBusiness.getDivision());
		appBusinessEntity.setPosition(this.appBusiness.getPosition());
		appBusinessEntity.setDuration(new Integer(this.appBusiness.getDuration()).intValue());
		appBusinessEntity.setNumberofemployees(new Integer(this.appBusiness.getTotalnumberemp()).intValue());
		appBusinessEntity.setBusinessline(this.appBusiness.getBusinessline());
		appBusinessEntity.setIdregencies(this.appBusiness.getIdregencies());
		appBusinessEntity.setIddistrict(this.appBusiness.getIddistrict());
		
		ApplicationFinancialEntity appFinancialEntity = new ApplicationFinancialEntity();
		appFinancialEntity.setApplicationid(appID);
		appFinancialEntity.setTypeincome(this.appFinancial.getTypeincome());
		appFinancialEntity.setMainincome(new Double(this.appFinancial.getMainincome()));
		appFinancialEntity.setSideincome(new Double(this.appFinancial.getSideincome()));
		appFinancialEntity.setExpense(new Double(this.appFinancial.getExpense()));
		appFinancialEntity.setAdditionalexpense(new Double(this.appFinancial.getAddtionalexpense()));
		appFinancialEntity.setVehicleowner(this.appFinancial.getVehicleowner());
		appFinancialEntity.setTypevehicle(this.appFinancial.getTypevehicle());
		
		ApplicationBankEntity appBankEntity = new ApplicationBankEntity();
		appBankEntity.setApplicationid(appID);
		appBankEntity.setBankid(this.appBank.getBank());
		appBankEntity.setAccounttype(this.appBank.getAcctype());
		appBankEntity.setAccountnumber(this.appBank.getAccnumber());
		appBankEntity.setIscreditcard(this.appBank.getIscc());
		appBankEntity.setBankcc(this.creditcard.getIssuerid());
		appBankEntity.setNumbercc(this.creditcard.getNumbercreditcard());
		appBankEntity.setTypecredittcard(this.creditcard.getTypecredittcard());
		
		ApplicationCollateralEntity appCollateralEntity = new ApplicationCollateralEntity();
		appCollateralEntity.setApplicationid(appID);
		appCollateralEntity.setCollateral(this.appCollateral.getValueC());
		
		ApplicationCollateralRealEstateEntity appCollateralRealEstateEntity =  new ApplicationCollateralRealEstateEntity();
		appCollateralRealEstateEntity.setApplicationid(appID);
		appCollateralRealEstateEntity.setAddress(this.appCollateralRealEstate.getAddress());
		appCollateralRealEstateEntity.setCondition(this.appCollateralRealEstate.getCondition());
		appCollateralRealEstateEntity.setDistrictid(this.appCollateralRealEstate.getDistrictid());
		appCollateralRealEstateEntity.setProofofownership(this.appCollateralRealEstate.getProofofownership());
		appCollateralRealEstateEntity.setProvinceid(this.appCollateralRealEstate.getProvinceid());
		appCollateralRealEstateEntity.setRegenciesid(this.appCollateralRealEstate.getRegenciesid());
		appCollateralRealEstateEntity.setRooms(new Integer(this.appCollateralRealEstate.getRooms()));
		appCollateralRealEstateEntity.setSize(this.appCollateralRealEstate.getSize());
		appCollateralRealEstateEntity.setTyperealestate(this.appCollateralRealEstate.getTyperealestate());
		appCollateralRealEstateEntity.setYear(new Integer(this.appCollateralRealEstate.getYear()));
		
		ApplicationCollateralVehicleEntity appCollateralVehicleEntity = new ApplicationCollateralVehicleEntity();
		appCollateralVehicleEntity.setApplicationid(appID);
		appCollateralVehicleEntity.setBrand(this.appCollateralVehicle.getBrand());
		appCollateralVehicleEntity.setMileage(this.appCollateralVehicle.getMileage());
		appCollateralVehicleEntity.setTypetransmision(this.appCollateralVehicle.getTypetransmision());
		appCollateralVehicleEntity.setTypevehicle(this.appCollateralVehicle.getTypevehicle());
		appCollateralVehicleEntity.setYear(this.appCollateralVehicle.getYear());
		appCollateralVehicleEntity.setModel(this.appCollateralVehicle.getModel());
		
		ApplicationCollateralDepositEntity appCollateralDepositEntity = new ApplicationCollateralDepositEntity();
		appCollateralDepositEntity.setApplicationid(appID);
		appCollateralDepositEntity.setAccountnumber(this.appCollateralDeposit.getAccountnumber());
		appCollateralDepositEntity.setAmount(new Double(appCollateralDeposit.getAmount()));
		appCollateralDepositEntity.setBankid(this.appCollateralDeposit.getBankid());
		appCollateralDepositEntity.setCurrency(this.appCollateralDeposit.getCurrency());
		appCollateralDepositEntity.setDuedate(Utils.longToZonedDateTime(this.appCollateralDeposit.getDuedate()));
		
		val.put("appEntity", appEntity);
		val.put("appLoanEntity", appLoanEntity);
		val.put("appPersonelEntity", appPersonelEntity);
		val.put("appAddressEntity", appAddressEntity);
		val.put("appFamilyEntity", appFamilyEntity);
		val.put("appBusinessEntity", appBusinessEntity);
		val.put("appFinancialEntity", appFinancialEntity);
		val.put("appBankEntity", appBankEntity);
		val.put("appCollateralEntity", appCollateralEntity);
		val.put("appCollateralRealEstateEntity", appCollateralRealEstateEntity);
		val.put("appCollateralVehicleEntity", appCollateralVehicleEntity);
		val.put("appCollateralDepositEntity", appCollateralDepositEntity);
		return val;
	}
	@Override
	public String toString() {
		return "ApplicationJSON [applicationID=" + applicationID + ", status=" + status + ", score=" + score
				+ ", appLoan=" + appLoan + ", appPersonel=" + appPersonel + "]";
	}
	
}
