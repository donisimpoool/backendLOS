package com.ikkat.los.enumeration;

public enum StatusFilterEnum {
	PASS("pass"),
	REFER("refer"),
	REJECT("reject");
	private String value;
	StatusFilterEnum(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
