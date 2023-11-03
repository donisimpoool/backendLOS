package com.ikkat.los.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.LineBusinessEntity;
import com.ikkat.los.entity.LogEntity;
import com.ikkat.los.entity.UrlEntity;
import com.ikkat.los.entity.applicationEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.helper.CustomerHelper;
import com.ikkat.los.helper.LoanHelper;
import com.ikkat.los.helper.LoanProductHelper;
import com.ikkat.los.helper.ReligionHelper;
import com.ikkat.los.helper.entity.ValidationEntity;
import com.ikkat.los.jsonmodel.ApplicationJSON;
import com.ikkat.los.jsonmodel.ApplicationStatusJson;
import com.ikkat.los.jsonmodel.CheckUpdateSimpoolJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.CustomerService;
import com.ikkat.los.service.LineBusinessService;
import com.ikkat.los.service.LoanProductService;
import com.ikkat.los.service.LogService;
import com.ikkat.los.service.ParamaterService;
import com.ikkat.los.service.ReligionService;
import com.ikkat.los.service.RoulesScoreService;
import com.ikkat.los.service.UrlService;
import com.ikkat.los.service.UserService;
import com.ikkat.los.service.applicationService;
import com.ikkat.los.simpool.service.SimpoolService;
import com.ikkat.los.utils.CallApiSimpool;
import com.ikkat.los.utils.MessagesJson;
import com.ikkat.los.utils.Utils;

@RestController
@RequestMapping("/simpool/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class SimpoolController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UrlService service;
	@Autowired
	private LoanProductService loanservice;
	@Autowired
	private applicationService appService;
	@Autowired
	private LineBusinessService lineservice;
	@Autowired
	private RoulesScoreService ruleservice;
	@Autowired
	LogService logservice;
	@Autowired
	private CustomerService custservice;
	@Autowired
	private ReligionService religionservice;
	@Autowired
	private ParamaterService paramservice;
	@Autowired
	UserService userservice;
	@Autowired
	CompanyService compservice;
	@Autowired
	SimpoolService simpoolService;
	
	
	static HttpServletRequest request;
	@Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
	
	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
	
	@GetMapping("/getlistloanproductssimpool")
	ResponseEntity<Response> getListLoanProduct(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) throws ParseException {
		
		String tes = (String) simpoolService.loginSimpool("", "");
		
		
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		
		try {
		Optional<UrlEntity> murl = service.findById("loanproducts");
		String url = murl.get().getUrl();
		CallApiSimpool apisimpool = new CallApiSimpool();
		
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistloanproductssimpool : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		/* Set Data Dari Database */
		String tenantid = paramservice.findById("fineractplatformtenantid").get().getParamater();
		String authsimpool = paramservice.findById("authsimpool").get().getParamater();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("url", url);
		param.put("tenantid", tenantid);
		param.put("authsimpool", authsimpool);
		param.put("queryparam", new LinkedMultiValueMap<String, String>());
		HashMap<String, Object> mapreturn = apisimpool.resultGet(param);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse((String) mapreturn.get("body"));
		JSONArray jsonarray = (JSONArray) obj;
		response.setData(jsonarray);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/sendloan")
	ResponseEntity<Response> sendLoanToSimpool(@RequestBody @Validated ApplicationStatusJson jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) throws ParseException, IOException {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		response.setValidation("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistloanproductssimpool : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		CallApiSimpool apisimpool = new CallApiSimpool();
		Optional<UrlEntity> murl = service.findById("sendloan");
		String url = murl.get().getUrl();
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("appid", jsonPayload.getAppid());
		param.put("appService", appService);
		param.put("custservice", custservice);
		param.put("urlservice", service);
		param.put("paramservice", paramservice);
		String valueReturn = LoanHelper.setJsonLoan(param);
		
		String tenantid = paramservice.findById("fineractplatformtenantid").get().getParamater();
		String authsimpool = paramservice.findById("authsimpool").get().getParamater();
		String userauth = paramservice.findById("userauth").get().getParamater();
		String passauth = paramservice.findById("passauth").get().getParamater();
		param = new HashMap<String, Object>();
		param.put("url", url);
		param.put("body", valueReturn);
		param.put("tenantid", tenantid);
		param.put("authsimpool", authsimpool);
		param.put("userauth", userauth);
		param.put("passauth", passauth);
		
		HashMap<String, Object> mapreturn = apisimpool.resultPost(param);
		int code = (Integer) mapreturn.get("code");
		String body = (String) mapreturn.get("body");
		System.out.println("code : "+code);
		if(code == HttpStatus.OK.value()) {
			Optional<applicationEntity> optApp = appService.findById(jsonPayload.getAppid());
			if(optApp.isPresent()) {
				applicationEntity app = optApp.get();
				app.setStatus("S");
				appService.update(jsonPayload.getAppid(), app);
			}
		}else {
			System.out.println("body : "+body);
			if(!body.equals("")) {
				List<ValidationEntity> list = new ArrayList<ValidationEntity>();
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(body);
				JSONObject jsonObj = (JSONObject) obj;
				JSONArray jsonarray = (JSONArray) jsonObj.get("errors");
				for(int x=0; x < jsonarray.size(); x++) {
					JSONObject item = (JSONObject) jsonarray.get(x);
					String defaultUserMessage = (String) item.get("defaultUserMessage");
					String parameterName = (String) item.get("parameterName");
					ValidationEntity valid = new ValidationEntity();
					valid.setErrorparameter(parameterName);
					valid.setErrormessages(defaultUserMessage);
					list.add(valid);
				}
				response.setValidation(list);
			}
		}
		
		LogEntity log = new LogEntity();
		log.setAction("SEND");
		log.setDate(new Timestamp(new Date().getTime()));
		log.setDescription("Send Loan ( "+jsonPayload.getAppid()+" ) To Simpool, Status = "+code);
		log.setIp(Utils.getClientIp(request));
		log.setUserid(jsonPayload.getUserid());
		logservice.create(log);
		
		response.setData(code);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/syncreligion")
	ResponseEntity<Response> syncReligionFromSimpool(@RequestBody @Validated Map<String, String> payload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) throws ParseException {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		response.setValidation("");
		
		try {
		String userid = payload.get("userid");
		Optional<UrlEntity> murl = service.findById("template");
		String url = murl.get().getUrl();
		CallApiSimpool apisimpool = new CallApiSimpool();
		
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistloanproductssimpool : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		/* Set Data Dari Database */
		String tenantid = paramservice.findById("fineractplatformtenantid").get().getParamater();
		String authsimpool = paramservice.findById("authsimpool").get().getParamater();
		String userauth = paramservice.findById("userauth").get().getParamater();
		String passauth = paramservice.findById("passauth").get().getParamater();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("url", url);
		param.put("userauth", userauth);
		param.put("passauth", passauth);
		param.put("tenantid", tenantid);
		param.put("authsimpool", authsimpool);
		param.put("queryparam", new LinkedMultiValueMap<String, String>());
		HashMap<String, Object> mapreturn = apisimpool.resultGet(param);
		int code = (Integer) mapreturn.get("code");
		String body = (String) mapreturn.get("body");
		if(code == 200) {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(String.valueOf(mapreturn.get("body")));
			JSONObject jsonobj = (JSONObject) obj;
			
			HashMap<String, Object> mapParam = new HashMap<String, Object>();
			mapParam.put("jsonarray", jsonobj);
			mapParam.put("service", religionservice);
			ReligionHelper.insertReligionFromSimpool(mapParam);
		}else {
			response.setValidation(MessagesJson.messagesJson(code, body));
		}
		
		LogEntity log = new LogEntity();
		log.setAction("SYNC");
		log.setDate(new Timestamp(new Date().getTime()));
		log.setDescription("Sync Religion From Simpool, Status = "+code);
		log.setIp(Utils.getClientIp(request));
		log.setUserid(userid);
		logservice.create(log);
		
		response.setData(code);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/syncloanproduct")
	ResponseEntity<Response> syncLoanProductFromSimpool(@RequestBody @Validated Map<String, String> payload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) throws ParseException {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		String userid = payload.get("userid");
		Optional<UrlEntity> murl = service.findById("loanproducts");
		String url = murl.get().getUrl();
		CallApiSimpool apisimpool = new CallApiSimpool();
		
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistloanproductssimpool : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		/* Set Data Dari Database */
		String userauth = paramservice.findById("userauth").get().getParamater();
		String passauth = paramservice.findById("passauth").get().getParamater();
		String tenantid = paramservice.findById("fineractplatformtenantid").get().getParamater();
		String authsimpool = paramservice.findById("authsimpool").get().getParamater();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("url", url);
		param.put("userauth", userauth);
		param.put("passauth", passauth);
		param.put("tenantid", tenantid);
		param.put("authsimpool", authsimpool);
		param.put("queryparam", new LinkedMultiValueMap<String, String>());
		HashMap<String, Object> mapreturn = apisimpool.resultGet(param);
		int code = (Integer) mapreturn.get("code");
		String body = (String) mapreturn.get("body");
		System.out.println("mapreturn body ================= "+mapreturn.get("body"));
		System.out.println("mapreturn code ================= "+code);
		if(code == 200 && !body.equals("[]")) {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(String.valueOf(mapreturn.get("body")));
			JSONArray jsonarray = (JSONArray) obj;
			
			HashMap<String, Object> mapParam = new HashMap<String, Object>();
			mapParam.put("jsonarray", jsonarray);
			mapParam.put("service", loanservice);
			LoanProductHelper.insertSyncLoanProductFromSimpool(mapParam);
		}
		
		LogEntity log = new LogEntity();
		log.setAction("SYNC");
		log.setDate(new Timestamp(new Date().getTime()));
		log.setDescription("Sync Loan Product From Simpool, Status = "+code);
		log.setIp(Utils.getClientIp(request));
		log.setUserid(userid);
		logservice.create(log);
		
		response.setData(code);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/synclinebusiness")
	ResponseEntity<Response> syncLineBusinessFromSimpool(@RequestBody @Validated Map<String, String> payload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) throws ParseException {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		String userid = payload.get("userid");
		Optional<UrlEntity> murl = service.findById("loanproducts");
		String url = murl.get().getUrl();
		CallApiSimpool apisimpool = new CallApiSimpool();
		
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistloanproductssimpool : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		List<HashMap<String, String>> listmap = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", "agriculture");
		map.put("name", "Agriculture");
		map.put("score", "10");
		listmap.add(map);
		
		map = new HashMap<String, String>();
		map.put("id", "construction");
		map.put("name", "Construction");
		map.put("score", "15");
		listmap.add(map);
		
		map = new HashMap<String, String>();
		map.put("id", "manufacturing");
		map.put("name", "Manufacturing");
		map.put("score", "25");
		listmap.add(map);
		
		map = new HashMap<String, String>();
		map.put("id", "miningandutilities");
		map.put("name", "Mining and Utilities");
		map.put("score", "20");
		listmap.add(map);
		
		map = new HashMap<String, String>();
		map.put("id", "financial");
		map.put("name", "Financial");
		map.put("score", "10");
		listmap.add(map);
		
		map = new HashMap<String, String>();
		map.put("id", "generalservices");
		map.put("name", "General Services");
		map.put("score", "15");
		listmap.add(map);
		
		map = new HashMap<String, String>();
		map.put("id", "insuranceandbusinessservices");
		map.put("name", "Insurance and Business Services");
		map.put("score", "10");
		listmap.add(map);
		
		map = new HashMap<String, String>();
		map.put("id", "other");
		map.put("name", "Other");
		map.put("score", "5");
		listmap.add(map);
		
		for(HashMap<String, String> item : listmap) {
			Optional<LineBusinessEntity> optLine = lineservice.findById(item.get("id"));
			if(!optLine.isPresent()) {
				Timestamp date = new Timestamp(new Date().getTime());
				LineBusinessEntity lb = new LineBusinessEntity();
				lb.setId(item.get("id"));
				lb.setName(item.get("name"));
				lb.setIsactive("Y");
				lb.setCreatedby(userid);
				lb.setCreateddate(date);
				lb.setModifieddate(date);
				lineservice.create(lb);
				
				RoulesScoreEntity rule = ruleservice.getroulesByGroup(false, "industrysector", item.get("id"));
				if(rule == null) {
					rule = new RoulesScoreEntity();
					rule.setId(Utils.generateNumber());
					rule.setMaxvalue(0);
					rule.setMinvalue(0);
					rule.setNameroules("");
					rule.setScore(0);
					rule.setTyperoules("equals");
					rule.setValue(item.get("id"));
					rule.setValuenumber(0);
					rule.setIsroulestemplate(false);
					rule.setGroups("industrysector");
					rule.setCreatedby(userid);
					ruleservice.create(rule);
				}
			}
		}
		/* Set Data Dari Database */
//		HashMap<String, Object> mapreturn = apisimpool.resultGet(url,new LinkedMultiValueMap<String, String>());
//		int code = (Integer) mapreturn.get("code");
//		if(code == 200) {
//			JSONParser parser = new JSONParser();
//			Object obj = parser.parse(String.valueOf(mapreturn.get("body")));
//			JSONArray jsonarray = (JSONArray) obj;
//			
//			HashMap<String, Object> mapParam = new HashMap<String, Object>();
//			mapParam.put("jsonarray", jsonarray);
//			mapParam.put("service", loanservice);
//			LoanProductHelper.insertSyncLoanProductFromSimpool(mapParam);
//		}
		
		LogEntity log = new LogEntity();
		log.setAction("SYNC");
		log.setDate(new Timestamp(new Date().getTime()));
		log.setDescription("Sync Line Business From Simpool, Status = 200");
		log.setIp(Utils.getClientIp(request));
		log.setUserid(userid);
		logservice.create(log);
		
		response.setData(200);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/checkduplicate")
	ResponseEntity<Response> checkDuplicate(@RequestBody @Validated CheckUpdateSimpoolJson jsonPayload) throws ParseException {
		Optional<UrlEntity> murl = service.findById("checkduplicate");
		String url = murl.get().getUrl();
		CallApiSimpool apisimpool = new CallApiSimpool();
		
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormatEnum.FORMAT_DATE_FULL_NAME_MONTH.value());
		String dateOfBirth = dateFormat.format(jsonPayload.getDateofbirth()).replaceAll("-", "+");
		String fullname = jsonPayload.getFullname().replaceAll(" ", "+");
		
		/* Set Data Dari Database */
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
		parameters.add("isDuplicate", "false");
		parameters.add("legalForm", "1");
		parameters.add("limit", "1000");
		parameters.add("locale", "en");
		parameters.add("motherName", "");
		parameters.add("typeOfIdentityId", "IC");
		parameters.add("dateOfBirth", dateOfBirth);
		parameters.add("fullname", fullname);
		parameters.add("identityNumber", jsonPayload.getIdnumber());
		String tenantid = paramservice.findById("fineractplatformtenantid").get().getParamater();
		String authsimpool = paramservice.findById("authsimpool").get().getParamater();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("url", url);
		param.put("tenantid", tenantid);
		param.put("authsimpool", authsimpool);
		param.put("queryparam", parameters);
		HashMap<String, Object> mapreturn = apisimpool.resultGet(param);
		int code = (Integer) mapreturn.get("code");
		String body = (String) mapreturn.get("body");
		response.setData(code);
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
