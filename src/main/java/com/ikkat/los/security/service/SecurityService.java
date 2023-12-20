package com.ikkat.los.security.service;


import com.ikkat.los.security.entity.AuthorizationEntity;
import com.ikkat.los.security.entity.SecurityLicenseData;
import com.ikkat.los.shared.Response;

public interface SecurityService {
	AuthorizationEntity checking(String codepermission, String authorization);
	Response response(String codepermission, Object data, String authorization);
	String passwordToken(String username,String password);
	SecurityLicenseData checkLicense(long idcompany, Long jumlahuserweb, Long jumlahusermobile);
}
