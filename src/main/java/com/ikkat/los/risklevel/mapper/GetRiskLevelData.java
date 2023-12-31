package com.ikkat.los.risklevel.mapper;

import com.ikkat.los.risklevel.entity.RiskLevelData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetRiskLevelData implements RowMapper<RiskLevelData> {
    private String schemaSql;

    public GetRiskLevelData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.namerisk as namerisk, data.odds as odds, data.probabilityofdefault as probabilityofdefault, ");
        sqlBuilder.append("data.min as min, data.max as max, data.status as status ");
        sqlBuilder.append("from m_risk_level as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public RiskLevelData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final String namerisk = rs.getString("namerisk");
        final String odds = rs.getString("odds");
        final Double probabilityofdefault = rs.getDouble("probabilityofdefault");
        final Double min = rs.getDouble("min");
        final Double max = rs.getDouble("max");
        final String status = rs.getString("status");

        RiskLevelData data = new RiskLevelData();
        data.setId(id);
        data.setNamerisk(namerisk);
        data.setOdds(odds);
        data.setProbabilityofdefault(probabilityofdefault);
        data.setMin(min);
        data.setMax(max);
        data.setStatus(status);
        return data;
    }
}
