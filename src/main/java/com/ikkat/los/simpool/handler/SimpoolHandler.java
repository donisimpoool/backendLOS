package com.ikkat.los.simpool.handler;

import java.net.URI;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.ikkat.los.simpool.service.SimpoolService;
import com.ikkat.los.utils.HTTPSCertifiedHelper;

@Service
public class SimpoolHandler implements SimpoolService{
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object loginSimpool(String user, String password) {
		// TODO Auto-generated method stub
		LOGGER.info("loginSimpool Masuk 1 ");
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();   
		headers.set("Fineract-Platform-TenantId", "010006");
//	    headers.set("Authorization", authsimpool);
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    URI uri = HTTPSCertifiedHelper.trustedURL("https://demo.simpool.id/fineract-provider/api/v1/authentication");
	    LOGGER.info("loginSimpool Masuk 2 ");
	    HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("username", "donidemo");
		param.put("password", "Doni1234!");
		Gson gson = new Gson();
		String body = gson.toJson(param);
	    HttpEntity<String> request = new HttpEntity<>(body, headers);
	    LOGGER.info("loginSimpool Masuk 3 ");
	    ResponseEntity<String> result = null;//restTemplate.postForEntity(uri, request, String.class);
	    try {
	    	LOGGER.info("loginSimpool Masuk 4 ");
            result = restTemplate.postForEntity(uri,request, String.class);
            LOGGER.info("loginSimpool Masuk 5 ");
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
	    LOGGER.info("loginSimpool : "+result);
	    
		return bodyReturn;
	}

	

}
