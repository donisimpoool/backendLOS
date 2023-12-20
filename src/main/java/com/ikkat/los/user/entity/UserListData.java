package com.ikkat.los.user.entity;

public class UserListData {
	private long id;
	private long companyid;
	private long branchid;
	private String nama;
	private String isapproval;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}

	public long getBranchid() {
		return branchid;
	}

	public void setBranchid(long branchid) {
		this.branchid = branchid;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getIsapproval() {
		return isapproval;
	}

	public void setIsapproval(String isapproval) {
		this.isapproval = isapproval;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	private boolean isactive;

}
