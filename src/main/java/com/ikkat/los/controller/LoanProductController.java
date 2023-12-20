package com.ikkat.los.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.JSpinner.DateEditor;

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

import com.ikkat.los.entity.LoanProductEntity;
import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.helper.entity.DoghnutChartData;
import com.ikkat.los.helper.entity.GraphBarByMonths;
import com.ikkat.los.helper.entity.LoanRangeSize;
import com.ikkat.los.helper.entity.LoanTopFive;
import com.ikkat.los.jsonmodel.BusinessFilterJson;
import com.ikkat.los.jsonmodel.CustomerJson;
import com.ikkat.los.jsonmodel.LoanProductJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.LoanProductService;
//import com.ikkat.los.service.UserService;
import com.ikkat.los.utils.Utils;

import javassist.expr.NewArray;

@RestController
@RequestMapping("/loan/products/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class LoanProductController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	LoanProductService service;
//	@Autowired
//	UserService userservice;
	@Autowired
	CompanyService compservice;
	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

	@GetMapping("/getlist")
	ResponseEntity<Response> getLoanProductList(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

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
		response.setData(service.getListLoanProductByIsActive("Y"));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

	@GetMapping("/getlistgraph")
	ResponseEntity<Response> getLoanListGraph(@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {

		System.out.println(new Date() + " get List Product");
		/* Informasi Tentang Nama Method */
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();

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
		LOGGER.info("getlistgraph : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}

		/* Set Data Dari Database */
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("graph", new GraphBarByMonths().listgraphs(service));
		map.put("donuts", new DoghnutChartData().setdata(service));
		response.setData(map);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/create")
	ResponseEntity<Response> create(@RequestBody @Validated LoanProductJson jsonPayload) {

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
	ResponseEntity<Response> update(@RequestBody @Validated LoanProductJson jsonPayload) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage(MessageEnum.UPDATE.value());
		try {
		Optional<LoanProductEntity> optLoan = service.findById(jsonPayload.getId());
		LoanProductEntity entity = new LoanProductEntity();
		
		if(optLoan.isPresent()) {
			entity = optLoan.get();
//			entity.setDefaultamount(jsonPayload.getDefaultamount());
//			entity.setDefaulttenor(jsonPayload.getDefaulttenor());
			entity.setFilterid_h(jsonPayload.getFilterid());
//			entity.setLoanDescription(jsonPayload.getDescription());
//			entity.setLoanName(jsonPayload.getName());
//			entity.setMaxamount(jsonPayload.getMaxamount());
//			entity.setMinamount(jsonPayload.getMinamount());
//			entity.setMaxtenor(jsonPayload.getMaxtenor());
//			entity.setMintenor(jsonPayload.getMintenor());
			service.update(jsonPayload.getId(), entity);
		}
		
		
		response.setData(service.create(jsonPayload.getEntity()));
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
		try {
		Optional<LoanProductEntity> optLoan = service.findById(payload.get("id"));
		if(optLoan.isPresent()) {
			service.delete(payload.get("id"));
		}
		
		response.setMessage(MessageEnum.DELETE.value());
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}

	@PostMapping("/getlisttopfive")
	ResponseEntity<Response> listtopfive(@RequestBody @Validated Map<String, Object> payload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		String bulan = (String) payload.get("bulan");
		HashMap<String, Object> data = new HashMap<String, Object>();
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
		LOGGER.info("getlisttopfive : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		if (!bulan.equals("0")) {
			int kalibln = new Integer(bulan) * 30;
			int jmldate = -kalibln;

			Date thru = new Date();
			String strdate = Utils.DateToString(thru, DateFormatEnum.FORMAT_DATE.value());
			thru = Utils.StringToDate(strdate, DateFormatEnum.FORMAT_DATE.value());

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(thru.getTime());
			cal.add(Calendar.DATE, jmldate);

			Date from = cal.getTime();
			strdate = Utils.DateToString(from, DateFormatEnum.FORMAT_DATE.value());
			from = Utils.StringToDate(strdate, DateFormatEnum.FORMAT_DATE.value());

			/* Memanggil Class Response yang telah dibuat */
			java.sql.Date sqlfrom = new java.sql.Date(from.getTime());
			java.sql.Date sqlthru = new java.sql.Date(thru.getTime());
			response.setData(new LoanTopFive().SetLoanTopFive(service.loanProductTopFive(sqlfrom, sqlthru)));
			
		}else {
			response.setData(new LoanProductEntity());
		}
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@PostMapping("/getlistrangesize")
	ResponseEntity<Response> listrangesize(@RequestBody @Validated Map<String, Object> payload,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform) {
		String bulan = (String) payload.get("bulan");
		HashMap<String, Object> data = new HashMap<String, Object>();
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
		LOGGER.info("getlisttopfive : "+flagauth);
		
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		if (!bulan.equals("0")) {
			int kalibln = new Integer(bulan) * 30;
			int jmldate = -kalibln;

			Date thru = new Date();
			String strdate = Utils.DateToString(thru, DateFormatEnum.FORMAT_DATE.value());
			thru = Utils.StringToDate(strdate, DateFormatEnum.FORMAT_DATE.value());

			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(thru.getTime());
			cal.add(Calendar.DATE, jmldate);

			Date from = cal.getTime();
			strdate = Utils.DateToString(from, DateFormatEnum.FORMAT_DATE.value());
			from = Utils.StringToDate(strdate, DateFormatEnum.FORMAT_DATE.value());

			/* Memanggil Class Response yang telah dibuat */
			java.sql.Date sqlfrom = new java.sql.Date(from.getTime());
			java.sql.Date sqlthru = new java.sql.Date(thru.getTime());
			
			double appAll = service.jumlahapplicant(sqlfrom, sqlthru);
			double appApprove = service.jumlahapplicantbystatus(sqlfrom, sqlthru, "A");
			double appUnderwriting = service.jumlahapplicantbystatus(sqlfrom, sqlthru, "U");
			
			response.setData(new LoanRangeSize().SetLoanRangeSize(service.loanRangeSize(sqlfrom, sqlthru),appAll,appUnderwriting,appApprove));
			
		}else {
			response.setData(new LoanRangeSize());
		}
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
}
