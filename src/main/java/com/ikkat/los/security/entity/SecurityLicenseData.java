package com.ikkat.los.security.entity;

import com.ikkat.los.shared.ReturnData;

public class SecurityLicenseData {
	private LicenseData licenseData;
	private ReturnData returnData;
	public LicenseData getLicenseData() {
		return licenseData;
	}
	public void setLicenseData(LicenseData licenseData) {
		this.licenseData = licenseData;
	}
	public ReturnData getReturnData() {
		return returnData;
	}
	public void setReturnData(ReturnData returnData) {
		this.returnData = returnData;
	}
	
}
