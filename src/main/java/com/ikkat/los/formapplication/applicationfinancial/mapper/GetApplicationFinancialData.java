package com.ikkat.los.formapplication.applicationfinancial.mapper;

import com.ikkat.los.formapplication.applicationfamily.entity.ApplicationFamilyData;
import com.ikkat.los.formapplication.applicationfinancial.entity.ApplicationFinancialData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetApplicationFinancialData implements RowMapper<ApplicationFinancialData> {
    private String schemaSql;

    public GetApplicationFinancialData() {
        // TODO Auto-generated constructor stub
        final StringBuilder sqlBuilder = new StringBuilder(10);
        sqlBuilder.append("data.id as id, data.idapplication as idapplication, data.typeincome as typeincome, data.mainincome as mainincome, ");
        sqlBuilder.append("data.sideincome as sideincome, data.expense as expense, data.additionalexpense as additionalexpense, data.vehicleowner as vehicleowner, ");
        sqlBuilder.append("data.typevehicle as typevehicle ");
        sqlBuilder.append("from formapplication_financial as data ");

        this.schemaSql = sqlBuilder.toString();
    }

    public String schema() {
        return this.schemaSql;
    }

    @Override
    public ApplicationFinancialData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Long id = rs.getLong("id");
        final Long idapplication = rs.getLong("idapplication");
        final String typeincome = rs.getString("typeincome");
        final Double mainincome = rs.getDouble("mainincome");
        final Double sideincome = rs.getDouble("sideincome");
        final Double expense = rs.getDouble("expense");
        final Double additionalexpense = rs.getDouble("additionalexpense");
        final boolean vehicleowner = rs.getBoolean("vehicleowner");
        final String typevehicle = rs.getString("typevehicle");

        ApplicationFinancialData data = new ApplicationFinancialData();
        data.setId(id);
        data.setIdapplication(idapplication);
        data.setTypeincome(typeincome);
        data.setMainincome(mainincome);
        data.setSideincome(sideincome);
        data.setExpense(expense);
        data.setAdditionalexpense(additionalexpense);
        data.setVehicleowner(vehicleowner);
        data.setTypevehicle(typevehicle);
        return data;
    }
}
