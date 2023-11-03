package com.ikkat.los.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application_address", schema = "public")
public class ApplicationAddressEntity implements Serializable{
	@Id
	private String applicationid;
	private String mainaddress;
	private String provinceid;
	private String postalcode;
	private String ownershipstatus;
	private String usedforcollateral;
	private String liveinaddress;
	private String secondaddress;
	private String secondprovinceid;
	private String secondpostalcode;
	private String secondownershipstatus;
	private String secondusedforcollateral;
	private String idregencies;
	private String iddistrict;
	private String secondidregencies;
	private String secondiddistrict;
	private String location;
	private String rt;
	private String rw;
	private long villagesid;
	
	@Override
	public String toString() {
		return "ApplicationAddressEntity [applicationid=" + applicationid + ", mainaddress=" + mainaddress
				+ ", provinceid=" + provinceid + ", postalcode=" + postalcode + ", ownershipstatus=" + ownershipstatus
				+ ", usedforcollateral=" + usedforcollateral + ", liveinaddress=" + liveinaddress + ", secondaddress="
				+ secondaddress + ", secondprovinceid=" + secondprovinceid + ", secondpostalcode=" + secondpostalcode
				+ ", secondownershipstatus=" + secondownershipstatus + ", secondusedforcollateral="
				+ secondusedforcollateral + ", idregencies=" + idregencies + ", iddistrict=" + iddistrict
				+ ", secondidregencies=" + secondidregencies + ", secondiddistrict=" + secondiddistrict + ", location="
				+ location + ", rt=" + rt + ", rw=" + rw + ", villagesid=" + villagesid + ", subdistrictmain="
				+ subdistrictmain + ", provincemain=" + provincemain + ", regenciesmain=" + regenciesmain
				+ ", districtmain=" + districtmain + ", provincesecond=" + provincesecond + ", regenciessecond="
				+ regenciessecond + ", districtsecond=" + districtsecond + "]";
	}
	@OneToOne()
    @JoinColumn(name="villagesid",insertable = false, updatable = false)
    private SubDistrictEntity subdistrictmain;
	
	@OneToOne()
    @JoinColumn(name="provinceid",insertable = false, updatable = false)
    private ProvinceEntity provincemain;
	
	@OneToOne()
    @JoinColumn(name="idregencies",insertable = false, updatable = false)
    private RegenciesEntity regenciesmain;
	
	@OneToOne()
    @JoinColumn(name="iddistrict",insertable = false, updatable = false)
    private DistrictEntity districtmain;
	
	@OneToOne()
    @JoinColumn(name="secondprovinceid",insertable = false, updatable = false)
    private ProvinceEntity provincesecond;
//	
	@OneToOne()
    @JoinColumn(name="secondidregencies",insertable = false, updatable = false)
    private RegenciesEntity regenciessecond;
	
	@OneToOne()
    @JoinColumn(name="secondiddistrict",insertable = false, updatable = false)
    private DistrictEntity districtsecond;
	
	
	public long getVillagesid() {
		return villagesid;
	}
	public void setVillagesid(long villagesid) {
		this.villagesid = villagesid;
	}
	public SubDistrictEntity getSubdistrictmain() {
		return subdistrictmain;
	}
	public void setSubdistrictmain(SubDistrictEntity subdistrictmain) {
		this.subdistrictmain = subdistrictmain;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getRw() {
		return rw;
	}
	public void setRw(String rw) {
		this.rw = rw;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public ProvinceEntity getProvincesecond() {
		return provincesecond;
	}
	public void setProvincesecond(ProvinceEntity provincesecond) {
		this.provincesecond = provincesecond;
	}
	public RegenciesEntity getRegenciessecond() {
		return regenciessecond;
	}
	public void setRegenciessecond(RegenciesEntity regenciessecond) {
		this.regenciessecond = regenciessecond;
	}
	public DistrictEntity getDistrictsecond() {
		return districtsecond;
	}
	public void setDistrictsecond(DistrictEntity districtsecond) {
		this.districtsecond = districtsecond;
	}
	public ProvinceEntity getProvincemain() {
		return provincemain;
	}
	public void setProvincemain(ProvinceEntity provincemain) {
		this.provincemain = provincemain;
	}
	public RegenciesEntity getRegenciesmain() {
		return regenciesmain;
	}
	public void setRegenciesmain(RegenciesEntity regenciesmain) {
		this.regenciesmain = regenciesmain;
	}
	public DistrictEntity getDistrictmain() {
		return districtmain;
	}
	public void setDistrictmain(DistrictEntity districtmain) {
		this.districtmain = districtmain;
	}
	public String getIdregencies() {
		return idregencies;
	}
	public void setIdregencies(String idregencies) {
		this.idregencies = idregencies;
	}
	public String getIddistrict() {
		return iddistrict;
	}
	public void setIddistrict(String iddistrict) {
		this.iddistrict = iddistrict;
	}
	public String getSecondidregencies() {
		return secondidregencies;
	}
	public void setSecondidregencies(String secondidregencies) {
		this.secondidregencies = secondidregencies;
	}
	public String getSecondiddistrict() {
		return secondiddistrict;
	}
	public void setSecondiddistrict(String secondiddistrict) {
		this.secondiddistrict = secondiddistrict;
	}
	public String getApplicationid() {
		return applicationid;
	}
	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}
	public String getMainaddress() {
		return mainaddress;
	}
	public void setMainaddress(String mainaddress) {
		this.mainaddress = mainaddress;
	}
	public String getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getOwnershipstatus() {
		return ownershipstatus;
	}
	public void setOwnershipstatus(String ownershipstatus) {
		this.ownershipstatus = ownershipstatus;
	}
	public String getUsedforcollateral() {
		return usedforcollateral;
	}
	public void setUsedforcollateral(String usedforcollateral) {
		this.usedforcollateral = usedforcollateral;
	}
	public String getLiveinaddress() {
		return liveinaddress;
	}
	public void setLiveinaddress(String liveinaddress) {
		this.liveinaddress = liveinaddress;
	}
	public String getSecondaddress() {
		return secondaddress;
	}
	public void setSecondaddress(String secondaddress) {
		this.secondaddress = secondaddress;
	}
	public String getSecondprovinceid() {
		return secondprovinceid;
	}
	public void setSecondprovinceid(String secondprovinceid) {
		this.secondprovinceid = secondprovinceid;
	}
	public String getSecondpostalcode() {
		return secondpostalcode;
	}
	public void setSecondpostalcode(String secondpostalcode) {
		this.secondpostalcode = secondpostalcode;
	}
	public String getSecondownershipstatus() {
		return secondownershipstatus;
	}
	public void setSecondownershipstatus(String secondownershipstatus) {
		this.secondownershipstatus = secondownershipstatus;
	}
	public String getSecondusedforcollateral() {
		return secondusedforcollateral;
	}
	public void setSecondusedforcollateral(String secondusedforcollateral) {
		this.secondusedforcollateral = secondusedforcollateral;
	}
}
