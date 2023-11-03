package com.ikkat.los.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ikkat.los.entity.RiskLevelEntity;
import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.enumeration.GroupsRoulesEnum;
import com.ikkat.los.enumeration.StatusFilterEnum;
import com.ikkat.los.enumeration.TypeRoules;
import com.ikkat.los.helper.entity.ParamsRoulesScoreEntity;
import com.ikkat.los.helper.entity.RoulesMapEntity;
import com.ikkat.los.jsonmodel.ApplicationFInancialJson;
import com.ikkat.los.jsonmodel.ApplicationJSON;
import com.ikkat.los.jsonmodel.applicationLoanJson;
import com.ikkat.los.service.FilterDetailService;
import com.ikkat.los.service.FilterHeaderService;
import com.ikkat.los.service.RiskLevelService;

import ch.qos.logback.core.status.Status;

public class CalculateScore {
	
	
	public static HashMap<String, Object> score(List<RoulesScoreEntity> listroules,
			ParamsRoulesScoreEntity paramsValue,RiskLevelService RiskLevelService,FilterHeaderService headerservice,FilterDetailService detailservice) {
		CheckFilter check = new CheckFilter();
		HashMap<String, Object> paramCheckFilter = new HashMap<String, Object>();
		paramCheckFilter.put("filterid", paramsValue.getFilterid());
		paramCheckFilter.put("paramsroules", paramsValue);
		paramCheckFilter.put("headerservice", headerservice);
		paramCheckFilter.put("detailservice", detailservice);
		HashMap<String, Object> mapcheck = check.mapCheckingFilter(paramCheckFilter);
		String actionfilter = (String) mapcheck.get("action");
		String ruleEnginecomments = (String) mapcheck.get("ruleEnginecomments");
		HashMap<String, Object> nilai = new HashMap<String, Object>();
		HashMap<String, Object> maproulesscore = setroulesscore(listroules);
		HashMap<String, String> RoulesDistinct = (HashMap<String, String>) maproulesscore.get("1");
		HashMap<String, List<RoulesScoreEntity>> MapRoulesByGroups = (HashMap<String, List<RoulesScoreEntity>>) maproulesscore.get("2");
		HashMap<String, Double> MapRoulesByValue = (HashMap<String, Double>) maproulesscore.get("3");
		HashMap<String, Double> MapRoulesByValueNumber = (HashMap<String, Double>) maproulesscore.get("4");
		int hasilscore = 0;
		double temp = 0;
		double propertypossession = 0;
		double numberofdependant = 0;
		double gender = 0;
		double location = 0;
		double liveownershipstatus = 0;
		double vehicleowner = 0;
		double maritalstatus = 0;
		double companysize = 0;
		double creditcardowner = 0;
		double debtincomeratio = 0;
		double industrysector = 0;
		double education = 0;
		double incometype = 0;
		double age = 0;
		double durationwork = 0;
		double jobtittle = 0;
		double position = 0;
		for (Map.Entry roules : RoulesDistinct.entrySet()) {
			if (roules.getValue().equals(TypeRoules.RANGE.value())) {
				List<RoulesScoreEntity> temproulelist = MapRoulesByGroups.get(roules.getKey());
				
				temp = scoreRange(temproulelist, paramsValue.getValuenumberage(),String.valueOf(roules.getKey()),GroupsRoulesEnum.AGE.value());
				if(temp > 0) {
					age = temp;
				}
				hasilscore += temp;
				
				temp = scoreRange(temproulelist, paramsValue.getValuenumberofdependant(),String.valueOf(roules.getKey()),GroupsRoulesEnum.NUMBEROFDEPENDANT.value());
				if(temp > 0) {
					numberofdependant = temp;
				}
				hasilscore += temp;
				
				
				temp = scoreRange(temproulelist, paramsValue.getValuecompanysize(),String.valueOf(roules.getKey()),GroupsRoulesEnum.COMPANYSIZE.value());
				if(temp > 0) {
					companysize = temp;
				}
				hasilscore += temp;
				
				temp = scoreRange(temproulelist, paramsValue.getValuedurationwork(),String.valueOf(roules.getKey()),GroupsRoulesEnum.DURATIONWORK.value());
				if(temp > 0) {
					durationwork = temp;
				}
				hasilscore += temp;
				
				temp = scoreRange(temproulelist, CalculateDebtIncomeRatio(paramsValue),String.valueOf(roules.getKey()),GroupsRoulesEnum.DEBTINCOMERATIO.value());
				if(temp > 0) {
					debtincomeratio = temp;
				}
				hasilscore += temp;	
			}else if(roules.getValue().equals(TypeRoules.EQUALS.value())) {
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValuegender(),String.valueOf(roules.getKey()),GroupsRoulesEnum.GENDER.value());
				if(temp > 0) {
					gender = temp;
				}
				hasilscore += temp;
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValueposition(),String.valueOf(roules.getKey()),GroupsRoulesEnum.POSITIONS.value());
				if(temp > 0) {
					position = temp;
				}
				hasilscore += temp;
				 
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValuemaritalstatus(),String.valueOf(roules.getKey()),GroupsRoulesEnum.MARITALSTATUS.value());
				if(temp > 0) {
					maritalstatus = temp;
				}
				hasilscore += temp;
				
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValueeducation(),String.valueOf(roules.getKey()),GroupsRoulesEnum.EDUCATION.value());
				if(temp > 0) {
					education = temp;
				}
				hasilscore += temp;
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValueindustrysector(),String.valueOf(roules.getKey()),GroupsRoulesEnum.INDUSTRYSECTOR.value());
				if(temp > 0) {
					industrysector = temp;
				}
				hasilscore += temp;
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValuejobtittle(),String.valueOf(roules.getKey()),GroupsRoulesEnum.JOBTITTLE.value());
				if(temp > 0) {
					jobtittle = temp;
				}
				hasilscore += temp;
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValueincometype(),String.valueOf(roules.getKey()),GroupsRoulesEnum.INCOMETYPE.value());
				if(temp > 0) {
					incometype = temp;
				}
				hasilscore += temp;
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValuepropertypossession(),String.valueOf(roules.getKey()),GroupsRoulesEnum.PROPERTYPOSSESSION.value());
				if(temp > 0) {
					propertypossession = temp;
				}
				hasilscore += temp;
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValuecreditcardowner(),String.valueOf(roules.getKey()),GroupsRoulesEnum.CREDITCARDOWNER.value());
				if(temp > 0) {
					creditcardowner = temp;
				}
				hasilscore += temp;
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValueliveownershipstatus(),String.valueOf(roules.getKey()),GroupsRoulesEnum.LIVEOWNERSHIPSTATUS.value());
				if(temp > 0) {
					liveownershipstatus = temp;
				}
				hasilscore += temp;
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValuelocation(),String.valueOf(roules.getKey()),GroupsRoulesEnum.LOCATION.value());
				if(temp > 0) {
					location = temp;
				}
				hasilscore += temp;
				
				temp = scoreEquals(MapRoulesByValue,roules.getKey()+paramsValue.getValuevehicleowner(),String.valueOf(roules.getKey()),GroupsRoulesEnum.VEHICLEOWNER.value());
				if(temp > 0) {
					vehicleowner = temp;
				}
				hasilscore += temp;
			}else if(roules.getValue().equals(TypeRoules.EQUALS_NUMBER.value())) {
				temp = scoreEqualsNumber(MapRoulesByValueNumber,roules.getKey()+String.valueOf(paramsValue.getValuenumberofdependant()),String.valueOf(roules.getKey()),GroupsRoulesEnum.NUMBEROFDEPENDANT.value());
				if(temp > 0) {
					numberofdependant = temp;
				}
				hasilscore += temp;
				
				
				temp = scoreEqualsNumber(MapRoulesByValueNumber,roules.getKey()+String.valueOf(paramsValue.getValuecompanysize()),String.valueOf(roules.getKey()),GroupsRoulesEnum.COMPANYSIZE.value());
				if(temp > 0) {
					companysize = temp;
				}
				hasilscore += temp;
				
				
				temp = scoreEqualsNumber(MapRoulesByValueNumber,roules.getKey()+String.valueOf(CalculateDebtIncomeRatio(paramsValue)),String.valueOf(roules.getKey()),GroupsRoulesEnum.DEBTINCOMERATIO.value());
				if(temp > 0) {
					debtincomeratio = temp;
				}
				hasilscore += temp;				
				
				temp = scoreEqualsNumber(MapRoulesByValueNumber,roules.getKey()+String.valueOf(paramsValue.getValuenumberage()),String.valueOf(roules.getKey()),GroupsRoulesEnum.AGE.value());
				if(temp > 0) {
					age = temp;
				}
				hasilscore += temp;
				 
				temp = scoreEqualsNumber(MapRoulesByValueNumber,roules.getKey()+String.valueOf(paramsValue.getValuedurationwork()),String.valueOf(roules.getKey()),GroupsRoulesEnum.DURATIONWORK.value());
				if(temp > 0) {
					durationwork = temp;
				}
				hasilscore += temp;
			}
		}
		List<RiskLevelEntity> lisrrisk = RiskLevelService.getRiskByRangeScore(new Double(hasilscore));
		RiskLevelEntity risk = new RiskLevelEntity();
		if(lisrrisk != null && lisrrisk.size() > 0) {
			risk = RiskLevelService.getRiskByRangeScore(new Double(hasilscore)).get(0);
		}
		String status = risk.getStatus();
		
		if(StatusFilterEnum.REJECT.value().equals(actionfilter)) {
			status = "R";
		}else if(StatusFilterEnum.REFER.value().equals(actionfilter)) {
			status = "U";
		}
		
		HashMap<String, Double> detailscore = new HashMap<String, Double>();
		detailscore.put("propertypossession", propertypossession);
		detailscore.put("numberofdependant", numberofdependant);
		detailscore.put("gender", gender);
		detailscore.put("location", location);
		detailscore.put("liveownershipstatus", liveownershipstatus);
		detailscore.put("vehicleowner", vehicleowner);
		detailscore.put("maritalstatus", maritalstatus);
		detailscore.put("companysize", companysize);
		detailscore.put("creditcardowner", creditcardowner);
		detailscore.put("debtincomeratio", debtincomeratio);
		detailscore.put("industrysector", industrysector);
		detailscore.put("education", education);
		detailscore.put("incometype", incometype);
		detailscore.put("age", age);
		detailscore.put("durationwork", durationwork);
		detailscore.put("jobtittle", jobtittle);
		detailscore.put("position", position);
		
		
		nilai.put("hasilscore", hasilscore);
		nilai.put("status", status);
		nilai.put("risk", risk);
		nilai.put("ruleEnginecomments", ruleEnginecomments);
		nilai.put("detailscore", detailscore);
		return nilai;
	}
	
	private static double CalculateDebtIncomeRatio(ParamsRoulesScoreEntity paramsValue) {
		double hasil = 0.0;
		double expense = paramsValue.getValueexpense() + paramsValue.getValueaddtionalexpense();
		double income = paramsValue.getValuemainincome() + paramsValue.getValuesideincome() - expense;
		double cicilanperbulan = paramsValue.getValueloanamount() / paramsValue.getValuetenor();
		hasil = (cicilanperbulan / income) * 100.0; 
		return hasil;
	}
	private static double scoreEqualsNumber(HashMap<String, Double> MapRoulesByValueNumber, String input,String groupsrules,String groupsinput) {
		double score = 0;
		if(MapRoulesByValueNumber.get(input) != null && groupsrules.equals(groupsinput)) {
			score = MapRoulesByValueNumber.get(input).doubleValue();
		}
		return score;
	}
	private static double scoreEquals(HashMap<String, Double> MapRoulesByValue, String input,String groupsrules,String groupsinput) {
		double score = 0;
		if(MapRoulesByValue.get(input) != null && groupsrules.equals(groupsinput)) {
			score = MapRoulesByValue.get(input).doubleValue();
		}
		return score;
	}
	private static double scoreRange(List<RoulesScoreEntity> temproulelist, double input,String groupsrules,String groupsinput) {
		double score = 0;
		if(groupsrules.equals(groupsinput)) {
			for (RoulesScoreEntity roules : temproulelist) {
				if (input >= roules.getMinvalue() && input < roules.getMaxvalue()) {
					score = roules.getScore();
					break;
				}
			}
		}
		return score;
	}

	private static HashMap<String, Object> setroulesscore(List<RoulesScoreEntity> listroules) {
		HashMap<String, Object> value = new HashMap<String, Object>();
		HashMap<String, String> RoulesDistinct = new HashMap<String, String>();
		HashMap<String, List<RoulesScoreEntity>> MapRoulesByGroups = new HashMap<String, List<RoulesScoreEntity>>();
		HashMap<String, Double> MapRoulesByValue = new HashMap<String, Double>();
		HashMap<String, Double> MapRoulesByValueNumber = new HashMap<String, Double>();
		if(listroules.size() > 0) {
			for(RoulesScoreEntity roules : listroules) {
				List<RoulesScoreEntity> templist = new ArrayList<RoulesScoreEntity>();
				if(RoulesDistinct.get(roules.getGroups()) == null) {
					RoulesDistinct.put(roules.getGroups(), roules.getTyperoules());
				}
				if(MapRoulesByGroups.get(roules.getGroups()) == null) {
					templist.add(roules);
					MapRoulesByGroups.put(roules.getGroups(), templist);
				}else {
					templist = MapRoulesByGroups.get(roules.getGroups());
					templist.add(roules);
					MapRoulesByGroups.put(roules.getGroups(), templist);
				}
				
				if(roules.getTyperoules().equals(TypeRoules.EQUALS.value()) && !roules.getValue().equals("")) {
					if(MapRoulesByValue.get(roules.getGroups()+roules.getValue()) == null)  {
						MapRoulesByValue.put(roules.getGroups()+roules.getValue(), roules.getScore());
					}
				}else if(roules.getTyperoules().equals(TypeRoules.EQUALS_NUMBER.value()) && roules.getValuenumber() > 0) {
					if(MapRoulesByValueNumber.get(roules.getGroups()+roules.getValuenumber()) == null)  {
						MapRoulesByValueNumber.put(roules.getGroups()+roules.getValuenumber(), roules.getScore());
					}
				}
			}
		}
		value.put("1", RoulesDistinct);
		value.put("2", MapRoulesByGroups);
		value.put("3", MapRoulesByValue);
		value.put("4", MapRoulesByValueNumber);
		return value;
	}

	public static String status(int score) {
		String value = "U";
		if (score > 0 && score < 200) {
			value = "R";
		} else if (score >= 200 && score < 600) {
			value = "U";
		} else if (score >= 600 && score < 1000) {
			value = "A";
		}
		return value;
	}
}
