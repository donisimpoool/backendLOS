package com.ikkat.los.formapplication.applicationcollateral.mapper;

import com.ikkat.los.formapplication.applicationbusiness.entity.FormApplicationBusinessData;
import com.ikkat.los.formapplication.applicationcollateral.entity.ApplicationCollateralData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationCollateralData implements RowMapper<ApplicationCollateralData> {
    private String schemaSql;

    public GetApplicationCollateralData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.collateral as collateral ");
        sqlBuilder.append("from formapplication_collateral as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationCollateralData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String collateral = rs.getString("collateral");

        ApplicationCollateralData data = new ApplicationCollateralData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setCollateral(collateral);
        return data;
    }
}
