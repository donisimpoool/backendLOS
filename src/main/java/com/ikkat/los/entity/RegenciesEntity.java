package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_regencies", schema = "public")
public class RegenciesEntity implements Serializable{
	private static final long serialVersionUID = 8686714449302828736L;

	@Id
	private String idregencies;
	private String idprovince;
	private String nameregencies;
	private String id_simpool;
	public String getId_simpool() {
		return id_simpool;
	}
	public void setId_simpool(String id_simpool) {
		this.id_simpool = id_simpool;
	}
	public String getIdregencies() {
		return idregencies;
	}
	public void setIdregencies(String idregencies) {
		this.idregencies = idregencies;
	}
	public String getIdprovince() {
		return idprovince;
	}
	public void setIdprovince(String idprovince) {
		this.idprovince = idprovince;
	}
	public String getNameregencies() {
		return nameregencies;
	}
	public void setNameregencies(String nameregencies) {
		this.nameregencies = nameregencies;
	}
}
