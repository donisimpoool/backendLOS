package com.ikkat.los.formapplication.application.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "formapplication", schema = "public")
public class Application implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="formapplication_id_seq")
    private Long id;
    private long idcompany;
    private String status;
    private long score;
    private Date dateform;
    private boolean isdraft;
    private long idrisklevel;
    private String scorecardcomments;
    private String ruleenginecomments;
    private boolean isexport;
    private long createdby;
    private Timestamp createddate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(long idcompany) {
        this.idcompany = idcompany;
    }

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

    public Date getDateform() {
        return dateform;
    }

    public void setDateform(Date dateform) {
        this.dateform = dateform;
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

    public long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(long createdby) {
        this.createdby = createdby;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }
}
