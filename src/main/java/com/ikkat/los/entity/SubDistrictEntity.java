package com.ikkat.los.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_subdistrict", schema = "public")
public class SubDistrictEntity {
	
	@Id
	private long idsubdistrict;
	private String iddistrict;
	private String namesubdistrict;
	private String kodepos;
	private String kecamatan;
	public long getIdsubdistrict() {
		return idsubdistrict;
	}
	public void setIdsubdistrict(long idsubdistrict) {
		this.idsubdistrict = idsubdistrict;
	}
	public String getIddistrict() {
		return iddistrict;
	}
	public void setIddistrict(String iddistrict) {
		this.iddistrict = iddistrict;
	}
	public String getNamesubdistrict() {
		return namesubdistrict;
	}
	public void setNamesubdistrict(String namesubdistrict) {
		this.namesubdistrict = namesubdistrict;
	}
	public String getKodepos() {
		return kodepos;
	}
	public void setKodepos(String kodepos) {
		this.kodepos = kodepos;
	}
	public String getKecamatan() {
		return kecamatan;
	}
	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}
	
	
}
