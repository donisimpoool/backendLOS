package com.ikkat.los.formapplication.application.mapper;

import com.ikkat.los.district.entity.DistrictData;
import com.ikkat.los.formapplication.application.entity.App;
import com.ikkat.los.formapplication.application.entity.ApplicationApprovalData;
import com.ikkat.los.formapplication.applicationaddress.entity.ApplicationAppovalAddressData;
import com.ikkat.los.formapplication.applicationbank.entity.ApplicationApprovalBank;
import com.ikkat.los.formapplication.applicationbank.entity.BankData;
import com.ikkat.los.formapplication.applicationbusiness.entity.ApplicationBusinessApproval;
import com.ikkat.los.formapplication.applicationcollateral.entity.ApplicationCollateralApproval;
import com.ikkat.los.formapplication.applicationcollateralrealestate.entity.ApplicationCollateralRealEstateApprovalData;
import com.ikkat.los.formapplication.applicationfamily.entity.ApplicationFamilyApprovalData;
import com.ikkat.los.formapplication.applicationfinancial.entity.ApplicationFInancialApprovalData;
import com.ikkat.los.formapplication.applicationloan.entity.ApplicationLoanApprovalData;
import com.ikkat.los.formapplication.applicationloan.entity.LoanProduct;
import com.ikkat.los.province.entity.ProvinceData;
import com.ikkat.los.regencies.entity.RegenciesData;
import com.ikkat.los.risklevel.entity.RiskLevelApprovalData;
import com.ikkat.los.subdistrict.entity.SubdistrictData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApprovalApplication implements RowMapper<ApplicationApprovalData> {
    private String schemaSql;



    public GetApprovalApplication() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(100);
        sqlBuilder.append("data.id as id, data.status as status, data.dateform as dateform, data.score as score, ");
        sqlBuilder.append("personal.names as personalnames, ");
        sqlBuilder.append("loan.amount as loanamount, loanprod.loan_name as loan_name, loanprod.loan_product_id as loan_product_id, ");
        sqlBuilder.append("loan.tenor as loantenor, loan.purposeofloan as loanpurposeofloan, ");

        //formapplication_address
        sqlBuilder.append("address.id as addressid, address.mainaddress as mainaddress, address.provinceid as address_provinceid, address.postalcode as address_postalcode, ");
        sqlBuilder.append("address.ownershipstatus as address_ownershipstatus, address.usedforcollateral as address_usedforcollateral, address.liveinaddress as address_liveinaddress, address.secondaddress as address_secondaddress, ");
        sqlBuilder.append("address.secondprovinceid as address_secondprovinceid, address.secondpostalcode as address_secondpostalcode, address.secondownershipstatus as address_secondownershipstatus, address.secondusedforcollateral as address_secondusedforcollateral, ");
        sqlBuilder.append("address.idregencies as address_idregencies, address.iddistrict as address_iddistrict, address.secondidregencies as address_secondidregencies, address.secondiddistrict as address_secondiddistrict, ");
        sqlBuilder.append("address.locationaddress as address_locationaddress, address.rw as address_rw, address.rt as address_rt, address.villagesid as address_villagesid, ");
        sqlBuilder.append("address_prov.location_code as addressprov_location_code, address_prov.location_name as addressprov_location_name, address_prov.id_simpool as addressprov_id_simpool, ");
        sqlBuilder.append("address2_prov.location_code as address2prov_location_code, address2_prov.location_name as address2prov_location_name, address2_prov.id_simpool as address2prov_id_simpool, ");

        sqlBuilder.append("address_reg.idregencies as addressreg_idregencies, address_reg.idprovince as addressreg_idprovince, address_reg.nameregencies as addressreg_nameregencies, address_reg.id_simpool as addressreg_id_simpool, ");
        sqlBuilder.append("address2_reg.idregencies as address2reg_idregencies, address2_reg.idprovince as address2reg_idprovince, address2_reg.nameregencies as address2reg_nameregencies, address2_reg.id_simpool as address2reg_id_simpool ");

        sqlBuilder.append("address_dis.iddistrict as addressdis_iddistrict, address_dis.idregencies as addressdis_idregencies , address_dis.namedistrict as addressdis_namedistrict, address_dis.kodepos as addressdis_kodepos, ");
        sqlBuilder.append("address2_dis.iddistrict as address2dis_iddistrict, address2_dis.idregencies as address2dis_idregencies , address2_dis.namedistrict as address2dis_namedistrict, address2_dis.kodepos as address2dis_kodepos, ");
        sqlBuilder.append("address_subdis.idsubdistrict as addresssubdis_idsubdistrict, address_subdis.iddistrict as addresssubdis_iddistrict , address_subdis.namesubdistrict as addresssubdis_namesubdistrict, address_subdis.kodepos as addresssubdis_kodepos, address_subdis.kecamatan as addresssubdis_kecamatan, ");
        //

        //formapplication_bank
        sqlBuilder.append("bank.bankid as bank_bankid, bank.accounttype as bank_accounttype, bank.accountnumber as bank_accountnumber, bank.iscreditcard as bank_iscreditcard, bank.bankcc as bank_bankcc, ");
        sqlBuilder.append("bank.numbercc as bank_numbercc, bank.typecredittcard as bank_typecredittcard, ");
        sqlBuilder.append("mbank.bank_id as mbank_bank_id, mbank.bank_name as mbank_bank_name, ");
        sqlBuilder.append("mbankcc.bank_id as mbankcc_bank_id, mbankcc.bank_name as mbankcc_bank_name, ");
        //

        //formapplication_business
        sqlBuilder.append("business.companyname as business_companyname, business.companyaddress as business_companyaddress, business.provinceid as business_provinceid, business.division as business_division, business.positions as business_positions, ");
        sqlBuilder.append("business.duration as business_duration, business.numberofemployees as business_numberofemployees, business.businessline as business_businessline, business.idregencies as business_idregencies, business.iddistrict as business_iddistrict, ");
        sqlBuilder.append("business_prov.location_code as businessprov_location_code, business_prov.location_name as businessprov_location_name, business_prov.id_simpool as businessprov_id_simpool, ");
        sqlBuilder.append("business_reg.idregencies as businessreg_idregencies, business_reg.idprovince as businessreg_idprovince, business_reg.nameregencies as businessreg_nameregencies, business_reg.id_simpool as businessreg_id_simpool, ");
        sqlBuilder.append("business_dis.iddistrict as businessdis_iddistrict, business_dis.idregencies as businessdis_idregencies , business_dis.namedistrict as businessdis_namedistrict, business_dis.kodepos as businessdis_kodepos, ");
        //

        //formapplication_collateral
        sqlBuilder.append("collateral.collateral as collateral_collateral,  ");
        //

        //formapplication_collateral_real_estate
        sqlBuilder.append("collateral_re.typerealestate as collateral_re_typerealestate, collateral_re.conditions as collateral_re_conditions, collateral_re.years as collateral_re_years, ");
        sqlBuilder.append("collateral_re.rooms as collateral_re_rooms, collateral_re.address as collateral_re_address, collateral_re.provinceid as collateral_re_provinceid, ");
        sqlBuilder.append("collateral_re.regenciesid as collateral_re_regenciesid, collateral_re.districtid as collateral_re_districtid, collateral_re.sizes as collateral_re_sizes, collateral_re.proofofownership as collateral_re_proofofownership, ");
        sqlBuilder.append("collateral_re_prov.location_code as collateral_re_prov_location_code, collateral_re_prov.location_name as collateral_re_prov_location_name, collateral_re_prov.id_simpool as collateral_re_prov_id_simpool, ");
        sqlBuilder.append("collateral_re_reg.idregencies as collateral_re_reg_idregencies, collateral_re_reg.idprovince as collateral_re_reg_idprovince, collateral_re_reg.nameregencies as collateral_re_reg_nameregencies, collateral_re_reg.id_simpool as collateral_re_reg_id_simpool, ");
        sqlBuilder.append("collateral_re_dis.iddistrict as collateral_re_dis_iddistrict, collateral_re_dis.idregencies as collateral_re_dis_idregencies , collateral_re_dis.namedistrict as collateral_re_dis_namedistrict, collateral_re_dis.kodepos as collateral_re_dis_kodepos, ");
        //

        //Risk Level
        sqlBuilder.append("risklevel.id as risklevel_id, risklevel.namerisk as risklevel_namerisk, risklevel.odds as risklevel_odds, ");
        sqlBuilder.append("risklevel.probabilityofdefault as risklevel_probabilityofdefault, risklevel.min as risklevel_min, risklevel.max as risklevel_max, risklevel.status as risklevel_status, ");
        //risklevel

        //family
        sqlBuilder.append("family.contactemergency as family_contactemergency, family.addressemergencycontact as family_addressemergencycontact, family.mobileemergency as family_mobileemergency, ");
        sqlBuilder.append("family.mothername as family_mothername, ");
        //

        //formapplication_financial
        sqlBuilder.append("financial.typeincome as financial_typeincome, financial.mainincome as financial_mainincome, financial.sideincome as financial_sideincome, ");
        sqlBuilder.append("financial.expense as financial_expense, financial.additionalexpense as financial_additionalexpense, financial.vehicleowner as financial_vehicleowner, ");
        sqlBuilder.append("financial.typevehicle as financial_typevehicle, ");
        //

        sqlBuilder.append("from formapplication as data ");
        sqlBuilder.append("left join formapplication_personal as personal on personal.idapplication = data.id ");
        sqlBuilder.append("left join formapplication_loan as loan on loan.idapplication = data.id ");
        sqlBuilder.append("left join m_loan_product as loanprod on CAST(loanprod.loan_product_id as INTEGER) = loan.loanproductid ");

        //formapplication_address
        sqlBuilder.append("left join formapplication_address as address on address.idapplication = data.id ");
        sqlBuilder.append("left join m_province as address_prov on address_prov.location_code = address.provinceid ");
        sqlBuilder.append("left join m_province as address2_prov on address2_prov.location_code = address.secondprovinceid ");
        sqlBuilder.append("left join m_regencies as address_reg on address_reg.idregencies = address.idregencies ");
        sqlBuilder.append("left join m_regencies as address2_reg on address2_reg.idregencies = address.secondidregencies ");
        sqlBuilder.append("left join m_district as address_dis on address_dis.iddistrict = address.iddistrict ");
        sqlBuilder.append("left join m_district as address2_dis on address2_dis.iddistrict = address.secondiddistrict ");
        sqlBuilder.append("left join m_subdistrict as address_subdis on address_subdis.idsubdistrict = address.villagesid ");

        //formapplication_bank
        sqlBuilder.append("left join formapplication_bank as bank on bank.idapplication = data.id ");
        sqlBuilder.append("left join m_bank as mbank on mbank.bank_id = bank.bankid ");
        sqlBuilder.append("left join m_bank as mbankcc on mbankcc.bank_id = bank.bankcc ");
        //

        //formapplication_business
        sqlBuilder.append("left join formapplication_business as business on business.idapplication = data.id ");
        sqlBuilder.append("left join m_province as business_prov on business_prov.location_code = business.provinceid ");
        sqlBuilder.append("left join m_regencies as business_reg on business_reg.idregencies = business.idregencies ");
        sqlBuilder.append("left join m_district as business_dis on business_dis.iddistrict = business.iddistrict ");
        //

        //formapplication_collateral
        sqlBuilder.append("left join formapplication_collateral as collateral on collateral.idapplication = data.id ");
        //

        //formapplication_collateral_real_estate
        sqlBuilder.append("left join formapplication_collateral_real_estate as collateral_re on collateral_re.idapplication = data.id ");
        sqlBuilder.append("left join m_province as collateral_re_prov on collateral_re_prov.location_code = collateral_re.provinceid ");
        sqlBuilder.append("left join m_regencies as collateral_re_reg on collateral_re_reg.idregencies = collateral_re.regenciesid ");
        sqlBuilder.append("left join m_district as collateral_re_dis on collateral_re_dis.iddistrict = collateral_re.districtid ");
        //

        //risk level
        sqlBuilder.append("left join m_risk_level as risklevel on risklevel.id = data.idrisklevel ");
        //

        //formapplication_family
        sqlBuilder.append("left join formapplication_family as family on family.idapplication = data.id ");
        //

        //formapplication_financial
        sqlBuilder.append("left join formapplication_financial as financial on financial.idapplication = data.id ");
        //

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationApprovalData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final String status = rs.getString("status");
        final Date dateform = rs.getDate("dateform");
        final String personalnames = rs.getString("personalnames");
        final Double loanamount = rs.getDouble("loanamount");
        final String loan_product_id = rs.getString("loan_product_id");
        final String loan_name = rs.getString("loan_name");
        final int score = rs.getInt("score");



        //formapplication_address
        final Long addressid = rs.getLong("addressid");
        final String mainaddress = rs.getString("mainaddress");
        final String address_provinceid = rs.getString("address_provinceid");
        final String address_postalcode = rs.getString("address_postalcode");
        final String address_ownershipstatus = rs.getString("address_ownershipstatus");
        final String address_usedforcollateral = rs.getString("address_usedforcollateral");
        final String address_liveinaddress = rs.getString("address_liveinaddress");
        final String address_secondaddress = rs.getString("address_secondaddress");
        final String address_secondprovinceid = rs.getString("address_secondprovinceid");
        final String address_secondpostalcode = rs.getString("address_secondpostalcode");
        final String address_secondownershipstatus = rs.getString("address_secondownershipstatus");
        final String address_secondusedforcollateral = rs.getString("address_secondusedforcollateral");
        final String address_idregencies = rs.getString("address_idregencies");
        final String address_iddistrict = rs.getString("address_iddistrict");
        final String address_secondidregencies = rs.getString("address_secondidregencies");
        final String address_secondiddistrict = rs.getString("address_secondiddistrict");
        final String address_locationaddress = rs.getString("address_locationaddress");
        final String address_rw = rs.getString("address_rw");
        final String address_rt = rs.getString("address_rt");
        final String address_villagesid = rs.getString("address_villagesid");
        final String addressprov_location_code = rs.getString("addressprov_location_code");
        final String addressprov_location_name = rs.getString("addressprov_location_name");
        final String addressprov_id_simpool = rs.getString("addressprov_id_simpool");
        final String address2prov_location_code = rs.getString("address2prov_location_code");
        final String address2prov_location_name = rs.getString("address2prov_location_name");
        final String address2prov_id_simpool = rs.getString("address2prov_id_simpool");
        final String addressreg_idregencies = rs.getString("addressreg_idregencies");
        final String addressreg_idprovince = rs.getString("addressreg_idprovince");
        final String addressreg_nameregencies = rs.getString("addressreg_nameregencies");
        final String addressreg_id_simpool = rs.getString("addressreg_id_simpool");
        final String address2reg_idregencies = rs.getString("address2reg_idregencies");
        final String address2reg_idprovince = rs.getString("address2reg_idprovince");
        final String address2reg_nameregencies = rs.getString("address2reg_nameregencies");
        final String address2reg_id_simpool = rs.getString("address2reg_id_simpool");
        final String addressdis_iddistrict = rs.getString("addressdis_iddistrict");
        final String addressdis_idregencies = rs.getString("addressdis_idregencies");
        final String addressdis_namedistrict = rs.getString("addressdis_namedistrict");
        final String addressdis_kodepos = rs.getString("addressdis_kodepos");

        final String address2dis_iddistrict = rs.getString("address2dis_iddistrict");
        final String address2dis_idregencies = rs.getString("address2dis_idregencies");
        final String address2dis_namedistrict = rs.getString("address2dis_namedistrict");
        final String address2dis_kodepos = rs.getString("address2dis_kodepos");

        final String addresssubdis_idsubdistrict = rs.getString("addresssubdis_idsubdistrict");
        final String addresssubdis_iddistrict = rs.getString("addresssubdis_iddistrict");
        final String addresssubdis_namesubdistrict = rs.getString("addresssubdis_namesubdistrict");
        final String addresssubdis_kodepos = rs.getString("addresssubdis_kodepos");
        final String addresssubdis_kecamatan = rs.getString("addresssubdis_kecamatan");
        //

        //formapplication_bank
        final String bank_bankid = rs.getString("bank_bankid");
        final String bank_accounttype = rs.getString("bank_accounttype");
        final String bank_accountnumber = rs.getString("bank_accountnumber");
        final boolean bank_iscreditcard = rs.getBoolean("bank_iscreditcard");
        final String bank_bankcc = rs.getString("bank_bankcc");
        final String bank_numbercc = rs.getString("bank_numbercc");
        final String bank_typecredittcard = rs.getString("bank_typecredittcard");
        final String mbank_bank_id = rs.getString("mbank_bank_id");
        final String mbank_bank_name = rs.getString("mbank_bank_name");
        final String mbankcc_bank_id = rs.getString("mbankcc_bank_id");
        final String mbankcc_bank_name = rs.getString("mbankcc_bank_name");

        ApplicationApprovalBank appbank = new ApplicationApprovalBank();
        appbank.setApplicationid(id.toString());
        appbank.setAccountnumber(bank_accountnumber);
        appbank.setAccounttype(bank_accounttype);
        appbank.setBankcc(bank_bankcc);
        appbank.setBankid(bank_bankid);
        appbank.setIscreditcard(bank_iscreditcard?"Y":"N");
        appbank.setNumbercc(bank_numbercc);
        appbank.setTypecredittcard(bank_typecredittcard);

        BankData mbank = new BankData();
        mbank.setBankId(mbank_bank_id);
        mbank.setBankName(mbank_bank_name);

        BankData bankcc = new BankData();
        bankcc.setBankId(mbankcc_bank_id);
        bankcc.setBankName(mbankcc_bank_name);

        appbank.setBank(mbank);
        appbank.setBankcredit(bankcc);
        //

        //formapplication_business
        final String business_companyname = rs.getString("business_companyname");
        final String business_companyaddress = rs.getString("business_companyaddress");
        final String business_provinceid = rs.getString("business_provinceid");
        final String business_division = rs.getString("business_division");
        final String business_positions = rs.getString("business_positions");

        final int business_duration = rs.getInt("business_duration");
        final int business_numberofemployees = rs.getInt("business_numberofemployees");
        final String business_businessline = rs.getString("business_businessline");
        final String business_idregencies = rs.getString("business_idregencies");
        final String business_iddistrict = rs.getString("business_iddistrict");
        final String businessprov_location_code = rs.getString("businessprov_location_code");
        final String businessprov_location_name = rs.getString("businessprov_location_name");
        final String businessprov_id_simpool = rs.getString("businessprov_id_simpool");

        final String businessreg_idregencies = rs.getString("businessreg_idregencies");
        final String businessreg_idprovince = rs.getString("businessreg_idprovince");
        final String businessreg_nameregencies = rs.getString("businessreg_nameregencies");
        final String businessreg_id_simpool = rs.getString("businessreg_id_simpool");

        final String businessdis_iddistrict = rs.getString("businessdis_iddistrict");
        final String businessdis_idregencies = rs.getString("businessdis_idregencies");
        final String businessdis_namedistrict = rs.getString("businessdis_namedistrict");
        final String businessdis_kodepos = rs.getString("businessdis_kodepos");

        ApplicationBusinessApproval appBusiness = new ApplicationBusinessApproval();
        appBusiness.setApplicationid(id.toString());
        appBusiness.setBusinessline(business_businessline);
        appBusiness.setCompanyaddress(business_companyaddress);
        appBusiness.setCompanyname(business_companyname);
        appBusiness.setDivision(business_division);
        appBusiness.setDuration(business_duration);
        appBusiness.setIddistrict(business_iddistrict);
        appBusiness.setIdregencies(business_idregencies);
        appBusiness.setNumberofemployees(business_numberofemployees);
        appBusiness.setPosition(business_positions);
        appBusiness.setProvinceid(business_provinceid);

        ProvinceData provincebusiness = new ProvinceData();
        provincebusiness.setLocationCode(businessprov_location_code);
        provincebusiness.setLocationName(businessprov_location_name);
        provincebusiness.setId_simpool(businessprov_id_simpool);

        RegenciesData regenciesbusiness = new RegenciesData();
        regenciesbusiness.setIdprovince(businessreg_idprovince);
        regenciesbusiness.setIdregencies(businessreg_idregencies);
        regenciesbusiness.setNameregencies(businessreg_nameregencies);
        regenciesbusiness.setId_simpool(businessreg_id_simpool);

        DistrictData districtbusiness = new DistrictData();
        districtbusiness.setIddistrict(businessdis_iddistrict);
        districtbusiness.setIdregencies(businessdis_idregencies);
        districtbusiness.setNamedistrict(businessdis_namedistrict);

        appBusiness.setProvince(provincebusiness);
        appBusiness.setRegencies(regenciesbusiness);
        appBusiness.setDistrict(districtbusiness);


        ApplicationAppovalAddressData appaddressentity = new ApplicationAppovalAddressData();
        ProvinceData provincemain = new ProvinceData();
        provincemain.setLocationCode(addressprov_location_code);
        provincemain.setLocationName(addressprov_location_name);
        provincemain.setId_simpool(addressprov_id_simpool);

        ProvinceData provinceseconde = new ProvinceData();
        provinceseconde.setLocationCode(address2prov_location_code);
        provinceseconde.setLocationName(address2prov_location_name);
        provinceseconde.setId_simpool(address2prov_id_simpool);

        RegenciesData regenciesmain = new RegenciesData();
        regenciesmain.setIdprovince(addressreg_idprovince);
        regenciesmain.setIdregencies(addressreg_idregencies);
        regenciesmain.setNameregencies(addressreg_nameregencies);
        regenciesmain.setId_simpool(addressreg_id_simpool);

        RegenciesData regenciessecond = new RegenciesData();
        regenciessecond.setIdprovince(address2reg_idprovince);
        regenciessecond.setIdregencies(address2reg_idregencies);
        regenciessecond.setNameregencies(address2reg_nameregencies);
        regenciessecond.setId_simpool(address2reg_id_simpool);

        DistrictData districtmain = new DistrictData();
        districtmain.setIddistrict(addressdis_iddistrict);
        districtmain.setIdregencies(addressdis_idregencies);
        districtmain.setNamedistrict(addressdis_namedistrict);

        DistrictData districtsecond = new DistrictData();
        districtsecond.setIddistrict(address2dis_iddistrict);
        districtsecond.setIdregencies(address2dis_idregencies);
        districtsecond.setNamedistrict(address2dis_namedistrict);

        SubdistrictData subdistrictmain = new SubdistrictData();
        subdistrictmain.setIdsubdistrict(addresssubdis_idsubdistrict);
        subdistrictmain.setIddistrict(addresssubdis_iddistrict);
        subdistrictmain.setNamesubdistrict(addresssubdis_namesubdistrict);
        subdistrictmain.setKecamatan(addresssubdis_kecamatan);
        subdistrictmain.setKodepos(addresssubdis_kodepos);

        appaddressentity.setApplicationid(addressid);
        appaddressentity.setProvincemain(provincemain);
        appaddressentity.setProvincesecond(provinceseconde);
        appaddressentity.setRegenciesmain(regenciesmain);
        appaddressentity.setRegenciessecond(regenciessecond);
        appaddressentity.setDistrictmain(districtmain);
        appaddressentity.setDistrictsecond(districtsecond);
        appaddressentity.setSubdistrictmain(subdistrictmain);
        appaddressentity.setIddistrict(address_iddistrict);
        appaddressentity.setIdregencies(address_idregencies);
        appaddressentity.setLiveinaddress(address_liveinaddress);
        appaddressentity.setLocation(address_locationaddress);
        appaddressentity.setMainaddress(mainaddress);
        appaddressentity.setOwnershipstatus(address_ownershipstatus);
        appaddressentity.setPostalcode(address_postalcode);
        appaddressentity.setProvinceid(address_provinceid);
        appaddressentity.setRt(address_rt);
        appaddressentity.setRw(address_rw);
        appaddressentity.setUsedforcollateral(address_usedforcollateral);
        appaddressentity.setVillagesid(address_villagesid);
        appaddressentity.setSecondaddress(address_secondaddress);
        appaddressentity.setSecondiddistrict(address_secondiddistrict);
        appaddressentity.setSecondidregencies(address_secondidregencies);
        appaddressentity.setSecondownershipstatus(address_secondownershipstatus);
        appaddressentity.setSecondpostalcode(address_secondpostalcode);
        appaddressentity.setSecondprovinceid(address_secondprovinceid);
        appaddressentity.setSecondusedforcollateral(address_secondusedforcollateral);
        //

        //formapplication_collateral
        final String collateral_collateral = rs.getString("collateral_collateral");

        ApplicationCollateralApproval appCollateral = new ApplicationCollateralApproval();
        appCollateral.setApplicationid(id.toString());
        appCollateral.setCollateral(collateral_collateral);
        //

        //formapplication_collateral_real_estate
        final String collateral_re_typerealestate = rs.getString("collateral_re_typerealestate");
        final String collateral_re_conditions = rs.getString("collateral_re_conditions");
        final int collateral_re_years = rs.getInt("collateral_re_years");
        final int collateral_re_rooms = rs.getInt("collateral_re_rooms");
        final String collateral_re_address = rs.getString("collateral_re_address");
        final String collateral_re_provinceid = rs.getString("collateral_re_provinceid");
        final String collateral_re_regenciesid = rs.getString("collateral_re_regenciesid");
        final String collateral_re_districtid = rs.getString("collateral_re_districtid");
        final String collateral_re_sizes = rs.getString("collateral_re_sizes");
        final String collateral_re_proofofownership = rs.getString("collateral_re_proofofownership");
        final String collateral_re_prov_location_code = rs.getString("collateral_re_prov_location_code");
        final String collateral_re_prov_location_name = rs.getString("collateral_re_prov_location_name");
        final String collateral_re_prov_id_simpool = rs.getString("collateral_re_prov_id_simpool");
        final String collateral_re_reg_idregencies = rs.getString("collateral_re_reg_idregencies");
        final String collateral_re_reg_idprovince = rs.getString("collateral_re_reg_idprovince");
        final String collateral_re_reg_nameregencies = rs.getString("collateral_re_reg_nameregencies");
        final String collateral_re_reg_id_simpool = rs.getString("collateral_re_reg_id_simpool");
        final String collateral_re_dis_iddistrict = rs.getString("collateral_re_dis_iddistrict");
        final String collateral_re_dis_idregencies = rs.getString("collateral_re_dis_idregencies");
        final String collateral_re_dis_namedistrict = rs.getString("collateral_re_dis_namedistrict");
        final String collateral_re_dis_kodepos = rs.getString("collateral_re_dis_kodepos");

        ApplicationCollateralRealEstateApprovalData appCollateralRe = new ApplicationCollateralRealEstateApprovalData();
        appCollateralRe.setApplicationid(id.toString());
        appCollateralRe.setAddress(collateral_re_address);
        appCollateralRe.setCondition(collateral_re_conditions);
        appCollateralRe.setDistrictid(collateral_re_districtid);
        appCollateralRe.setProofofownership(collateral_re_proofofownership);
        appCollateralRe.setProvinceid(collateral_re_provinceid);
        appCollateralRe.setRegenciesid(collateral_re_regenciesid);
        appCollateralRe.setRooms(collateral_re_rooms);
        appCollateralRe.setSize(collateral_re_sizes);
        appCollateralRe.setTyperealestate(collateral_re_typerealestate);
        appCollateralRe.setYear(collateral_re_years);

        ProvinceData provinceCollateralRe = new ProvinceData();
        provinceCollateralRe.setLocationCode(collateral_re_prov_location_code);
        provinceCollateralRe.setLocationName(collateral_re_prov_location_name);
        provinceCollateralRe.setId_simpool(collateral_re_prov_id_simpool);

        RegenciesData regenciesCollateralRe = new RegenciesData();
        regenciesCollateralRe.setIdprovince(collateral_re_reg_idprovince);
        regenciesCollateralRe.setIdregencies(collateral_re_reg_idregencies);
        regenciesCollateralRe.setNameregencies(collateral_re_reg_nameregencies);
        regenciesCollateralRe.setId_simpool(collateral_re_reg_id_simpool);

        DistrictData districtCollateralRe = new DistrictData();
        districtCollateralRe.setIddistrict(collateral_re_dis_iddistrict);
        districtCollateralRe.setIdregencies(collateral_re_dis_idregencies);
        districtCollateralRe.setNamedistrict(collateral_re_dis_namedistrict);

        appCollateralRe.setProvince(provinceCollateralRe);
        appCollateralRe.setRegencies(regenciesCollateralRe);
        appCollateralRe.setDistrict(districtCollateralRe);
        //

        //Risk Level
        final Long risklevel_id = rs.getLong("risklevel_id");
        final String risklevel_namerisk = rs.getString("risklevel_namerisk");
        final String risklevel_odds = rs.getString("risklevel_odds");
        final Double risklevel_probabilityofdefault = rs.getDouble("risklevel_probabilityofdefault");
        final Double risklevel_min = rs.getDouble("risklevel_min");
        final Double risklevel_max = rs.getDouble("risklevel_max");
        final String risklevel_status = rs.getString("risklevel_status");

        RiskLevelApprovalData riskLevel = new RiskLevelApprovalData();
        riskLevel.setId(risklevel_id);
        riskLevel.setNamerisk(risklevel_namerisk);
        riskLevel.setOdds(risklevel_odds);
        riskLevel.setProbabilityofdefault(risklevel_probabilityofdefault);
        riskLevel.setMin(risklevel_min);
        riskLevel.setMax(risklevel_max);
        riskLevel.setStatus(risklevel_status);

        App app = new App();
        app.setRisklevel(riskLevel);
        app.setDocumentapp(null);
        app.setScore(score);
        app.setRuleenginecomments("");
        app.setScorecardcomments("");
        //

        //formapplication_family
        final String family_contactemergency = rs.getString("family_contactemergency");
        final String family_addressemergencycontact = rs.getString("family_addressemergencycontact");
        final String family_mobileemergency = rs.getString("family_mobileemergency");
        final String family_mothername = rs.getString("family_mothername");

        ApplicationFamilyApprovalData appFamily = new ApplicationFamilyApprovalData();
        appFamily.setApplicationid(id.toString());
        appFamily.setContactemergency(family_contactemergency);
        appFamily.setAddressemergencycontact(family_addressemergencycontact);
        appFamily.setMobileemergency(family_mobileemergency);
        appFamily.setMothername(family_mothername);
        //

        //formapplication_financial
        final String financial_typeincome = rs.getString("financial_typeincome");
        final Double financial_mainincome = rs.getDouble("financial_mainincome");
        final Double financial_sideincome = rs.getDouble("financial_sideincome");
        final Double financial_expense = rs.getDouble("financial_expense");
        final Double financial_additionalexpense = rs.getDouble("financial_additionalexpense");
        final boolean financial_vehicleowner = rs.getBoolean("financial_vehicleowner");
        final String financial_typevehicle = rs.getString("financial_typevehicle");

        ApplicationFInancialApprovalData appFinance = new ApplicationFInancialApprovalData();
        appFinance.setApplicationid(id.toString());
        appFinance.setExpense(financial_expense);
        appFinance.setAdditionalexpense(financial_additionalexpense);
        appFinance.setMainincome(financial_mainincome);
        appFinance.setSideincome(financial_sideincome);
        appFinance.setTypeincome(financial_typeincome);
        appFinance.setTypevehicle(financial_typevehicle);
        appFinance.setVehicleowner(financial_vehicleowner?"Y":"N");
        //

        final String loanpurposeofloan = rs.getString("loanpurposeofloan");
        final int loantenor = rs.getInt("loantenor");

        ApplicationLoanApprovalData appLoan = new ApplicationLoanApprovalData();
        appLoan.setApplicationID(id.toString());
        appLoan.setAmount(loanamount);
        appLoan.setLoanproductID(loan_product_id);
        appLoan.setPurposeofloan(loanpurposeofloan);
        appLoan.setTenor(loantenor);
        LoanProduct prodloan = new LoanProduct();
        prodloan.setLoanName(loan_name);
        appLoan.setLoanproduct(prodloan);

        ApplicationApprovalData data = new ApplicationApprovalData();
        data.setId(id);
        data.setAmountloan(loanamount);
        data.setCreatedateapplication(dateform);
        data.setCreatedateapplicationmonth(dateform);
        data.setDistrictname("");
        data.setFullname(personalnames);
        data.setListdoc(new String[0]);
        data.setLoanid(loan_product_id);
        data.setLoannameproduct(loan_name);
        data.setProvincename("");
        data.setRegenciesname("");
        data.setStatus(status);
        data.setAppbankentity(appbank);
        data.setAppbusinessentity(appBusiness);
        data.setAppaddressentity(appaddressentity);
        data.setAppcollateralentity(appCollateral);
        data.setAppcollateralreentity(appCollateralRe);
        data.setAppentity(app);
        data.setAppfamilyentity(appFamily);
        data.setAppfinancialentity(appFinance);
        data.setApploanentity(appLoan);
        return data;
    }
}
