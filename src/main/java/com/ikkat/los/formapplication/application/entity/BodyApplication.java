package com.ikkat.los.formapplication.application.entity;

import java.sql.Date;

public class BodyApplication {
    private String status;
    private long score;
    private boolean isdraft;
    private long idrisklevel;
    private String scorecardcomments;
    private String ruleenginecomments;
    private boolean isexport;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public boolean isIsdraft() {
        return isdraft;
    }

    public void setIsdraft(boolean isdraft) {
        this.isdraft = isdraft;
    }

    public long getIdrisklevel() {
        return idrisklevel;
    }

    public void setIdrisklevel(long idrisklevel) {
        this.idrisklevel = idrisklevel;
    }

    public String getScorecardcomments() {
        return scorecardcomments;
    }

    public void setScorecardcomments(String scorecardcomments) {
        this.scorecardcomments = scorecardcomments;
    }

    public String getRuleenginecomments() {
        return ruleenginecomments;
    }

    public void setRuleenginecomments(String ruleenginecomments) {
        this.ruleenginecomments = ruleenginecomments;
    }

    public boolean isIsexport() {
        return isexport;
    }

    public void setIsexport(boolean isexport) {
        this.isexport = isexport;
    }
}
