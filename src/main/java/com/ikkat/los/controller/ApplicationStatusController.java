package com.ikkat.los.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.LogEntity;
import com.ikkat.los.entity.applicationEntity;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.jsonmodel.ApplicationJSON;
import com.ikkat.los.jsonmodel.ApplicationStatusJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.LogService;
//import com.ikkat.los.service.UserService;
import com.ikkat.los.service.applicationService;
import com.ikkat.los.utils.Utils;

@RestController
@RequestMapping("/loan/application/status/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class ApplicationStatusController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	applicationService appService;
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
	
	@PostMapping("/updatestatus")
	ResponseEntity<Response> create(@RequestBody @Validated ApplicationStatusJson jsonPayload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		System.out.println("status : "+jsonPayload.getStatus());
		Optional<applicationEntity> opsapp = appService.findById(jsonPayload.getAppid());
		
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		try {
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("updatestatus : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		if(opsapp.isPresent()) {
			String status = "Approve";
			if(jsonPayload.getStatus().equals("R")) {
				status = "Reject";
			}
			applicationEntity app = opsapp.get();
			app.setStatus(jsonPayload.getStatus());
			appService.update(jsonPayload.getAppid(), app);
			response.setMessage("");
			
			LogEntity log = new LogEntity();
			log.setAction("UPDATE");
			log.setDate(new Timestamp(new Date().getTime()));
			log.setDescription("Update Status Loan ( "+jsonPayload.getAppid()+" )= "+status);
			log.setIp(Utils.getClientIp(request));
			log.setUserid(jsonPayload.getUserid());
			logservice.create(log);
		}else {
			response.setMessage(MessageEnum.ID_NOT_EXIST.value());
		}
		
		
		response.setData(HttpStatus.OK);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
