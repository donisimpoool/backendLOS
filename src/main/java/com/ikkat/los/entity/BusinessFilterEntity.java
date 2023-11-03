package com.ikkat.los.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_business_filter")
public class BusinessFilterEntity {
	public BusinessFilterEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bf_id")
	private Long id;

	@Column(name = "bf_name")
	private String name;

	@Column(name = "bf_description")
	private String description;
	
	@Column(name = "last_updated")
	private ZonedDateTime lastUpdated;
	
	@Column(name = "bf_classname")
	private String className;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ZonedDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(ZonedDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
