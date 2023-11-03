package com.ikkat.los.enumeration;

public enum DateFormatEnum {
	FORMAT_DATE_WITH_ZONE("yyyy-MM-dd HH:mm:ss a z"),
	FORMAT_DATE("yyyy-MM-dd"),
	FORMAT_DD_MM_YYYY("dd-MM-yyyy"),
	FORMAT_DATE_MONTH("dd-MMM-yyyy HH:mm"),
	FORMAT_DATE_FULL_NAME_MONTH("dd-MMMM-yyyy");
	private String value;
	DateFormatEnum(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
