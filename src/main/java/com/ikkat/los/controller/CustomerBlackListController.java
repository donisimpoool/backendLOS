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

import com.ikkat.los.entity.CustomerBlacklistEntity;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.jsonmodel.CustomerBlacklistJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CustomerBlacklistService;
import com.ikkat.los.service.CustomerService;

@RestController
@RequestMapping("/customer/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class CustomerBlackListController {
	@Autowired
	CustomerBlacklistService customerBlacklistService;
	@Autowired
	CustomerService customerService;

	@PostMapping("/blacklist/create")
	ResponseEntity<Response> create(@RequestBody @Validated CustomerBlacklistJson jsonPayload) {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

		/* Memanggil Class Response yang telah dibuat */
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.CREATE.value());

		if (customerService.findById(jsonPayload.getCustomerId()).isPresent()) {
			/* Set Data Dari Database */
			response.setData(customerBlacklistService.create(jsonPayload.getEntity()));
		}else {
			response.setMessage("Customer "+MessageEnum.ID_NOT_EXIST.value());
			response.setData(new CustomerBlacklistEntity());
		}

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

	@PostMapping("/blacklist/update")
	ResponseEntity<Response> update(@RequestBody @Validated CustomerBlacklistJson jsonPayload) {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

		/* Memanggil Class Response yang telah dibuat */
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.UPDATE.value());

		/* Set Data Dari Database */
		response.setData(customerBlacklistService.update(jsonPayload.getBlacklistId(), jsonPayload.getEntity()));

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

	@PostMapping("/blacklist/delete")
	ResponseEntity<Response> delete(@RequestBody @Validated CustomerBlacklistJson jsonPayload) {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.DELETE.value());

		/* Set Data Dari Database */
		response.setData(customerBlacklistService.findById(jsonPayload.getBlacklistId()).get());
		customerBlacklistService.delete(jsonPayload.getBlacklistId());

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

	@GetMapping("/blacklist")
	ResponseEntity<Response> getBlackList() {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");

		/* Set Data Dari Database */
		response.setData(customerBlacklistService.findAll());

		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
