package com.ikkat.los.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreMaxEntity;
import com.ikkat.los.helper.entity.ParamsRoulesScoreEntity;

@Repository("RoulesScoreRepo")
public interface RoulesScoreRepo extends JpaRepository<RoulesScoreEntity, Long> {
	@Query(value = "SELECT SUM(score) FROM roulesscore WHERE "
			+ " (groups='age' and minvalue < :#{#params.valuenumberage} and :#{#params.valuenumberage} > minvalue and maxvalue >= :#{#params.valuenumberage}) "
			+ " or (groups='gender' and VALUE= :#{#params.valuegender} )"
			+ " or (groups='maritalstatus' and VALUE= :#{#params.valuemaritalstatus} ) "
			+ " or (groups='numberofdependant' and :#{#params.valuenumberofdependant} >= minvalue and valuenumber= :#{#params.valuenumberofdependant} ) "
			+ " or (groups='education' and VALUE= :education ) "
			+ " or (groups='companysize' and minvalue < :#{#params.valuecompanysize} and :#{#params.valuecompanysize} > minvalue and maxvalue >= :#{#params.valuecompanysize}) "
			+ " or (groups='industrysector' and VALUE= :industrysector ) "
			+ " or (groups='durationwork' and minvalue < :#{#params.valuedurationwork} and :#{#params.valuedurationwork} > minvalue and maxvalue >= :#{#params.valuedurationwork} ) "
			+ " or (groups='incometype' and VALUE= :#{#params.valueincometype} ) "
			+ " or (groups='propertypossession' and VALUE= :#{#params.valuepropertypossession} ) "
			+ " or (groups='debtincomeratio' and minvalue < :debtincomeratio  and :debtincomeratio > minvalue and maxvalue >= :debtincomeratio ) "
			+ " or (groups='creditcardowner' and VALUE= :#{#params.valuecreditcardowner} ) "
			+ " or (groups='liveownershipstatus' and VALUE= :#{#params.valueliveownershipstatus} ) "
			+ " or (groups='location' and VALUE= :#{#params.valuelocation} ) "
			+ " or (groups='vehicleowner' and VALUE= :#{#params.valuevehicleowner} ) "
//			+ " or (groups='jobtittle' and VALUE = :jobtittle ) "
			,nativeQuery = true)
    public double SumScore(@Param("params") ParamsRoulesScoreEntity params,
    		@Param("education") String education,
    		@Param("industrysector") String industrysector,
//    		@Param("jobtittle") String jobtittle,
    		@Param("debtincomeratio") double debtincomeratio
    		);
	
	@Query(value =" select * from roulesscore "
			+ " where isroulestemplate = :isroulestemplate ",nativeQuery = true)
	public List<RoulesScoreEntity> getlistroulesByTemplate(@Param("isroulestemplate") boolean isroulestemplate);
	
	@Query(value =" select * from roulesscore "
			+ " where isroulestemplate = :isroulestemplate LIMIT :sizelimit ",nativeQuery = true)
	public List<RoulesScoreEntity> getlistroulesByTemplateByPage(@Param("isroulestemplate") boolean isroulestemplate,@Param("sizelimit") int sizelimit);
	
	@Query(value =" select groups, MAX(score) as maxscore from roulesscore "
			+ " where isroulestemplate = :isroulestemplate GROUP BY groups ",nativeQuery = true)
	public List<Object> getlistroulesMaxScore(@Param("isroulestemplate") boolean isroulestemplate);
	
	@Query(value =" select * from roulesscore "
			+ " where isroulestemplate = :isroulestemplate and groups = :groups and value = :value limit 1 ",nativeQuery = true)
	public RoulesScoreEntity getroulesByGroup(@Param("isroulestemplate") boolean isroulestemplate,@Param("groups") String groups,@Param("value") String value);
}
