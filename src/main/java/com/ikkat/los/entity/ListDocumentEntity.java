package com.ikkat.los.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_list_document")
public class ListDocumentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String applicationid;
	private String path;
	private String documentfor;
	private String namefile;
	public String getNamefile() {
		return namefile;
	}
	public void setNamefile(String namefile) {
		this.namefile = namefile;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDocumentfor() {
		return documentfor;
	}
	public void setDocumentfor(String documentfor) {
		this.documentfor = documentfor;
	}
}
