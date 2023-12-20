package com.ikkat.los.admin.rolepermissions.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RolePermissionsPK implements Serializable{
	private long idcompany;
    private long idbranch;
    private long idrole;
    private long idpermissions;
	public long getIdcompany() {
		return idcompany;
	}
	public void setIdcompany(long idcompany) {
		this.idcompany = idcompany;
	}
	public long getIdbranch() {
		return idbranch;
	}
	public void setIdbranch(long idbranch) {
		this.idbranch = idbranch;
	}
	public long getIdrole() {
		return idrole;
	}
	public void setIdrole(long idrole) {
		this.idrole = idrole;
	}
	public long getIdpermissions() {
		return idpermissions;
	}
	public void setIdpermissions(long idpermissions) {
		this.idpermissions = idpermissions;
	}
    
}
