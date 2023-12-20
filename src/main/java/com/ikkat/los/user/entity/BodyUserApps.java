package com.ikkat.los.user.entity;

public class BodyUserApps {
	private String username;
	private String password;
	private String nama;
	private long level;
	private String isapproval;
	private String usertype;
	private long limitsizefile;
	private boolean isactive;
	private Long[] roles;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public long getLevel() {
		return level;
	}

	public void setLevel(long level) {
		this.level = level;
	}

	public String getIsapproval() {
		return isapproval;
	}

	public void setIsapproval(String isapproval) {
		this.isapproval = isapproval;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public long getLimitsizefile() {
		return limitsizefile;
	}

	public void setLimitsizefile(long limitsizefile) {
		this.limitsizefile = limitsizefile;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public Long[] getRoles() {
		return roles;
	}

	public void setRoles(Long[] roles) {
		this.roles = roles;
	}
}
