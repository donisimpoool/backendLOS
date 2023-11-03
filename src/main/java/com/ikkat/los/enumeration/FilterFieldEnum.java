package com.ikkat.los.enumeration;

public enum FilterFieldEnum {
	GENDER("gender"),
	EDUCATION("education"),
	MARITALSTATUS("maritalstatus"),
	CURRENTADDRESS("currentaddress"),
	HOUSEOWNERSHIP("houseownership"),
	NUMBEROFCHILDREN("numberofchildren"),
	NETINCOME("netincome"),
	OWNCREDITCARD("owncreditcard"),
	COLLATERALVALUE("collateralvalue"),
	AGE("age"),
	INCOMETYPE("incometype");
	private String value;
	FilterFieldEnum(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
