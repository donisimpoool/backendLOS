package com.ikkat.los.formapplication.applicationpersonal.mapper;

import com.ikkat.los.formapplication.applicationpersonal.entity.ApplicationPersonalData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationPersonalData implements RowMapper<ApplicationPersonalData> {
    private String schemaSql;

    public GetApplicationPersonalData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.names as names, data.mobilephone as mobilephone, ");
        sqlBuilder.append("data.landlinephone as landlinephone, data.placeofbirth as placeofbirth, data.dateofbirth as dateofbirth, data.gender as gender, ");
        sqlBuilder.append("data.typeid as typeid, data.education as education, data.maritalstatus as maritalstatus, data.email as email, data.idnumber as idnumber, ");
        sqlBuilder.append("data.numberofdependant as numberofdependant, data.religionid as religionid, data.taxnumber as taxnumber ");
        sqlBuilder.append("from formapplication_personal as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationPersonalData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String names = rs.getString("names");
        final String mobilephone = rs.getString("mobilephone");
        final String landlinephone = rs.getString("landlinephone");
        final String placeofbirth = rs.getString("placeofbirth");
        final Date dateofbirth = rs.getDate("dateofbirth");
        final String gender = rs.getString("gender");
        final String typeid = rs.getString("typeid");
        final String education = rs.getString("education");
        final String maritalstatus = rs.getString("maritalstatus");
        final String email = rs.getString("email");
        final String idnumber = rs.getString("idnumber");
        final int numberofdependant = rs.getInt("numberofdependant");
        final String religionid = rs.getString("religionid");
        final String taxnumber = rs.getString("taxnumber");

        ApplicationPersonalData data = new ApplicationPersonalData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setNames(names);
        data.setMobilephone(mobilephone);
        data.setLandlinephone(landlinephone);
        data.setPlaceofbirth(placeofbirth);
        data.setDateofbirth(dateofbirth);
        data.setGender(gender);
        data.setTypeid(typeid);
        data.setEducation(education);
        data.setMaritalstatus(maritalstatus);
        data.setEmail(email);
        data.setIdnumber(idnumber);
        data.setNumberofdependant(numberofdependant);
        data.setReligionid(religionid);
        data.setTaxnumber(taxnumber);
        return data;
    }
}
