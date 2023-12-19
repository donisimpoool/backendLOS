package com.ikkat.los.utils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.util.HashMap;

//import javax.xml.ws.http.HTTPException;

import org.apache.http.client.HttpResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.ikkat.los.helper.entity.ValidationEntity;
import com.ikkat.los.validation.Validation;

public class CallApiSimpool {
	
	private RestTemplate restTemplate;
	public CallApiSimpool() {
		restTemplate = new RestTemplate();
	}
	
	
	public HashMap<String, Object> resultPostFormData (HashMap<String, Object> param){
		String url = (String) param.get("url");
		String tenantid = (String) param.get("tenantid");
		MultiValueMap<String, Object> map = (MultiValueMap<String, Object>) param.get("formdata"); 
		HttpHeaders headers = new HttpHeaders();   
		headers.set("Fineract-Platform-TenantId", tenantid);
	    headers.setContentType(MediaType.MULTIPART_FORM_DATA);
	    URI uri = HTTPSCertifiedHelper.trustedURL(url);
	    
	    HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);
	    ResponseEntity<String> result = null;
	    try {
            result = restTemplate.postForEntity(uri, request, String.class);
        }catch(HttpClientErrorException e) {
            result = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
        }catch(HttpServerErrorException e) {
            result = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }catch(Exception e) {
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }
	    int code = result.getStatusCodeValue();
	    String bodyReturn = result.getBody();
	    HashMap<String, Object> mapreturn = new HashMap<String, Object>();
	    mapreturn.put("code", result.getStatusCodeValue());
	    mapreturn.put("body", bodyReturn);
	    return mapreturn;
	}
	
	public HashMap<String, Object> resultPost (HashMap<String, Object> param){
		String url = (String) param.get("url");
		String body = (String) param.get("body");
		String tenantid = (String) param.get("tenantid");
		String authsimpool = (String) param.get("authsimpool");
		String userauth = (String) param.get("userauth");
		String passauth = (String) param.get("passauth");
		
		HttpHeaders headers = new HttpHeaders();   
		headers.set("Fineract-Platform-TenantId", tenantid);
	    headers.set("Authorization", authsimpool);
	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    headers.setBasicAuth(userauth, passauth);
	    int code = 0;
	    String bodyReturn = "";
	    URI uri = HTTPSCertifiedHelper.trustedURL(url);
	    HttpEntity<String> request = new HttpEntity<>(body, headers);
	    ResponseEntity<String> result = null;//restTemplate.postForEntity(uri, request, String.class);
	    try {
            result = restTemplate.postForEntity(uri,request, String.class);
        }catch(HttpClientErrorException e) {
            result = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
        }catch(HttpServerErrorException e) {
            result = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }catch(Exception e) {
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }
	    code = result.getStatusCodeValue();
	    bodyReturn = result.getBody();
	    HashMap<String, Object> mapreturn = new HashMap<String, Object>();
	    mapreturn.put("code", result.getStatusCodeValue());
	    mapreturn.put("body", bodyReturn);
	    return mapreturn;
	}
	
	public HashMap<String, Object> resultGet (HashMap<String, Object> param){
		String url = (String) param.get("url");
		MultiValueMap<String, String> queryparam = (MultiValueMap<String, String>) param.get("queryparam");
		String tenantid = (String) param.get("tenantid");
		String authsimpool = (String) param.get("authsimpool");
		String userauth = (String) param.get("userauth");
		String passauth = (String) param.get("passauth");
//		System.out.println("userauth : "+userauth);
//		System.out.println("passauth : "+passauth);
		HttpHeaders headers = new HttpHeaders();   
	    headers.set("Fineract-Platform-TenantId", tenantid);
	    headers.set("Authorization", authsimpool);
//	    headers.setBasicAuth(userauth, passauth);
	    HttpEntity request = new HttpEntity(headers);
	    
	    URI uri = UriComponentsBuilder.fromUri(HTTPSCertifiedHelper.trustedURL(url))
	    		.queryParams(queryparam).build().toUri();
	    ResponseEntity<String> result = null;
	    int code = 0;
	    String body = "";
	    try {
            result = restTemplate.exchange(
    	    		uri,
    	            HttpMethod.GET,
    	            request,
    	            String.class
    	    );
        }catch(HttpClientErrorException e) {
            result = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
        }catch(HttpServerErrorException e) {
            result = new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }catch(RestClientException e) {
        	if (e.getCause() instanceof ConnectException) {
        		code = HttpStatus.NO_CONTENT.value();
            	ValidationEntity valid = new ValidationEntity();
    	    	valid.setErrorparameter("serversimpoolerror");
    	    	valid.setErrormessages("something happened to the simpool server");
    	    	body = new Gson().toJson(valid);
    	    	
    	    	HashMap<String, Object> mapreturn = new HashMap<String, Object>();
    		    mapreturn.put("code", code);
    		    mapreturn.put("body", body);
    		    return mapreturn;
        	}
        	
            throw e;
        }catch(Exception e) {
            result = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            throw e;
        }
	    code = result.getStatusCodeValue();
	    body = result.getBody();
	    HashMap<String, Object> mapreturn = new HashMap<String, Object>();
	    mapreturn.put("code", result.getStatusCodeValue());
	    mapreturn.put("body", body);
//	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	    return mapreturn;
	}
}
