package com.ikkat.los.jsonmodel;

import com.ikkat.los.entity.RiskLevelEntity;
import com.ikkat.los.utils.Utils;

public class RiskLevelJson {
	private long id;
	private String name;
	private String odds;
	private String probabilityofdefault;
	private String min;
	private String max;
	private String status;
	
	public RiskLevelEntity getEntity() {
		String str = String.valueOf(Utils.generateNumber());
		long riskid = new Long(str).longValue();
		RiskLevelEntity risklvl = new RiskLevelEntity();
		risklvl.setId(riskid);
		risklvl.setMax(new Double(this.max));
		risklvl.setMin(new Double(this.min));
		risklvl.setNamerisk(this.name);
		risklvl.setOdds(this.odds);
		risklvl.setProbabilityofdefault(new Double(this.probabilityofdefault));
		risklvl.setStatus(this.status);
		
		return risklvl;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOdds() {
		return odds;
	}
	public void setOdds(String odds) {
		this.odds = odds;
	}
	public String getProbabilityofdefault() {
		return probabilityofdefault;
	}
	public void setProbabilityofdefault(String probabilityofdefault) {
		this.probabilityofdefault = probabilityofdefault;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getMax() {
		return max;
	}
	public void setMax(String max) {
		this.max = max;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
