package com.ikkat.los.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;

import com.google.gson.Gson;
import com.ikkat.los.helper.entity.ValidationEntity;

public class MessagesJson {
	
	public static String messagesJson(int code,String body) throws ParseException {
		JSONParser parser = new JSONParser();
		if(!body.equals("")) {
			Object obj = parser.parse(body);
			if(code == HttpStatus.BAD_REQUEST.value()) {
				//{"timestamp":1582254217421,"status":401,"error":"Unauthorized","message":"Bad credentials"}
				JSONObject jsonobj = (JSONObject) obj;
				String error = (String) jsonobj.get("error");
				String message = (String) jsonobj.get("message");
				ValidationEntity validation = new ValidationEntity();
				validation.setErrorparameter(error);
				validation.setErrormessages(error+" : "+message);
				return new Gson().toJson(validation);
			}
		}
		return "";
	}
}
