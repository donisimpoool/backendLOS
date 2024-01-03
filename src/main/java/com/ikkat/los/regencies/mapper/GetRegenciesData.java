package com.ikkat.los.regencies.mapper;

import com.ikkat.los.regencies.entity.RegenciesData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetRegenciesData implements RowMapper<RegenciesData> {
    private String schemaSql;

    public GetRegenciesData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.idregencies as idregencies, data.idprovince as idprovince, data.nameregencies as nameregencies, data.id_simpool as id_simpool ");
        sqlBuilder.append("from m_regencies as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }
    @Override
    public RegenciesData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String idregencies = rs.getString("idregencies");
        final String idprovince = rs.getString("idprovince");
        final String nameregencies = rs.getString("nameregencies");
        final String id_simpool = rs.getString("id_simpool");

        RegenciesData data = new RegenciesData();
        data.setIdregencies(idregencies);
        data.setIdprovince(idprovince);
        data.setNameregencies(nameregencies);
        data.setId_simpool(id_simpool);
        return data;
    }
}
