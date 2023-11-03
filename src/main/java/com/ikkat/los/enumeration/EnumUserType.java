package com.ikkat.los.enumeration;

public enum EnumUserType {
	ADMIN("admin"),
	USER("user");
	private String value;
	EnumUserType(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
