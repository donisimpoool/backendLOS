package com.ikkat.los.enumeration;

public enum TypeCollateral {
	REALESTATE("REALESTATE"),
	VEHICLE("VEHICLE"),
	DEPOSIT("DEPOSIT");
	private String value;
	TypeCollateral(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
