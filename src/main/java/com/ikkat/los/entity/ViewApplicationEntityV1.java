package com.ikkat.los.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application", schema = "public")
public class ViewApplicationEntityV1 {
	@Id
	@Column(name="applicationid")
	private String applicationID;
	@Column(name="status")
	private String status;
	@Column(name="score")
	private int score;
	private ZonedDateTime createddate;
	private ZonedDateTime modieddate;
	private ZonedDateTime date;
	private String isdraft;
	private long risklevelid;
	private String scorecardcomments;
	private String ruleenginecomments;
	public String getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ZonedDateTime getCreateddate() {
		return createddate;
	}
	public void setCreateddate(ZonedDateTime createddate) {
		this.createddate = createddate;
	}
	public ZonedDateTime getModieddate() {
		return modieddate;
	}
	public void setModieddate(ZonedDateTime modieddate) {
		this.modieddate = modieddate;
	}
	public ZonedDateTime getDate() {
		return date;
	}
	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	public String getIsdraft() {
		return isdraft;
	}
	public void setIsdraft(String isdraft) {
		this.isdraft = isdraft;
	}
	public long getRisklevelid() {
		return risklevelid;
	}
	public void setRisklevelid(long risklevelid) {
		this.risklevelid = risklevelid;
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
	
	
}
