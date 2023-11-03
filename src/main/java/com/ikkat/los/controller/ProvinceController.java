package com.ikkat.los.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.KodePosEntity;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.DistrictService;
import com.ikkat.los.service.KodePosService;
import com.ikkat.los.service.ProvinceService;
import com.ikkat.los.service.RegenciesService;
import com.ikkat.los.service.SubDistrictService;
import com.ikkat.los.service.UserService;
import com.ikkat.los.utils.Utils;


@RestController
@RequestMapping("/province/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class ProvinceController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProvinceService service;
	@Autowired
	RegenciesService regenciesservice;
	@Autowired
	DistrictService districtservice;
	@Autowired
	KodePosService kodeposservice;
	@Autowired
	SubDistrictService subdistservice;
	@Autowired
	UserService userservice;
	@Autowired
	CompanyService compservice;
	
	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
	
	@GetMapping("/getlist")
	ResponseEntity<Response> getProvinceList(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
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
		LOGGER.info("getlist : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		/* Set Data Dari Database */
		response.setData(service.GetListProvinceNotEmptyIdSimpool());
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@GetMapping("/getlistkota")
	ResponseEntity<Response> getRegenciesList(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
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
		LOGGER.info("getlistkota : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		/* Set Data Dari Database */
		response.setData(regenciesservice.GetListRegenciesNotEmptyIdSimpool());
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@GetMapping("/getlistkecamatan")
	ResponseEntity<Response> getKecamatanList(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
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
		LOGGER.info("getlistkecamatan : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		/* Set Data Dari Database */
		response.setData(districtservice.findAll());
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/getlistkelurahanv1")
	ResponseEntity<Response> getlistkelurahanV1(@RequestBody @Validated Map<String, String> payload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		try {
		String iddistrict = payload.get("iddistrict");
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("getlistkelurahanv1 : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		/* Set Data Dari Database */
		response.setData(subdistservice.GetListByDistrict(iddistrict));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/getlistkelurahan")
	ResponseEntity<Response> getlistkelurahan(@RequestParam("kecamatan") String kecamatan) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		
		/* Set Data Dari Database */
		try {
		response.setData(kodeposservice.listkelurahanbykecamatan(kecamatan));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/getkodepos")
	ResponseEntity<Response> getkodepos(@RequestParam("kecamatan") String kecamatan,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
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
		LOGGER.info("getkodepos : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		List<KodePosEntity> list = kodeposservice.listkelurahanbykecamatan(kecamatan);
		String kodepos = "";
		if(list.size() > 0) {
			kodepos = list.get(0).getKodepos();
		}
		/* Set Data Dari Database */
		response.setData(kodepos);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
