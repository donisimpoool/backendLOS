package com.ikkat.los.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.BankEntity;
import com.ikkat.los.entity.LoanProductEntity;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.jsonmodel.BankJson;
import com.ikkat.los.jsonmodel.LoanProductJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.BankService;
import com.ikkat.los.utils.Utils;


@RestController
@RequestMapping("/bank/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class BankController {
	@Autowired
	BankService service;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
	
	@GetMapping("/getlist")
	ResponseEntity<Response> getListBank() {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		/* Set Data Dari Database */
		try {
			response.setData(service.findAll());
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/create")
	ResponseEntity<Response> create(@RequestBody @Validated BankJson jsonPayload) {

		/* Memanggil Class Response yang telah dibuat */
//		System.out.println("LoanID : "+jsonPayload.getLoanProductId());
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.CREATE.value());
		try {
			response.setData(service.create(jsonPayload.getEntity()));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/update")
	ResponseEntity<Response> update(@RequestBody @Validated BankJson jsonPayload) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.UPDATE.value());
		try {
		Optional<BankEntity> optLoan = service.findById(jsonPayload.getId());
		BankEntity entity = new BankEntity();
		
		if(optLoan.isPresent()) {
			entity = optLoan.get();
			entity.setBankName(jsonPayload.getName());
			service.update(jsonPayload.getId(), entity);
		}
		response.setData(entity);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/delete")
	ResponseEntity<Response> delete(@RequestBody @Validated Map<String, String> payload) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.DELETE.value());
		try {
		Optional<BankEntity> optLoan = service.findById(payload.get("id"));
		if(optLoan.isPresent()) {
			service.delete(payload.get("id"));
		}
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
