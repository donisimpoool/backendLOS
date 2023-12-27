package com.ikkat.los.formapplication.applicationaddress.mapper;

import com.ikkat.los.formapplication.application.entity.ApplicationData;
import com.ikkat.los.formapplication.applicationaddress.entity.ApplicationAddressData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDataApplicationAddress implements RowMapper<ApplicationAddressData> {
    private String schemaSql;

    public GetDataApplicationAddress() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.mainaddress as mainaddress, data.provinceid as provinceid, ");
        sqlBuilder.append("data.postalcode as postalcode, data.ownershipstatus as ownershipstatus, data.usedforcollateral as usedforcollateral, data.liveinaddress as liveinaddress, ");
        sqlBuilder.append("data.secondaddress as secondaddress, data.secondprovinceid as secondprovinceid, data.secondpostalcode as secondpostalcode, data.secondownershipstatus as secondownershipstatus,  ");
        sqlBuilder.append("data.secondusedforcollateral as secondusedforcollateral, data.idregencies as idregencies, data.iddistrict as iddistrict, data.secondidregencies as secondidregencies,  ");
        sqlBuilder.append("data.secondiddistrict as secondiddistrict, data.locationaddress as locationaddress, data.rw as rw, data.rt as rt, data.villagesid as villagesid  ");
        sqlBuilder.append("from formapplication_address as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationAddressData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String mainaddress = rs.getString("mainaddress");
        final String provinceid = rs.getString("provinceid");
        final String postalcode = rs.getString("postalcode");
        final String ownershipstatus = rs.getString("ownershipstatus");
        final String usedforcollateral = rs.getString("usedforcollateral");
        final String liveinaddress = rs.getString("liveinaddress");
        final String secondaddress = rs.getString("secondaddress");
        final String secondprovinceid = rs.getString("secondprovinceid");
        final String secondpostalcode = rs.getString("secondpostalcode");
        final String secondownershipstatus = rs.getString("secondownershipstatus");
        final String secondusedforcollateral = rs.getString("secondusedforcollateral");
        final String idregencies = rs.getString("idregencies");
        final String iddistrict = rs.getString("iddistrict");
        final String secondidregencies = rs.getString("secondidregencies");
        final String secondiddistrict = rs.getString("secondiddistrict");
        final String locationaddress = rs.getString("locationaddress");
        final String rw = rs.getString("rw");
        final String rt = rs.getString("rt");
        final Long villagesid = rs.getLong("villagesid");

        ApplicationAddressData data = new ApplicationAddressData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setMainaddress(mainaddress);
        data.setProvinceid(provinceid);
        data.setPostalcode(postalcode);
        data.setOwnershipstatus(ownershipstatus);
        data.setUsedforcollateral(usedforcollateral);
        data.setLiveinaddress(liveinaddress);
        data.setSecondaddress(secondaddress);
        data.setSecondprovinceid(secondprovinceid);
        data.setSecondpostalcode(secondpostalcode);
        data.setSecondownershipstatus(secondownershipstatus);
        data.setSecondusedforcollateral(secondusedforcollateral);
        data.setIdregencies(idregencies);
        data.setIddistrict(iddistrict);
        data.setSecondidregencies(secondidregencies);
        data.setSecondiddistrict(secondiddistrict);
        data.setLocation(locationaddress);
        data.setRt(rt);
        data.setRw(rw);
        data.setVillagesid(villagesid);
        return data;
    }
}
