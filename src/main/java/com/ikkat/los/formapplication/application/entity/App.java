package com.ikkat.los.formapplication.application.entity;

import com.ikkat.los.risklevel.entity.RiskLevelApprovalData;

public class App {
    private RiskLevelApprovalData risklevel;
    private String documentapp; //null
    private int score;
    private String scorecardcomments;
    private String ruleenginecomments;

    public String getDocumentapp() {
        return documentapp;
    }

    public void setDocumentapp(String documentapp) {
        this.documentapp = documentapp;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public RiskLevelApprovalData getRisklevel() {
        return risklevel;
    }

    public void setRisklevel(RiskLevelApprovalData risklevel) {
        this.risklevel = risklevel;
    }
}
