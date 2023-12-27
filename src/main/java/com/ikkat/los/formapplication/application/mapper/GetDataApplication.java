package com.ikkat.los.formapplication.application.mapper;

import com.ikkat.los.formapplication.application.entity.ApplicationData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDataApplication implements RowMapper<ApplicationData> {
    private String schemaSql;

    public GetDataApplication() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(5);
        sqlBuilder.append("data.id as id, data.status as status, data.score as score, data.dateform as dateform, ");
        sqlBuilder.append("data.isdraft as isdraft, data.idrisklevel as idrisklevel, data.scorecardcomments as scorecardcomments, data.ruleenginecomments as ruleenginecomments, ");
        sqlBuilder.append("data.isexport as isexport  ");
        sqlBuilder.append("from formapplication as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final String status = rs.getString("status");
        final Long score = rs.getLong("score");
        final Date dateform = rs.getDate("dateform");
        final boolean isdraft = rs.getBoolean("isdraft");
        final Long idrisklevel = rs.getLong("idrisklevel");
        final String scorecardcomments = rs.getString("scorecardcomments");
        final String ruleenginecomments = rs.getString("ruleenginecomments");
        final boolean isexport = rs.getBoolean("isexport");

        ApplicationData data = new ApplicationData();
        data.setId(id);
        data.setStatus(status);
        data.setScore(score);
        data.setDateform(dateform);
        data.setIsdraft(isdraft);
        data.setIdrisklevel(idrisklevel);
        data.setScorecardcomments(scorecardcomments);
        data.setRuleenginecomments(ruleenginecomments);
        data.setIsexport(isexport);
        return data;
    }
}
