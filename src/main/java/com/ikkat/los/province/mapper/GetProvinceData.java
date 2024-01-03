package com.ikkat.los.province.mapper;

import com.ikkat.los.province.entity.ProvinceData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetProvinceData implements RowMapper<ProvinceData> {
    private String schemaSql;

    public GetProvinceData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.location_code as location_code, data.location_name as location_name, data.id_simpool as id_simpool ");
        sqlBuilder.append("from m_province as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ProvinceData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String location_code = rs.getString("location_code");
        final String location_name = rs.getString("location_name");
        final String id_simpool = rs.getString("id_simpool");

        ProvinceData data = new ProvinceData();
        data.setLocationCode(location_code);
        data.setLocationName(location_name);
        data.setId_simpool(id_simpool);
        return data;
    }
}
