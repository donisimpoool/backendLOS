package com.ikkat.los.enumeration;

public enum OperandEnum {
	EQUALS("="),
	GREATERTHAN(">"),
	GREATEREQUALSTHAN(">="),
	LOWERTHAN("<"),
	LOWEREQUALSTHAN("<=");
	private String value;
	OperandEnum(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
