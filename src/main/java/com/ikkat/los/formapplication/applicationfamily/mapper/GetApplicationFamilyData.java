package com.ikkat.los.formapplication.applicationfamily.mapper;

import com.ikkat.los.formapplication.applicationfamily.entity.ApplicationFamilyData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationFamilyData implements RowMapper<ApplicationFamilyData> {
    private String schemaSql;

    public GetApplicationFamilyData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.contactemergency as contactemergency, data.addressemergencycontact as addressemergencycontact, ");
        sqlBuilder.append("data.mobileemergency as mobileemergency, data.mothername as mothername ");
        sqlBuilder.append("from formapplication_family as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationFamilyData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String contactemergency = rs.getString("contactemergency");
        final String addressemergencycontact = rs.getString("addressemergencycontact");
        final String mobileemergency = rs.getString("mobileemergency");
        final String mothername = rs.getString("mothername");

        ApplicationFamilyData data = new ApplicationFamilyData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setContactemergency(contactemergency);
        data.setAddressemergencycontact(addressemergencycontact);
        data.setMobileemergency(mobileemergency);
        data.setMothername(mothername);
        return data;
    }
}
