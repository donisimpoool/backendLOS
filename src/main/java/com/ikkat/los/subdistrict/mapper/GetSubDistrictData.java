package com.ikkat.los.subdistrict.mapper;

import com.ikkat.los.regencies.entity.RegenciesData;
import com.ikkat.los.subdistrict.entity.SubdistrictData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetSubDistrictData implements RowMapper<SubdistrictData> {
    private String schemaSql;

    public GetSubDistrictData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.idsubdistrict as idsubdistrict, data.iddistrict as iddistrict, data.namesubdistrict as namesubdistrict, data.kodepos as kodepos, data.kecamatan as kecamatan ");
        sqlBuilder.append("from m_subdistrict as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public SubdistrictData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String idsubdistrict = rs.getString("idsubdistrict");
        final String iddistrict = rs.getString("iddistrict");
        final String namesubdistrict = rs.getString("namesubdistrict");
        final String kodepos = rs.getString("kodepos");
        final String kecamatan = rs.getString("kecamatan");

        SubdistrictData data = new SubdistrictData();
        data.setIdsubdistrict(idsubdistrict);
        data.setIddistrict(iddistrict);
        data.setNamesubdistrict(namesubdistrict);
        data.setKodepos(kodepos);
        data.setKecamatan(kecamatan);
        return data;
    }
}
