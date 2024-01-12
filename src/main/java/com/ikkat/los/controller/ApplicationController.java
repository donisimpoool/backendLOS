package com.ikkat.los.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
import com.ikkat.los.entity.DistrictEntity;
import com.ikkat.los.entity.ListDocumentEntity;
import com.ikkat.los.entity.LoanProductEntity;
import com.ikkat.los.entity.LoanapplicationEntity;
import com.ikkat.los.entity.LogEntity;
import com.ikkat.los.entity.ProvinceEntity;
import com.ikkat.los.entity.RegenciesEntity;
import com.ikkat.los.entity.RiskLevelEntity;
import com.ikkat.los.entity.RunningNumberEntity;
import com.ikkat.los.entity.applicationEntity;
import com.ikkat.los.entity.applicationPersonelEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreMaxEntity;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.enumeration.TypeCollateral;
import com.ikkat.los.helper.entity.ParamsRoulesScoreEntity;
import com.ikkat.los.helper.entity.ValidationEntity;
import com.ikkat.los.jsonmodel.ApplicationDocumentJson;
import com.ikkat.los.jsonmodel.ApplicationEntityJson;
import com.ikkat.los.jsonmodel.ApplicationJSON;
import com.ikkat.los.jsonmodel.ViewApplicationJson;
import com.ikkat.los.repo.ListDocumentRepo;
import com.ikkat.los.response.Response;
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
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.CustomerService;
import com.ikkat.los.service.DistrictService;
import com.ikkat.los.service.FilterDetailService;
import com.ikkat.los.service.FilterHeaderService;
import com.ikkat.los.service.LoanApplicationService;
import com.ikkat.los.service.LoanProductService;
import com.ikkat.los.service.LogService;
import com.ikkat.los.service.ProvinceService;
import com.ikkat.los.service.RegenciesService;
import com.ikkat.los.service.RiskLevelService;
import com.ikkat.los.service.RoulesScoreService;
import com.ikkat.los.service.RunningNumberService;
//import com.ikkat.los.service.UserService;
import com.ikkat.los.service.applicationService;
import com.ikkat.los.utils.CalculateScore;
import com.ikkat.los.utils.Utils;
import com.ikkat.los.validation.Validation;
import com.ikkat.los.validation.ValidationLoanApp;

@RestController
@RequestMapping("/loan/application/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class ApplicationController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	LoanApplicationService loanApplicationService;
	@Autowired
	applicationService appService;
	@Autowired
	ApplicationPersonelService appPersonelService;
	@Autowired
	ApplicationAddressService appAddressService;
	@Autowired
	ApplicationFamilyService appFamilyService;
	@Autowired
	ApplicationBusinessService appBusinessService;
	@Autowired
	ApplicationFinancialService appFinancialService;
	@Autowired
	ApplicationBankService appBankService;
	@Autowired
	ApplicationCollateralService appCollateralService;
	@Autowired
	ApplicationCollateralRealEstateService appCollateralRealEstateService;
	@Autowired
	ApplicationCollateralDepositService appCollateralDepositService;
	@Autowired
	LoanProductService loanproductservice;
	@Autowired
	ProvinceService ProvinceService;
	@Autowired
	RegenciesService RegenciesService;
	@Autowired
	DistrictService DistrictService;
	@Autowired
	RoulesScoreService RoulesScoreService;
	@Autowired
	RiskLevelService RiskLevelService;
	@Autowired
	FilterHeaderService headerservice;
	@Autowired
	FilterDetailService detailservice;
	@Autowired
	ListDocumentRepo repoListDoc;
	@Autowired
	RunningNumberService service;
	@Autowired
	ApplicationScoreService appScoreService;
	@Autowired
	CustomerService custservice;
	@Autowired
	LogService logservice;
//	@Autowired
//	UserService userservice;
	@Autowired
	CompanyService compservice;
	
	
	static HttpServletRequest request;
	@Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

	
	@PostMapping("/create")
	ResponseEntity<Response> create(@RequestBody @Validated ApplicationJSON jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		/* Memanggil Class Response yang telah dibuat */
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.CREATE.value());
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("create : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		String appid = createfunc(jsonPayload);
		
		try {
			LogEntity log = new LogEntity();
			log.setAction("CREATE");
			log.setDate(new Timestamp(new Date().getTime()));
			log.setDescription("Create Draft Application Loan = "+appid);
			log.setIp(Utils.getClientIp(request));
			log.setUserid(jsonPayload.getCreatedby());
			logservice.create(log);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		
		HashMap<String, Object> mapdata = new HashMap<String, Object>();
		mapdata.put("applicationid", appid);
		response.setData(mapdata);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/update")
	ResponseEntity<Response> update(@RequestBody @Validated ApplicationJSON jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("update : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		response.setMessage(MessageEnum.CREATE.value());
		List<ValidationEntity> listvalidation = ValidationLoanApp.validationLoanApp(jsonPayload);
		LOGGER.info("listvalidation.size() : "+listvalidation.size());
		if(listvalidation.size() == 0) {
			response.setValidation("");
			ParamsRoulesScoreEntity parmsroulesScore = new ParamsRoulesScoreEntity();
			parmsroulesScore = parmsroulesScore.setvalue(jsonPayload);
			List<RoulesScoreEntity> listroules = new ArrayList<RoulesScoreEntity>();
			try {
				listroules = RoulesScoreService.getlistroulesByTemplate(false);
				if(listroules.size() == 0) {
					listroules = new ArrayList<RoulesScoreEntity>();
					listroules = RoulesScoreService.getlistroulesByTemplate(true);
				}
			}catch (Exception e) {
				LOGGER.error("ERROR", e);
				// TODO: handle exception
			}
			HashMap<String, Object> mapscore = CalculateScore.score(listroules, parmsroulesScore,RiskLevelService,headerservice,detailservice);
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("custservice", custservice);
			params.put("runnumberservice", service);
			params.put("appService", appService);
			params.put("appScoreService", appScoreService);
			params.put("loanApplicationService", loanApplicationService);
			params.put("appPersonelService", appPersonelService);
			params.put("appAddressService", appAddressService);
			params.put("appFamilyService", appFamilyService);
			params.put("appBusinessService", appBusinessService);
			params.put("appFinancialService", appFinancialService);
			params.put("appBankService", appBankService);
			params.put("appCollateralService", appCollateralService);
			params.put("appCollateralRealEstateService", appCollateralRealEstateService);
			params.put("appCollateralDepositService", appCollateralDepositService);
			params.put("mapscore", mapscore);
			
			HashMap<String, Object> mapreturn = jsonPayload.actionupdate(params);
			boolean isupdate = (boolean) mapreturn.get("isupdate");
			String tempappid = (String) mapreturn.get("appid");
			if(!isupdate) {
				String appid = createfunc(jsonPayload);
				tempappid = appid;
			}
			Optional<CustomerEntity> optCust = custservice.findById(jsonPayload.getAppPersonel().getCustomerid());
			if(optCust.isPresent()) {
				CustomerEntity cust = optCust.get();
				if(cust.getCif_id().equals("")) {
					cust.setCif_id(jsonPayload.getAppPersonel().getCfiid());
					custservice.update(cust.getCustomerid(), cust);
				}
			}else {
				CustomerEntity cust = new CustomerEntity();
				custservice.create(cust.setEntity(jsonPayload.getAppPersonel(), service));
			}
			String createorupdate = "Create";
			if(isupdate) {
				createorupdate = "Update";
			}
			String descrip = createorupdate+" Draft Application Loan = "+tempappid;
			if(jsonPayload.getIsdraft().equals("Y")) {
				descrip = "Create Application Loan = "+tempappid;
			}
			LogEntity log = new LogEntity();
			log.setAction("CREATE");
			log.setDate(new Timestamp(new Date().getTime()));
			log.setDescription(descrip);
			log.setIp(Utils.getClientIp(request));
			log.setUserid(jsonPayload.getCreatedby());
			logservice.create(log);
		}else {
			response.setValidation(listvalidation);
		}
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}	
	
	@GetMapping("/getlist")
	ResponseEntity<Response> getApplicationList(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
			HashMap<String, Object> paramauth = new HashMap<String, Object>();
			paramauth.put("auth", Authorization);
			paramauth.put("platform", platform);
//			paramauth.put("userservice", userservice);
			paramauth.put("companyservice", compservice);
			boolean flagauth = Utils.CheckAuth(paramauth);
			LOGGER.info("getlist : "+flagauth);
			if(!flagauth) {
				response.setMessage("not authenticated");
				response.setData("");
				return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
			}
			/* Set Data Dari Database */
			response.setData(appService.findbyOnlyIsDraft("Y"));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

	@GetMapping("/getlistapplication")
	ResponseEntity<Response> getList(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistapplication : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		List<applicationEntity> listapp = appService.findbyOnlyIsDraft("N");

		response.setData(listapplication(listapp));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

	@GetMapping("/getlistunderwriting")
	ResponseEntity<Response> getApplicationListUnderWriting(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistunderwriting : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		List<applicationEntity> listapp = appService.findbyIsDraft("U", "N");
		
		response.setData(listapplication(listapp));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@GetMapping("/getlistrejected")
	ResponseEntity<Response> getApplicationListRejected(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistrejected : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		List<applicationEntity> listapp = appService.findbyIsDraft("R","N");
		
		response.setData(listapplication(listapp));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@GetMapping("/getlistapprove")
	ResponseEntity<Response> getApplicationListApprove(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistapprove : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		List<applicationEntity> listapp = appService.findbyIsDraft("A","N");
		
		response.setData(listapplication(listapp));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@GetMapping("/getlistsend")
	ResponseEntity<Response> getApplicationListSend(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistsend : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		List<applicationEntity> listapp = appService.findbyIsDraft("S","N");
		
		response.setData(listapplication(listapp));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@GetMapping("/getdetailapp")
	ResponseEntity<Response> getDetailApp(@RequestParam String applicationid) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		Optional<ApplicationScoreEntity> optappscore = appScoreService.findById(applicationid);
		ViewApplicationJson viewapp = new ViewApplicationJson();
		
//		List<RoulesScoreMaxEntity> listrulesmax = RoulesScoreService.getlistroulesMaxScore(false);
//		System.out.println("listrulesmax : "+listrulesmax.size());
		if(optappscore.isPresent()) {
			viewapp.setViewscore(optappscore.get());
		}
		response.setData(viewapp);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@GetMapping("/getlistapplicationv2")
	ResponseEntity<Response> getApplicationListV2() {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
//		List<applicationEntity> listappapprove = appService.findByStatus("A");
//		List<applicationEntity> listappreject = appService.findByStatus("R");
		List<applicationEntity> listappunderwriting = appService.findByStatus("U");
		
		response.setData("");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@GetMapping("/getlistunderwritingpage")
	ResponseEntity<Response> getApplicationListUnderWritingByPage(@RequestParam String page,@RequestParam String sizeperpage) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		
		int sizepage = new Integer(sizeperpage).intValue();
		int atPage = new Integer(page).intValue();
		HashMap<String, Integer> map = Utils.GetPagination(atPage, sizepage);
		sizepage = map.get("sizepage").intValue();
		
		List<applicationEntity> listapp = appService.findbystatusperpage("U", sizepage);
		
		response.setData(listapplication(listapp));
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	private String createfunc(ApplicationJSON jsonPayload) {
		String value = "";
		ParamsRoulesScoreEntity parmsroulesScore = new ParamsRoulesScoreEntity();
		parmsroulesScore = parmsroulesScore.setvalue(jsonPayload);

		List<RoulesScoreEntity> listroules = RoulesScoreService.getlistroulesByTemplate(false);
		if(listroules.size() == 0) {
			listroules = new ArrayList<RoulesScoreEntity>();
			listroules = RoulesScoreService.getlistroulesByTemplate(true);
		}
		HashMap<String, Object> mapscore = CalculateScore.score(listroules, parmsroulesScore,RiskLevelService,headerservice,detailservice);
		int score = (int) mapscore.get("hasilscore");
		RiskLevelEntity risk = (RiskLevelEntity) mapscore.get("risk");
		String status = (String) mapscore.get("status");
		String ruleEnginecomments = (String) mapscore.get("ruleEnginecomments");
		HashMap<String, Double> detailscore = (HashMap<String, Double>) mapscore.get("detailscore");
		ApplicationScoreEntity appscore = new ApplicationScoreEntity();
		
		boolean isrealestate = Validation.checkCollateral(TypeCollateral.REALESTATE.value(),
				jsonPayload.getAppCollateral().getValueC());
		boolean isvehicle = Validation.checkCollateral(TypeCollateral.VEHICLE.value(),
				jsonPayload.getAppCollateral().getValueC());
		boolean isdeposit = Validation.checkCollateral(TypeCollateral.DEPOSIT.value(),
				jsonPayload.getAppCollateral().getValueC());

		HashMap<String, Object> hash = jsonPayload.getvalueEntity(service);
		applicationEntity appEntity = (applicationEntity) hash.get("appEntity");
		appscore = appscore.SetEntity(detailscore, appEntity.getApplicationID());
		
		appEntity.setScore(score);
		appEntity.setIsdraft(jsonPayload.getIsdraft());
		appEntity.setStatus(status);
		appEntity.setRisklevelid(risk.getId());
		appEntity.setScorecardcomments("");
		appEntity.setRuleenginecomments(ruleEnginecomments);
		
		LoanapplicationEntity appLoanEntity = (LoanapplicationEntity) hash.get("appLoanEntity");
		applicationPersonelEntity appPersonelEntity = (applicationPersonelEntity) hash.get("appPersonelEntity");
		ApplicationAddressEntity appAddressEntity = (ApplicationAddressEntity) hash.get("appAddressEntity");
		ApplicationFamilyEntity appFamilyEntity = (ApplicationFamilyEntity) hash.get("appFamilyEntity");
		ApplicationBusinessEntity appBusinessEntity = (ApplicationBusinessEntity) hash.get("appBusinessEntity");
		ApplicationFinancialEntity appFinancialEntity = (ApplicationFinancialEntity) hash.get("appFinancialEntity");
		ApplicationBankEntity appBankEntity = (ApplicationBankEntity) hash.get("appBankEntity");
		ApplicationCollateralEntity appCollateralEntity = (ApplicationCollateralEntity) hash.get("appCollateralEntity");
		ApplicationCollateralRealEstateEntity appCollateralRealEstateEntity = (ApplicationCollateralRealEstateEntity) hash
				.get("appCollateralRealEstateEntity");
		ApplicationCollateralVehicleEntity appCollateralVehicleEntity = (ApplicationCollateralVehicleEntity) hash
				.get("appCollateralVehicleEntity");
		ApplicationCollateralDepositEntity appCollateralDepositEntity = (ApplicationCollateralDepositEntity) hash
				.get("appCollateralDepositEntity");

		// save
		try {
		appScoreService.create(appscore);
		appService.create(appEntity);
		loanApplicationService.create(appLoanEntity);
		appPersonelService.create(appPersonelEntity);
		System.out.println("appAddressEntity "+appAddressEntity.toString());
		System.out.println("appAddressEntity "+appAddressEntity.getApplicationid());
		System.out.println("appAddressEntity "+appAddressEntity.getMainaddress());
		appAddressService.create(appAddressEntity);
		
		appFamilyService.create(appFamilyEntity);
		appBusinessService.create(appBusinessEntity);
		appFinancialService.create(appFinancialEntity);
		appBankService.create(appBankEntity);
		appCollateralService.create(appCollateralEntity);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		if (isrealestate) {
			appCollateralRealEstateService.create(appCollateralRealEstateEntity);
		} else if (isvehicle) {
			appCollateralService.createCollateralVehicle(appCollateralVehicleEntity);
		} else if (isdeposit) {
			appCollateralDepositService.create(appCollateralDepositEntity);
		}

		return appEntity.getApplicationID();
	}
	
	private List<RoulesScoreMaxEntity> listmax(List<Object> list){
		List<RoulesScoreMaxEntity> listscoremax = new ArrayList<RoulesScoreMaxEntity>();
		
		for(Object obj : list) {
			RoulesScoreMaxEntity max = new RoulesScoreMaxEntity();
			Object[] arobj = (Object[]) obj;
			String grups = String.valueOf(arobj[0]);
			String strscore = String.valueOf(arobj[1]);
			max.setGroups(grups);
			max.setMaxscore(new Double(strscore).doubleValue());
			listscoremax.add(max);
		}
		return listscoremax;
	}
	private List<ApplicationEntityJson> listapplication(List<applicationEntity> listapp) {
		List<ApplicationEntityJson> list = new ArrayList<ApplicationEntityJson>();
		List<RoulesScoreMaxEntity> listrulesmax = listmax(RoulesScoreService.getlistroulesMaxScore(false)) ;
		for (applicationEntity app : listapp) {
			ApplicationEntityJson appjson = new ApplicationEntityJson();
			appjson.setId(app.getApplicationID());
			appjson.setListscoremax(listrulesmax);
			Optional<ApplicationScoreEntity> optappscore = appScoreService.findById(app.getApplicationID());
			if(optappscore.isPresent()) {
				appjson.setAppscore(optappscore.get());
			}else {
				appjson.setAppscore(null);
			}
			
			appjson.setListdoc(repoListDoc.listdocumentbyappid(app.getApplicationID()));
			appjson.setAppentity(app);
			appjson.setApploanentity(Utils.checkpresent(loanApplicationService.findById(app.getApplicationID()),
					new LoanapplicationEntity()));

			appjson.setApppersonelentity(Utils.checkpresent(appPersonelService.findById(app.getApplicationID()),
					new applicationPersonelEntity()));
			
			appjson.setAppaddressentity(Utils.checkpresent(appAddressService.findById(app.getApplicationID().trim()),
					new ApplicationAddressEntity()));

			appjson.setAppfamilyentity(Utils.checkpresent(appFamilyService.findById(app.getApplicationID()),
					new ApplicationFamilyEntity()));

			appjson.setAppbusinessentity(Utils.checkpresent(appBusinessService.findById(app.getApplicationID()),
					new ApplicationBusinessEntity()));

			appjson.setAppfinancialentity(Utils.checkpresent(appFinancialService.findById(app.getApplicationID()),
					new ApplicationFinancialEntity()));

			appjson.setAppbankentity(Utils.checkpresent(appBankService.findById(app.getApplicationID()), new ApplicationBankEntity()));

			Optional<ApplicationCollateralEntity> appcolateral = appCollateralService.findById(app.getApplicationID());
			if (appcolateral.isPresent()) {
				appjson.setAppcollateralentity(appcolateral.get());
				boolean isrealestate = Validation.checkCollateral(TypeCollateral.REALESTATE.value(),
						appjson.getAppcollateralentity().getCollateral());
				boolean isvehicle = Validation.checkCollateral(TypeCollateral.VEHICLE.value(),
						appjson.getAppcollateralentity().getCollateral());
				boolean isdeposit = Validation.checkCollateral(TypeCollateral.DEPOSIT.value(),
						appjson.getAppcollateralentity().getCollateral());
				if (isrealestate) {
					appjson.setAppcollateralreentity(
							Utils.checkpresent(appCollateralRealEstateService.findById(app.getApplicationID()),
									new ApplicationCollateralRealEstateEntity()));
				} else if (isvehicle) {
					appjson.setAppcollateralvehicleentity(
							Utils.checkpresent(appCollateralService.findCollateralVehicleById(app.getApplicationID()),
									new ApplicationCollateralVehicleEntity()));
				} else if (isdeposit) {
					appjson.setAppcollateraldepositentity(
							Utils.checkpresent(appCollateralDepositService.findById(app.getApplicationID()),
									new ApplicationCollateralDepositEntity()));
				}
			}
			appjson.setvalue();
			list.add(appjson);
		}
		return list;
	}
}
