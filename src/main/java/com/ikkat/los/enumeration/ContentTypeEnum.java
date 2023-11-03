package com.ikkat.los.enumeration;

public enum ContentTypeEnum {
	X_WWW_FORM_URLENCODE("x-www-form-urlencoded");
	
	private String value;
	ContentTypeEnum(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
