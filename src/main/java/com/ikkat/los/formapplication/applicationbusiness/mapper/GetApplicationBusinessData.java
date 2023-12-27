package com.ikkat.los.formapplication.applicationbusiness.mapper;

import com.ikkat.los.formapplication.applicationbusiness.entity.FormApplicationBusinessData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationBusinessData implements RowMapper<FormApplicationBusinessData> {
    private String schemaSql;

    public GetApplicationBusinessData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.companyname as companyname, data.companyaddress as companyaddress, ");
        sqlBuilder.append("data.provinceid as provinceid, data.division as division, data.positions as positions, data.duration as duration, ");
        sqlBuilder.append("data.numberofemployees as numberofemployees, data.businessline as businessline, data.idregencies as idregencies, data.iddistrict as iddistrict ");
        sqlBuilder.append("from formapplication_business as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public FormApplicationBusinessData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String companyname = rs.getString("companyname");
        final String companyaddress = rs.getString("companyaddress");
        final String provinceid = rs.getString("provinceid");
        final String division = rs.getString("division");
        final String positions = rs.getString("positions");
        final int duration = rs.getInt("duration");
        final int numberofemployees = rs.getInt("numberofemployees");
        final String businessline = rs.getString("businessline");
        final String idregencies = rs.getString("idregencies");
        final String iddistrict = rs.getString("iddistrict");

        FormApplicationBusinessData data = new FormApplicationBusinessData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setCompanyaddress(companyname);
        data.setCompanyaddress(companyaddress);
        data.setProvinceid(provinceid);
        data.setDivision(division);
        data.setPositions(positions);
        data.setDuration(duration);
        data.setNumberofemployees(numberofemployees);
        data.setBusinessline(businessline);
        data.setIdregencies(idregencies);
        data.setIddistrict(iddistrict);
        return data;
    }
}
