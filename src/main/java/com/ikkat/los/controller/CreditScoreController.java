package com.ikkat.los.controller;


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

import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.jsonmodel.CreditScoreJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CreditScoreService;

@RestController
@RequestMapping("/loan/creditscore/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class CreditScoreController {

	@Autowired
	CreditScoreService creditSocerservice;
	private String service = "CreditScore";

	@PostMapping("/create")
	ResponseEntity<Response> create(@RequestBody @Validated CreditScoreJson jsonPayload) {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

		/* Memanggil Class Response yang telah dibuat */
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.CREATE.value());

		/* Set Data Dari Database */
		response.setData(creditSocerservice.create(jsonPayload.getCs()));

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

	@PostMapping("/update")
	ResponseEntity<Response> update(@RequestBody @Validated CreditScoreJson jsonPayload) {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

		/* Memanggil Class Response yang telah dibuat */
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.UPDATE.value());

		/* Set Data Dari Database */
		response.setData(creditSocerservice.update(jsonPayload.getId(), jsonPayload.getCs()));

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);

	}

	@PostMapping("/delete")
	ResponseEntity<Response> delete(@RequestBody @Validated CreditScoreJson jsonPayload) {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.DELETE.value());

		/* Set Data Dari Database */
		response.setData(creditSocerservice.findById(jsonPayload.getId()).get());
		creditSocerservice.delete(jsonPayload.getId());

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@GetMapping("/")
	ResponseEntity<Response> findCreditScores() {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");

		/* Set Data Dari Database */
		response.setData(creditSocerservice.findAll());
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

}
