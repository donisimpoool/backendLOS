package com.ikkat.los.formapplication.application.mapper;

import com.ikkat.los.district.entity.DistrictData;
import com.ikkat.los.formapplication.application.entity.ApplicationApprovalData;
import com.ikkat.los.formapplication.application.entity.ApplicationData;
import com.ikkat.los.formapplication.applicationaddress.entity.ApplicationAppovalAddressData;
import com.ikkat.los.province.entity.ProvinceData;
import com.ikkat.los.regencies.entity.RegenciesData;
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
        sqlBuilder.append("data.id as id, data.status as status, data.dateform as dateform, ");
        sqlBuilder.append("personal.names as personalnames, ");
        sqlBuilder.append("loan.amount as loanamount, loanprod.loan_name as loan_name, loanprod.loan_product_id as loan_product_id, ");

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

        data.setAppaddressentity(appaddressentity);

        return data;
    }
}
