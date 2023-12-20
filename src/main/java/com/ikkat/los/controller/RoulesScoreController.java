package com.ikkat.los.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.FilterEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.jsonmodel.RoulesScoreJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.LineBusinessService;
import com.ikkat.los.service.RoulesScoreService;
//import com.ikkat.los.service.UserService;
import com.ikkat.los.utils.Utils;


@RestController
@RequestMapping("/roules/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class RoulesScoreController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RoulesScoreService service;
	@Autowired
	LineBusinessService linebusinessservice;
//	@Autowired
//	UserService userservice;
	@Autowired
	CompanyService compservice;
	
	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
	
	@PostMapping("/create")
	ResponseEntity<Response> create(@RequestBody @Validated RoulesScoreJson jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.CREATE.value());
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
		
		response.setData(service.create(jsonPayload.setEntity()));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@PostMapping("/update")
	ResponseEntity<Response> update(@RequestBody @Validated RoulesScoreJson jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.UPDATE.value());
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
		
		Optional<RoulesScoreEntity> optFilter = service.findById(jsonPayload.getId());
		RoulesScoreEntity entity = new RoulesScoreEntity();
		if(optFilter.isPresent()) {
			entity = optFilter.get();
			Date dt = new Date();			
			if(!entity.isIsroulestemplate()) {
				entity.setScore(jsonPayload.getScore());
				entity.setModifieddate(Utils.longToZonedDateTime(dt.getTime()));
				service.update(entity.getId(), entity);
			}
			
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
		Optional<RoulesScoreEntity> optFilter = service.findById(id);
		RoulesScoreEntity entity = new RoulesScoreEntity();
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
	
	@GetMapping("/getlist")
	ResponseEntity<Response> getRoulesScoreList(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
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
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("listrules", service.getlistroulesByTemplate(false));
		map.put("listlb", linebusinessservice.findAll());
		/* Set Data Dari Database */
		response.setData(map);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@GetMapping("/getlistpage")
	ResponseEntity<Response> getRoulesScoreListByPage(@RequestParam String page,@RequestParam String sizeperpage) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		int sizepage = new Integer(sizeperpage).intValue();
		int atPage = new Integer(page).intValue();
		HashMap<String, Integer> map = Utils.GetPagination(atPage, sizepage);
		sizepage = map.get("sizepage").intValue();
		/* Set Data Dari Database */
		
		List<RoulesScoreEntity> listpage = service.getlistroulesByTemplateByPage(false, sizepage);
		System.out.println("listpage size : "+listpage.size());
		response.setData(listpage);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
