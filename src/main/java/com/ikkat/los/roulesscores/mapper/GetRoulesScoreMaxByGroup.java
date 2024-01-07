package com.ikkat.los.roulesscores.mapper;

import com.ikkat.los.roulesscores.entity.RoulesScoreMaxByGroup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetRoulesScoreMaxByGroup implements RowMapper<RoulesScoreMaxByGroup> {
    private String schemaSql;

    public GetRoulesScoreMaxByGroup() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(5);
        sqlBuilder.append("data.groups as groupss, MAX(data.score) as maxscore ");
        sqlBuilder.append("from roulesscores as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }
    @Override
    public RoulesScoreMaxByGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String groupss = rs.getString("groupss");
        final int maxscore = rs.getInt("maxscore");

        RoulesScoreMaxByGroup data = new RoulesScoreMaxByGroup();
        data.setGroups(groupss);
        data.setMaxscore(maxscore);
        return data;
    }
}
