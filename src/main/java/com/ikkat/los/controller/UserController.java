package com.ikkat.los.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikkat.los.entity.LogEntity;
import com.ikkat.los.entity.MenuHeaderEntity;
import com.ikkat.los.entity.UserEntity;
import com.ikkat.los.enumeration.EnumUserType;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.helper.entity.InfoUser;
import com.ikkat.los.helper.entity.ListMenu;
import com.ikkat.los.helper.entity.Menu;
import com.ikkat.los.jsonmodel.UserJson;
import com.ikkat.los.response.Response;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.LogService;
import com.ikkat.los.service.MenuHeaderService;
import com.ikkat.los.service.MenuItemsService;
import com.ikkat.los.service.UserService;
import com.ikkat.los.utils.Encryptor;
import com.ikkat.los.utils.Login;
import com.ikkat.los.utils.Utils;

@RestController
@RequestMapping("/user/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class UserController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService service;
	@Autowired
	MenuHeaderService menuheaderservice;
	@Autowired
	MenuItemsService menuitemsservice;
	@Autowired
	LogService logservice;
	@Autowired
	UserService userservice;
	@Autowired
	CompanyService compservice;
	
	static HttpServletRequest request;
	@Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
	
	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
	
	@PostMapping("/login")
	ResponseEntity<Response> login(@RequestBody @Validated Map<String, String> payload,@RequestHeader("Authorization") String Authorization ) throws IOException {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		try {
		String userid =  payload.get("userid");
		String password =  payload.get("password");
		//$2a$12$NUdIMheNegacJOE6G6vyBuqQZvXlsXRZBm6lFHCJLrA5UdQkDyxaS = 123456
		
		String msg = "";
		String data = "";
		UserEntity user = service.login(userid);
		InfoUser infouser = new InfoUser();
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", "");
		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		paramauth.put("login", "");
		
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("login : "+flagauth);
		if(!flagauth) {
			response.setMessage("User not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
//		System.out.println(" Encryptor : "+Encryptor.encrypt("123456"));
		if(user == null) {
			msg = "User Tidak Tersedia";
		}else {
			if(!Encryptor.checkEncrypt(password, user.getPassword())) {
				msg = "Password Tidak Sesuai";
			}else {
				data = "200";
				HashMap<String, Object> map = Login.checkmap(userid, Utils.getClientIp(request));
				boolean flag = (boolean) map.get("flag");
				if(flag) {
					msg = userid;
					
					infouser.setCode(new Integer(data));
					List<MenuHeaderEntity> listMH = menuheaderservice.getListMenuHeader(user.getLevel(), user.getUsertype());
					String firsttoute = "";
					List<ListMenu> templistmenu = new ArrayList<ListMenu>();
					for(MenuHeaderEntity mh : listMH) {
						ListMenu list = new ListMenu().setlist(mh, menuitemsservice, user.getLevel());
						templistmenu.add(list);
						if(firsttoute.equals("")) {
							firsttoute = list.getFirstrouteopen();
						}
					}
					Menu menu = new Menu();
					menu.setItems(templistmenu);
					infouser.setName(user.getName());
					infouser.setLimitsizefile(user.getLimitsizefile());
					infouser.setIsapproval(user.getIsapproval());
					infouser.setLevel(user.getLevel());
					infouser.setItems(menu);
					infouser.setFirstroute(firsttoute);
					infouser.setCompanyid(user.getCompanyid());
					infouser.setIdtable(user.getId());
					LogEntity log = new LogEntity();
					log.setAction("LOGIN");
					log.setDate(new Timestamp(new Date().getTime()));
					log.setDescription("Melakukan Login");
					log.setIp(Utils.getClientIp(request));
					log.setUserid(userid);
					logservice.create(log);
				}else {
					msg = (String) map.get("msg");
				}
			}
		}
		/* Set Data Dari Database */
		response.setMessage(msg);
		response.setData(infouser);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@GetMapping("/logout")
	ResponseEntity<Response> logout(@RequestParam String userid) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		try {
		String msg = "";
		String data = "";
		Login.logout(userid, "");
		
		LogEntity log = new LogEntity();
		log.setAction("LOGOUT");
		log.setDate(new Timestamp(new Date().getTime()));
		log.setDescription("Melakukan Logout");
		log.setIp(Utils.getClientIp(request));
		log.setUserid(userid);
		logservice.create(log);
		/* Set Data Dari Database */
		response.setMessage(msg);
		response.setData(data);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@GetMapping("/getlistuserbyusertype")
	ResponseEntity<Response> listuser() {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		String msg = "";
		String data = "";
		
		/* Set Data Dari Database */
		response.setMessage(msg);
		response.setData(service.getListByUserType(EnumUserType.USER.value()));
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	@DeleteMapping("/deletes")
	ResponseEntity<Response> deletee(@RequestBody @Validated Map<String, String> payload) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		String msg = "";
		String data = "";
		String userid = payload.get("userid");
		Login.logout(userid, "");
		/* Set Data Dari Database */
		response.setMessage(msg);
		response.setData(service.getListByUserType(EnumUserType.USER.value()));
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/create")
	ResponseEntity<Response> create(@RequestBody @Validated UserJson jsonPayload) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		response.setData("");
		try {
		if(!jsonPayload.getCreated().equals("")) {
			UserEntity user = service.login(jsonPayload.getCreated());
			if(user != null) {
				if(user.getUsertype().equals(EnumUserType.ADMIN.value())) {
					response.setMessage(MessageEnum.CREATE.value());
					response.setData(service.create(jsonPayload.setvalue()));
					
					LogEntity log = new LogEntity();
					log.setAction("CREATE");
					log.setDate(new Timestamp(new Date().getTime()));
					log.setDescription("Create User");
					log.setIp(Utils.getClientIp(request));
					log.setUserid(jsonPayload.getCreated());
					logservice.create(log);
				}
			}
			
		}
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/update")
	ResponseEntity<Response> update(@RequestBody @Validated UserJson jsonPayload) {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		response.setMessage("");
		response.setData("");
		try {
		if(!jsonPayload.getCreated().equals("")) {
			UserEntity user = service.login(jsonPayload.getCreated());
			if(user != null) {
				if(user.getUsertype().equals(EnumUserType.ADMIN.value())) {
					response.setMessage(MessageEnum.UPDATE.value());
					Optional<UserEntity> optUserEntity = service.findById(jsonPayload.getId());
					if(optUserEntity.isPresent()) {
						UserEntity tempuser = optUserEntity.get();
						tempuser.setIsapproval(jsonPayload.getIsapproval());
						tempuser.setLevel(new Integer(jsonPayload.getLevel()));
						tempuser.setName(jsonPayload.getName());
						tempuser.setUserid(jsonPayload.getUserid());
						service.update(tempuser.getId(), tempuser);
						
						LogEntity log = new LogEntity();
						log.setAction("UPDATE");
						log.setDate(new Timestamp(new Date().getTime()));
						log.setDescription("Mengubah User "+jsonPayload.getId());
						log.setIp(Utils.getClientIp(request));
						log.setUserid(jsonPayload.getCreated());
						logservice.create(log);
					}
					response.setData("");
				}
			}
			
		}
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/delete")
	ResponseEntity<Response> delete(@RequestBody @Validated Map<String, String> payload) {
		Long id = new Long(payload.get("id"));
		String create = payload.get("create");
		
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		
		try {
		UserEntity user = service.login(create);
		if(user != null) {
			if(user.getUsertype().equals(EnumUserType.ADMIN.value())) {
				response.setMessage(MessageEnum.DELETE.value());
				Optional<UserEntity> optUserEntity = service.findById(id);
				if(optUserEntity.isPresent()) {
					Login.logout(optUserEntity.get().getUserid(), "");
					
					LogEntity log = new LogEntity();
					log.setAction("DELETE SESSION");
					log.setDate(new Timestamp(new Date().getTime()));
					log.setDescription("Delete SESSION User "+optUserEntity.get().getUserid());
					log.setIp(Utils.getClientIp(request));
					log.setUserid(create);
					logservice.create(log);
				}
			}
		}
		response.setData("");
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	@PostMapping("/maskdmajjjajajn")
	ResponseEntity<Response> tes(@RequestBody @Validated Map<String, String> payload,@RequestHeader("Authorization") String Authorization ) throws IOException {
		Response response = new Response();
		response.setService(this.getClass().getName() + nameofCurrMethod);
		try {
		String userid =  payload.get("userid");
		String password =  payload.get("password");
		Encryptor enc = new Encryptor();
		
//		
//		String msg = "";
//		String data = "";
//		UserEntity user = service.login(userid);
//		InfoUser infouser = new InfoUser();
//		HashMap<String, Object> paramauth = new HashMap<String, Object>();
//		paramauth.put("auth", Authorization);
//		paramauth.put("platform", "");
//		paramauth.put("userservice", userservice);
//		paramauth.put("companyservice", compservice);
//		paramauth.put("login", "");
//		
//		boolean flagauth = Utils.CheckAuth(paramauth);
//		LOGGER.info("login : "+flagauth);
//		if(!flagauth) {
//			response.setMessage("User not authenticated");
//			response.setData("");
//			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
//		}
//		
//		if(user == null) {
//			msg = "User Tidak Tersedia";
//		}else {
//			if(!Encryptor.checkEncrypt(password, user.getPassword())) {
//				msg = "Password Tidak Sesuai";
//			}else {
//				data = "200";
//				HashMap<String, Object> map = Login.checkmap(userid, Utils.getClientIp(request));
//				boolean flag = (boolean) map.get("flag");
//				if(flag) {
//					msg = userid;
//					
//					infouser.setCode(new Integer(data));
//					List<MenuHeaderEntity> listMH = menuheaderservice.getListMenuHeader(user.getLevel(), user.getUsertype());
//					String firsttoute = "";
//					List<ListMenu> templistmenu = new ArrayList<ListMenu>();
//					for(MenuHeaderEntity mh : listMH) {
//						ListMenu list = new ListMenu().setlist(mh, menuitemsservice, user.getLevel());
//						templistmenu.add(list);
//						if(firsttoute.equals("")) {
//							firsttoute = list.getFirstrouteopen();
//						}
//					}
//					Menu menu = new Menu();
//					menu.setItems(templistmenu);
//					infouser.setName(user.getName());
//					infouser.setLimitsizefile(user.getLimitsizefile());
//					infouser.setIsapproval(user.getIsapproval());
//					infouser.setLevel(user.getLevel());
//					infouser.setItems(menu);
//					infouser.setFirstroute(firsttoute);
//					infouser.setCompanyid(user.getCompanyid());
//					infouser.setIdtable(user.getId());
//					LogEntity log = new LogEntity();
//					log.setAction("LOGIN");
//					log.setDate(new Timestamp(new Date().getTime()));
//					log.setDescription("Melakukan Login");
//					log.setIp(Utils.getClientIp(request));
//					log.setUserid(userid);
//					logservice.create(log);
//				}else {
//					msg = (String) map.get("msg");
//				}
//			}
//		}
		/* Set Data Dari Database */
		response.setMessage(enc.encrypt(password));
		response.setData(null);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
	}
	
	
}
