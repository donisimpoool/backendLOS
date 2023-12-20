package com.ikkat.los.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.RiskLevelEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.jsonmodel.RiskLevelJson;
import com.ikkat.los.jsonmodel.RoulesScoreJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.RiskLevelService;
//import com.ikkat.los.service.UserService;
import com.ikkat.los.utils.Utils;

@RestController
@RequestMapping("/risklevel/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class RiskLevelController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RiskLevelService service;
//	@Autowired
//	UserService userservice;
	@Autowired
	CompanyService compservice;
	
	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
	
	@GetMapping("/getlist")
	ResponseEntity<Response> getRiskLevelList(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
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
		LOGGER.info("getlist : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		/* Set Data Dari Database */
		response.setData(service.findAll());
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/create")
	ResponseEntity<Response> create(@RequestBody @Validated RiskLevelJson jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
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
		LOGGER.info("getlist : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		response.setData(service.create(jsonPayload.getEntity()));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/update")
	ResponseEntity<Response> update(@RequestBody @Validated RiskLevelJson jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
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
		LOGGER.info("getlist : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		Optional<RiskLevelEntity> optFilter = service.findById(jsonPayload.getId());
		RiskLevelEntity entity = new RiskLevelEntity();
		if(optFilter.isPresent()) {
			entity = optFilter.get();
			entity.setMax(new Double(jsonPayload.getMax()));
			entity.setMin(new Double(jsonPayload.getMin()));
			entity.setNamerisk(jsonPayload.getName());
			entity.setOdds(jsonPayload.getOdds());
			entity.setProbabilityofdefault(new Double(jsonPayload.getProbabilityofdefault()));
			entity.setStatus(jsonPayload.getStatus());
			service.update(entity.getId(), entity);
		}
		
		response.setData(entity);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/delete")
	ResponseEntity<Response> delete(@RequestBody @Validated Map<String, String> payload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.DELETE.value());
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlist : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		Long id = new Long(payload.get("id"));
		Optional<RiskLevelEntity> optFilter = service.findById(id);
		RiskLevelEntity entity = new RiskLevelEntity();
		if(optFilter.isPresent()) {
			service.delete(id);
		}
		
		response.setData(entity);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
}
