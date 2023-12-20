package com.ikkat.los.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.CustomerEntity;
import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.helper.CustomerHelper;
import com.ikkat.los.helper.entity.ValidationEntity;
import com.ikkat.los.jsonmodel.CheckUpdateSimpoolJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.CustomerService;
import com.ikkat.los.service.ParamaterService;
import com.ikkat.los.service.UrlService;
//import com.ikkat.los.service.UserService;
import com.ikkat.los.utils.Utils;
import com.ikkat.los.validation.Validation;

@RestController
@RequestMapping("/customer/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class CustomerController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerService custservice;
	@Autowired
	private UrlService service;
	@Autowired
	private ParamaterService paramservice;
//	@Autowired
//	UserService userservice;
	@Autowired
	CompanyService compservice;
	
	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
	
	@PostMapping("/findcustomer")
	ResponseEntity<Response> checkDuplicate(@RequestBody @Validated CheckUpdateSimpoolJson jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) throws ParseException {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		response.setData("");
		response.setValidation("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("findcustomer : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		List<ValidationEntity> listvalidation = Validation.validationFindCustomer(jsonPayload);
		if(listvalidation.size() > 0) {
			response.setMessage("");
			response.setData("");
			response.setValidation(listvalidation);
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		String userauth = paramservice.findById("userauth").get().getParamater();
		String passauth = paramservice.findById("passauth").get().getParamater();
		String tenantid = paramservice.findById("fineractplatformtenantid").get().getParamater();
		String authsimpool = paramservice.findById("authsimpool").get().getParamater();
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("paramsearch", jsonPayload);
		param.put("urlService", service);
		param.put("userauth", userauth);
		param.put("passauth", passauth);
		param.put("tenantid", tenantid);
		param.put("authsimpool", authsimpool);
		HashMap<String, Object> findcustsimpool = CustomerHelper.findCustomerSimpool(param);
		List<CustomerEntity> list = (List<CustomerEntity>) findcustsimpool.get("list");
		
		param = new HashMap<String, Object>();
		param.put("custservice", custservice);
		param.put("paramsearch", jsonPayload);
		param.put("listcustsimpool", list);
		List<CustomerEntity> listfinal = CustomerHelper.searchByTableCust(param);
		
		HashMap<String, Object> mapdata = new HashMap<String, Object>();
		mapdata.put("list", listfinal);
		
		response.setData(mapdata);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
}
