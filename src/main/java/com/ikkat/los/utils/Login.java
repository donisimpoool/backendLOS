package com.ikkat.los.utils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import com.ikkat.los.helper.entity.ActiveUserEntity;

public class Login {
	private static String putmap(String userid,String ip) {
		Date dt = new Date();
		Timestamp date = new Timestamp(dt.getTime());
		String value = "";
		ActiveUserEntity active = new ActiveUserEntity();
		active.setUserid(userid);
		active.setIp(ip);
		active.setTimelogin(date);
		active.setTimeexpired(date);
		TempStorage.hash.put(userid, active);
		return value;
	}
	public static HashMap<String, Object> checkmap(String userid,String ip) {
		HashMap<String, Object> mapreturn = new HashMap<String, Object>();
		boolean flag = true;
		String msg = "";
		if(TempStorage.hash.get(userid) != null) {
			ActiveUserEntity active = TempStorage.hash.get(userid);
			if(!active.getIp().equals(ip)) {
				flag = false;
				msg = "User Sedang Dipakai";
			}
		}else {
//			putmap(userid, ip);
		}
		mapreturn.put("flag", flag);
		mapreturn.put("msg", msg);
		return mapreturn;
	}
	
	public static String logout(String userid,String ip) {
		String value = "";
		if(TempStorage.hash.get(userid) != null) {
			TempStorage.hash.remove(userid);
		}
		return value;
	}
}
