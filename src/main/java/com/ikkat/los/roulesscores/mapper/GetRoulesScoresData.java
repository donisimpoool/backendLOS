package com.ikkat.los.roulesscores.mapper;

import com.ikkat.los.formapplication.application.entity.ApplicationData;
import com.ikkat.los.roulesscores.entity.RoulesScoresData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetRoulesScoresData implements RowMapper<RoulesScoresData> {
    private String schemaSql;

    public GetRoulesScoresData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(5);
        sqlBuilder.append("data.id as id, data.minvalue as minvalue, data.maxvalue as maxvalue, data.value as value, ");
        sqlBuilder.append("data.valuenumber as valuenumber, data.score as score, data.groups as groups, data.typeroules as typeroules, ");
        sqlBuilder.append("data.isroulestemplate as isroulestemplate, data.nameroules as nameroules  ");
        sqlBuilder.append("from roulesscores as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public RoulesScoresData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Double minvalue = rs.getDouble("minvalue");
        final Double maxvalue = rs.getDouble("maxvalue");
        final String value = rs.getString("value");
        final Double valuenumber = rs.getDouble("valuenumber");
        final int score = rs.getInt("score");
        final String groups = rs.getString("groups");
        final String typeroules = rs.getString("typeroules");
        final boolean isroulestemplate = rs.getBoolean("isroulestemplate");
        final String nameroules = rs.getString("nameroules");

        RoulesScoresData data = new RoulesScoresData();
        data.setId(id);
        data.setMinvalue(minvalue);
        data.setMaxvalue(maxvalue);
        data.setValue(value);
        data.setValuenumber(valuenumber);
        data.setScore(score);
        data.setGroups(groups);
        data.setTyperoules(typeroules);
        data.setIsroulestemplate(isroulestemplate);
        data.setNameroules(nameroules);

        return data;
    }
}
