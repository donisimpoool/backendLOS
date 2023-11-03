package com.ikkat.los.entity.roulesscore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roulesscore", schema = "public")
public class RoulesScoreMaxEntity {
	@Id
	private long id;
	private String groups;
	private double maxscore;
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public double getMaxscore() {
		return maxscore;
	}
	public void setMaxscore(double maxscore) {
		this.maxscore = maxscore;
	}
}
