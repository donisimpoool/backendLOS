package com.ikkat.los.enumeration;

public enum TypeRoules {
	RANGE("range"),
	EQUALS_NUMBER("equalsnumber"),
	EQUALS("equals");
	private String value;
	TypeRoules(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
