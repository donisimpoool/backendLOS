package com.ikkat.los.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHelper {
		public static Object ConvertStringToJson(String strjson) throws ParseException {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(strjson);
			return obj;
		}
}
