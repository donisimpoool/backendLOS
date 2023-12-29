package com.ikkat.los.roulesscores.handler;

import com.ikkat.los.roulesscores.entity.RoulesScoresData;
import com.ikkat.los.roulesscores.mapper.GetRoulesScoresData;
import com.ikkat.los.roulesscores.repo.RoulesScoresRepo;
import com.ikkat.los.roulesscores.service.RoulesScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoulesScoresHandler implements RoulesScoresService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RoulesScoresRepo repository;

    @Override
    public List<RoulesScoresData> getListAll(Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRoulesScoresData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        return this.jdbcTemplate.query(sqlBuilder.toString(), new GetRoulesScoresData(), queryParameters);
    }

    @Override
    public RoulesScoresData getId(Long id, Long idcompany) {
        final StringBuilder sqlBuilder = new StringBuilder("select " + new GetRoulesScoresData().schema());
        sqlBuilder.append(" where data.idcompany = ?  ");
        final Object[] queryParameters = new Object[] {idcompany};
        List<RoulesScoresData> list = this.jdbcTemplate.query(sqlBuilder.toString(), new GetRoulesScoresData(), queryParameters);
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return null;
    }
}
