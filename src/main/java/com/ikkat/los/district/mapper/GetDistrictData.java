package com.ikkat.los.district.mapper;

import com.ikkat.los.district.entity.DistrictData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDistrictData implements RowMapper<DistrictData> {
    private String schemaSql;

    public GetDistrictData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.iddistrict as iddistrict, data.idregencies as idregencies, data.namedistrict as namedistrict, data.kodepos as kodepos ");
        sqlBuilder.append("from m_district as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public DistrictData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String idregencies = rs.getString("idregencies");
        final String iddistrict = rs.getString("iddistrict");
        final String namedistrict = rs.getString("namedistrict");
        final String kodepos = rs.getString("kodepos");

        DistrictData data = new DistrictData();
        data.setIdregencies(idregencies);
        data.setIddistrict(iddistrict);
        data.setNamedistrict(namedistrict);

        return data;
    }
}
