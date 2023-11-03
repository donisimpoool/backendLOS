package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_kodepos", schema = "public")
public class KodePosEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String kelurahan;
	private String kecamatan;
	private String kabupaten;
	private String provinsi;
	private String kodepos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKelurahan() {
		return kelurahan;
	}
	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
	}
	public String getKecamatan() {
		return kecamatan;
	}
	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}
	public String getKabupaten() {
		return kabupaten;
	}
	public void setKabupaten(String kabupaten) {
		this.kabupaten = kabupaten;
	}
	public String getProvinsi() {
		return provinsi;
	}
	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}
	public String getKodepos() {
		return kodepos;
	}
	public void setKodepos(String kodepos) {
		this.kodepos = kodepos;
	}
}
