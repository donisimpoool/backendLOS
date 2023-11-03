package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "application_document", schema = "public")
public class ApplicationDocumentEntity implements Serializable{
	
	@Id
	private String applicationid;
	private String description;
	private String listfile;
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getListfile() {
		return listfile;
	}
	public void setListfile(String listfile) {
		this.listfile = listfile;
	}
}
