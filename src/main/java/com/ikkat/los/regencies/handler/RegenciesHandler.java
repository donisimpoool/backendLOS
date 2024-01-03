package com.ikkat.los.regencies.handler;

import com.ikkat.los.province.entity.ProvinceData;
import com.ikkat.los.regencies.entity.RegenciesData;
import com.ikkat.los.regencies.mapper.GetRegenciesData;
import com.ikkat.los.regencies.service.RegenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegenciesHandler implements RegenciesService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public RegenciesData getId(String id) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRegenciesData().schema());
        sqlBuilder.append(" where data.idregencies = ?  ");
        final Object[] queryParameters = new Object[] {id};
        List<RegenciesData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetRegenciesData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }

        RegenciesData data = new RegenciesData();
        data.setIdregencies("");
        data.setIdprovince("");
        data.setNameregencies("");
        data.setId_simpool("");
        return data;
    }
}
