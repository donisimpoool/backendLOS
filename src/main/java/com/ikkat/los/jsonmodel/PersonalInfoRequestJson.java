package com.ikkat.los.jsonmodel;

import io.swagger.annotations.ApiModelProperty;

public class PersonalInfoRequestJson {
	@ApiModelProperty(value = "set this value if updating existing customer. Set null if creating new customer. "
			+ "When the loan is first created, the customer will be created if not exist")
	private String customerId;
	private String fullName;
	
	@ApiModelProperty(value = "set this value if updating existing customer. Set null if creating new customer. "
			+ "This value holds precedence lower than customerId. Only evaluated if customerId is null")
	private String externalId;
	
	@ApiModelProperty(value = "one of KTP|SIM|PASSPORT, case sensitive")
	private String idType;
	
	@ApiModelProperty(value = "only KTP is validated right now")
	private String idNum;
	private String placeOfBirth;
	private long dateOfBirth;
	
	@ApiModelProperty(value = "M|F")
	private String gender;
	
	@ApiModelProperty(value = "one of SD|SMP|SMA|DIPLOMA|S1|S2|S3, case insensitive")
	private String education;
	
	@ApiModelProperty(value = "one of MARRIED|DIVORCED|WIDOW or WIDOWER|SINGLE, case insensitive")
	private String maritalStatus;
	private String email;
	private String mobile;
	private String landlinePhone;
	
	@ApiModelProperty(value = "the document Id of the uploaded KTP / SIM / Passport scan. This assumes that the documents has been uploaded beforehand and exists in system")
	private Long supportingDocumentId;
	
	@ApiModelProperty(value = "one of CAR|MOTOR or MOTORCYCLE|NONE or NO")
	private String vehicle;
	
	private String houseOwnership;
	
	@ApiModelProperty(value = "one of KOMPLEK PERUMAHAN|APARTEMEN|RUSUN|PERKAMPUNGAN, case insensitive")
	private String houseLocation;
	
	@ApiModelProperty(value = "Number of real estate owned by customer.")
	private Integer numOfOwnedProperties;
	
	@ApiModelProperty(value = "Set this value to the userId of the customer. NOT the userId of staff. If customer has no userId (account) "
			+ ", simply set to null. This is for when customer has his/her account, can login and create loan by themselves via mobile app / webapp."
			+ " For staff use, if staff creates loan on customer behalf, set this value to null.")
	private String userId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public long getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLandlinePhone() {
		return landlinePhone;
	}

	public void setLandlinePhone(String landlinePhone) {
		this.landlinePhone = landlinePhone;
	}

	public Long getSupportingDocumentId() {
		return supportingDocumentId;
	}

	public void setSupportingDocumentId(Long supportingDocumentId) {
		this.supportingDocumentId = supportingDocumentId;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getHouseOwnership() {
		return houseOwnership;
	}

	public void setHouseOwnership(String houseOwnership) {
		this.houseOwnership = houseOwnership;
	}

	public String getHouseLocation() {
		return houseLocation;
	}

	public void setHouseLocation(String houseLocation) {
		this.houseLocation = houseLocation;
	}

	public Integer getNumOfOwnedProperties() {
		return numOfOwnedProperties;
	}

	public void setNumOfOwnedProperties(Integer numOfOwnedProperties) {
		this.numOfOwnedProperties = numOfOwnedProperties;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
