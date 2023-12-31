package com.ikkat.los.risklevel.handler;

import com.ikkat.los.formapplication.applicationaddress.mapper.GetDataApplicationAddress;
import com.ikkat.los.risklevel.entity.BodyRiskLevel;
import com.ikkat.los.risklevel.entity.RiskLevelData;
import com.ikkat.los.risklevel.mapper.GetRiskLevelData;
import com.ikkat.los.risklevel.repo.RiskLevelRepo;
import com.ikkat.los.risklevel.service.RiskLevelService;
import com.ikkat.los.shared.ReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskLevelHandler implements RiskLevelService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RiskLevelRepo repository;

    @Override
    public List<RiskLevelData> getRiskByRangeScore(Long idcompany, double score) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRiskLevelData().schema());
        sqlBuilder.append(" where data.idcompany = ?  and "+score+" >= data.min and "+score+" <= data.max ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetRiskLevelData(), queryParameters);
    }

    @Override
    public List<RiskLevelData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRiskLevelData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetRiskLevelData(), queryParameters);
    }

    @Override
    public RiskLevelData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRiskLevelData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        List<RiskLevelData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetRiskLevelData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public ReturnData save(Long idcompany, Long iduser, BodyRiskLevel body) {
        return null;
    }

    @Override
    public ReturnData update(Long idcompany, Long iduser, Long id, BodyRiskLevel body) {
        return null;
    }

    @Override
    public ReturnData delete(Long idcompany, Long iduser, Long id) {
        return null;
    }
}
