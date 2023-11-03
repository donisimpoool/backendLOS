package com.ikkat.los.jsonmodel;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.ikkat.los.entity.CreditScoreEntity;
import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.utils.Utils;

//import id.ikkat.los.engine.application.creditscore.model.db.entity.CreditScoreCharacteristicEntity;
//import id.ikkat.los.engine.application.creditscore.model.db.entity.CreditScoreEntity;
//import id.ikkat.los.engine.util.Utils;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;


public class CreditScoreJson {
	@ApiModelProperty(value = "credit score id. Leave out when creating new credit score")
	@JsonProperty(value = "id")
	private Long id;
	
	@ApiModelProperty(value = "name of credit score. Must be unique")
	@JsonProperty(value = "name")
	private String name;
	
	@JsonProperty(value = "description")
	private String description;
	
//	@ApiModelProperty(accessMode = AccessMode.READ_ONLY)
//	@JsonProperty(access = Access.READ_ONLY)
	
	@JsonProperty(value = "last_updated")
	private String lastUpdated;
	
//	@ApiModelProperty(hidden = true)
//	@JsonProperty(access = Access.READ_ONLY)
	@JsonProperty(value = "creditScoreClassName")
	private String creditScoreClassName;
	
//	@ApiModelProperty(required = true)
//	private List<CreditScoreConditionJson> conditions;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public CreditScoreEntity getCs() {
		CreditScoreEntity cs = new CreditScoreEntity();
		cs.setId(this.id);
		cs.setName(this.name);
		cs.setDescription(this.description);
		cs.setCreditScoreClassName(this.getCreditScoreClassName());
		cs.setLastUpdated(Utils.stringToZonedDateTime(this.lastUpdated));
		return cs;
	}


	public void setCreditScoreClassName(String creditScoreClassName) {
		this.creditScoreClassName = creditScoreClassName;
	}

	public CreditScoreJson() {
		super();
	}

	public CreditScoreJson(Long id, String name, String description, String lastUpdated,
			String creditScoreClassName) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.lastUpdated = lastUpdated;
		this.creditScoreClassName = creditScoreClassName;
//		this.conditions = conditions;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public String getCreditScoreClassName() {
		return creditScoreClassName;
	}

//	public List<CreditScoreConditionJson> getConditions() {
//		return conditions;
//	}
}
