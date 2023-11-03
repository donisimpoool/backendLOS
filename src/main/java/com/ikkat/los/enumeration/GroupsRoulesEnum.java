package com.ikkat.los.enumeration;

public enum GroupsRoulesEnum {
	AGE("age"),
	GENDER("gender"),
	NUMBEROFDEPENDANT("numberofdependant"),
	EDUCATION("education"),
	COMPANYSIZE("companysize"),
	INDUSTRYSECTOR("industrysector"),
	JOBTITTLE("jobtittle"),
	DURATIONWORK("durationwork"),
	INCOMETYPE("incometype"),
	PROPERTYPOSSESSION("propertypossession"),
	DEBTINCOMERATIO("debtincomeratio"),
	CREDITCARDOWNER("creditcardowner"),
	LIVEOWNERSHIPSTATUS("liveownershipstatus"),
	LOCATION("location"),
	VEHICLEOWNER("vehicleowner"),
	POSITIONS("positions"),
	MARITALSTATUS("maritalstatus");
	private String value;
	GroupsRoulesEnum(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
