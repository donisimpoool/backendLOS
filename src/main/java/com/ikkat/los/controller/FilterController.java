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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.FilterDetailEntity;
import com.ikkat.los.entity.FilterDetailEntityPK;
import com.ikkat.los.entity.FilterEntity;
import com.ikkat.los.entity.FilterHeaderEntity;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.helper.entity.ViewFilterJson;
import com.ikkat.los.jsonmodel.FilterDetailJson;
import com.ikkat.los.jsonmodel.FilterJson;
import com.ikkat.los.jsonmodel.FilterJsonV2;
import com.ikkat.los.jsonmodel.LoanProductJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.FilterDetailService;
import com.ikkat.los.service.FilterHeaderService;
import com.ikkat.los.service.FilterService;
import com.ikkat.los.service.RunningNumberService;
import com.ikkat.los.service.UserService;
import com.ikkat.los.utils.Utils;


@RestController
@RequestMapping("/filter/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class FilterController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FilterService service;
	@Autowired
	FilterHeaderService serviceheader;
	@Autowired
	FilterDetailService servicedetail;
	@Autowired
	RunningNumberService runningnumber;
	@Autowired
	UserService userservice;
	@Autowired
	CompanyService compservice;
	
	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
	
	@PostMapping("/create")
	ResponseEntity<Response> create(@RequestBody @Validated FilterJsonV2 jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		response.setData("");
		
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("create : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		HashMap<String, Object> map = jsonPayload.mapentity(runningnumber);
		FilterHeaderEntity filterheader = (FilterHeaderEntity) map.get("header");
		List<FilterDetailEntity> listdetail = (List<FilterDetailEntity>) map.get("detail");
		
		servicedetail.saveAll(listdetail);
		serviceheader.create(filterheader);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/update")
	ResponseEntity<Response> update(@RequestBody @Validated FilterJsonV2 jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.UPDATE.value());
		response.setData("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("update : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		HashMap<String, Object> map = jsonPayload.mapentity(runningnumber);
		List<FilterDetailEntity> listdetail = (List<FilterDetailEntity>) map.get("detail");
		
		Optional<FilterHeaderEntity> optHeader = serviceheader.findById(jsonPayload.getId());
		if(optHeader.isPresent()) {
			Date dt = new Date();
			Timestamp ts = new Timestamp(dt.getTime());
			servicedetail.deleteByHeaderID(jsonPayload.getId());
			servicedetail.saveAll(listdetail);
			
			FilterHeaderEntity header = optHeader.get();
			header.setFiltername(jsonPayload.getName());
			header.setModifieddate(ts);
			header.setCreateby(jsonPayload.getCreateby());
			serviceheader.update(jsonPayload.getId(), header);
		}
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
		response.setData("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("delete : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		String filterhid = payload.get("id");
		
		servicedetail.deleteByHeaderID(filterhid);
		serviceheader.delete(filterhid);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@GetMapping("/getlistfilter")
	ResponseEntity<Response> getFilterList(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistfilter : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

		

		/* Set Data Dari Database */
		response.setData(service.findAll());
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@GetMapping("/getlistfilterbypage")
	ResponseEntity<Response> getFilterListByPage(@RequestParam String page,@RequestParam String sizeperpage,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {

		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistfilterbypage : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		ViewFilterJson view = new ViewFilterJson();
		
		int sizepage = new Integer(sizeperpage).intValue();
		int atPage = new Integer(page).intValue();
		HashMap<String, Integer> map = Utils.GetPagination(atPage, sizepage);
		sizepage = map.get("sizepage").intValue();

		List<FilterHeaderEntity> list = serviceheader.getlistByPage(sizepage); 
		view.setFilterheader(list);
		/* Set Data Dari Database */
		response.setData(view);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@GetMapping("/getdetail")
	ResponseEntity<Response> getFilterDetailById(@RequestParam String id,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getdetail : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		
		ViewFilterJson view = new ViewFilterJson();
		List<FilterDetailEntity> list = servicedetail.listdetailByHeaderid(id);
		view.setListdetail(list);
		/* Set Data Dari Database */
		response.setData(view);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
