package com.ikkat.los.roulesscores.entity;

public class RoulesScoresData {
    private Long id;
    private Double minvalue;
    private Double maxvalue;
    private String value;
    private Double valuenumber;
    private int score;
    private String groups;
    private String typeroules;
    private boolean isroulestemplate;
    private String nameroules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMinvalue() {
        return minvalue;
    }

    public void setMinvalue(Double minvalue) {
        this.minvalue = minvalue;
    }

    public Double getMaxvalue() {
        return maxvalue;
    }

    public void setMaxvalue(Double maxvalue) {
        this.maxvalue = maxvalue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Double getValuenumber() {
        return valuenumber;
    }

    public void setValuenumber(Double valuenumber) {
        this.valuenumber = valuenumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public String getTyperoules() {
        return typeroules;
    }

    public void setTyperoules(String typeroules) {
        this.typeroules = typeroules;
    }

    public boolean isIsroulestemplate() {
        return isroulestemplate;
    }

    public void setIsroulestemplate(boolean isroulestemplate) {
        this.isroulestemplate = isroulestemplate;
    }

    public String getNameroules() {
        return nameroules;
    }

    public void setNameroules(String nameroules) {
        this.nameroules = nameroules;
    }
}
