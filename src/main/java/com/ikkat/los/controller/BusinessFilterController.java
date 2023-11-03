package com.ikkat.los.controller;

import java.util.HashMap;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.BusinessFilterConditionsEntity;
import com.ikkat.los.entity.BusinessFilterEntity;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.jsonmodel.BusinessFilterConditionsJson;
import com.ikkat.los.jsonmodel.BusinessFilterJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.BusinessFilterConditionService;
import com.ikkat.los.service.BusinessFilterService;
import com.ikkat.los.service.CreditScoreService;

@RestController
@RequestMapping("/loan/businessfilter/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class BusinessFilterController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//	@Autowired
//	BusinessFilterService businessFilterService;
	
	@Autowired
	BusinessFilterConditionService businessFilterConditionService;
	
	@PostMapping("/create")
	ResponseEntity<Response> createNewBusinessFilter(@RequestBody @Validated BusinessFilterConditionsJson jsonPayload) {
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		
		/* Memanggil Class Response yang telah dibuat */
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.CREATE.value());
		
		try {
		/* Set Data Dari Database */
		response.setData(businessFilterConditionService.create(jsonPayload.getEntity()));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/update")
	ResponseEntity<Response> UpdateBusinessFilter(@RequestBody @Validated BusinessFilterJson jsonPayload) {
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
//		HashMap<String, Object> hash = jsonPayload.getBusinessFilter();
//		BusinessFilterEntity bf = (BusinessFilterEntity) hash.get("businessfilter");
//		List<BusinessFilterConditionsEntity> list = (List<BusinessFilterConditionsEntity>) hash.get("conditions");
		/* Memanggil Class Response yang telah dibuat */
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.CREATE.value());
		
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
