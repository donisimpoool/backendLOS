package com.ikkat.los.utils;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryptor {
	public static boolean checkEncrypt(String text,String textencrypt) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		return true;//encoder.matches(text, textencrypt);
	}
	public static String encrypt(String text) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		return "";//encoder.encode(text);
	}
}
