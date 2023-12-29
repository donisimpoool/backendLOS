package com.ikkat.los.scoring.handler;

import com.ikkat.los.entity.roulesscore.RoulesScoreEntity;
import com.ikkat.los.enumeration.GroupsRoulesEnum;
import com.ikkat.los.enumeration.TypeRoules;
import com.ikkat.los.formapplication.application.entity.BodyAllApplication;
import com.ikkat.los.formapplication.applicationfinancial.entity.BodyApplicationFinancial;
import com.ikkat.los.roulesscores.entity.RoulesScoresData;
import com.ikkat.los.scoring.entity.ParamsRoulesScoreEntity;
import com.ikkat.los.scoring.service.ScoringService;
import com.ikkat.los.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScoringHandler implements ScoringService {
    @Override
    public ParamsRoulesScoreEntity setValueParameter(Long idcompany, BodyAllApplication body) {

        int age = Utils.calculateDateForAge(body.getApplicationpersonal().getDateofbirthTime());

        String OwnershipStatus = "N";
        String CreditCardOwner = "N";
        if(body.getApplicationaddress().getOwnershipstatus().equals("own")) {
            OwnershipStatus = "Y";
        }
        if(body.getApplicationbank().isIscreditcard()) {
            CreditCardOwner = "Y";
        }

        ParamsRoulesScoreEntity params = new ParamsRoulesScoreEntity();
        params.setValuenumberage(age);
        params.setValuegender(body.getApplicationpersonal().getGender());
        params.setValuemaritalstatus(body.getApplicationpersonal().getMaritalstatus());
        params.setValuenumberofdependant(body.getApplicationpersonal().getNumberofdependant());
        params.setValueeducation(body.getApplicationpersonal().getEducation());
        params.setValuecompanysize(body.getApplicationbusiness().getNumberofemployees());
        params.setValueindustrysector(body.getApplicationbusiness().getBusinessline());
        params.setValuejobtittle(body.getApplicationbusiness().getPositions());
        params.setValuedurationwork(body.getApplicationbusiness().getDuration());
        params.setValueincometype(body.getApplicationfinancial().getTypeincome());
        params.setValuepropertypossession(OwnershipStatus);
        params.setValuedebtincomeratio(debtincomeratio(body.getApplicationfinancial().getMainincome(),body.getApplicationloan().getAmount(),body.getApplicationloan().getTenor()));
        params.setValuecreditcardowner(CreditCardOwner);
        params.setValueliveownershipstatus(body.getApplicationaddress().getOwnershipstatus());
        String typevehicle = "No";
        if(!body.getApplicationfinancial().getTypevehicle().equals("")) {
            typevehicle = body.getApplicationfinancial().getTypevehicle();
        }
        params.setValuevehicleowner(typevehicle);
        params.setValuelocation(body.getApplicationaddress().getLocation());
        params.setValueprovinceid(body.getApplicationaddress().getProvinceid());
        params.setRegenciesid(body.getApplicationaddress().getIdregencies());
        params.setNetincome(netincome(body.getApplicationfinancial()));
        params.setFilterid(""); //?
        params.setMaxreject(0); //?

        if(body.getApplicationfinancial().getExpense() != null ) {
            params.setValueexpense(body.getApplicationfinancial().getExpense().doubleValue());
        }else {
            params.setValueexpense(0);
        }
        if(body.getApplicationfinancial().getAdditionalexpense() != null) {
            params.setValueaddtionalexpense(body.getApplicationfinancial().getAdditionalexpense().doubleValue());
        }else {
            params.setValueaddtionalexpense(0);
        }
        if(body.getApplicationfinancial().getMainincome() != null ) {
            params.setValuemainincome(body.getApplicationfinancial().getMainincome().doubleValue());
        }else {
            params.setValuemainincome(0);
        }
        if(body.getApplicationfinancial().getSideincome() != null ) {
            params.setValuesideincome(body.getApplicationfinancial().getSideincome().doubleValue());
        }else {
            params.setValuesideincome(0);
        }

        if(body.getApplicationloan().getAmount() != null ) {
            params.setValueloanamount(body.getApplicationloan().getAmount().doubleValue());
        }else {
            params.setValueloanamount(0.0);
        }
        params.setValuetenor(body.getApplicationloan().getTenor());
        params.setValueposition(body.getApplicationbusiness().getDivision());

        return params;
    }

    @Override
    public HashMap<String, Object> calculateScore(Long idcompany, List<RoulesScoresData> listRoules, BodyAllApplication body) {
        ParamsRoulesScoreEntity paramsValue = setValueParameter(idcompany,body);
        HashMap<String, Object> mapRoulesScore = setRoulesScore(listRoules);
        HashMap<String, String> RoulesDistinct = (HashMap<String, String>) mapRoulesScore.get("1");
        HashMap<String, List<RoulesScoresData>> MapRoulesByGroups = (HashMap<String, List<RoulesScoresData>>) mapRoulesScore.get("2");
        HashMap<String, Integer> MapRoulesByValue = (HashMap<String, Integer>) mapRoulesScore.get("3");
        HashMap<String, Integer> MapRoulesByValueNumber = (HashMap<String, Integer>) mapRoulesScore.get("4");

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
                List<RoulesScoresData> temproulelist = MapRoulesByGroups.get(roules.getKey());

                temp = scoreRange(temproulelist, paramsValue.getValuenumberage(),String.valueOf(roules.getKey()), GroupsRoulesEnum.AGE.value());
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
        return null;
    }

    private static double CalculateDebtIncomeRatio(ParamsRoulesScoreEntity paramsValue) {
        double hasil = 0.0;
        double expense = paramsValue.getValueexpense() + paramsValue.getValueaddtionalexpense();
        double income = paramsValue.getValuemainincome() + paramsValue.getValuesideincome() - expense;
        double cicilanperbulan = paramsValue.getValueloanamount() / paramsValue.getValuetenor();
        hasil = (cicilanperbulan / income) * 100.0;
        return hasil;
    }

    private static double scoreEqualsNumber(HashMap<String, Integer> MapRoulesByValueNumber, String input,String groupsrules,String groupsinput) {
        double score = 0;
        if(MapRoulesByValueNumber.get(input) != null && groupsrules.equals(groupsinput)) {
            score = MapRoulesByValueNumber.get(input).intValue();
        }
        return score;
    }
    private static double scoreEquals(HashMap<String, Integer> MapRoulesByValue, String input,String groupsrules,String groupsinput) {
        double score = 0;
        if(MapRoulesByValue.get(input) != null && groupsrules.equals(groupsinput)) {
            score = MapRoulesByValue.get(input).intValue();
        }
        return score;
    }

    private static double scoreRange(List<RoulesScoresData> temproulelist, double input,String groupsrules,String groupsinput) {
        double score = 0;
        if(groupsrules.equals(groupsinput)) {
            for (RoulesScoresData roules : temproulelist) {
                if (input >= roules.getMinvalue() && input < roules.getMaxvalue()) {
                    score = roules.getScore();
                    break;
                }
            }
        }
        return score;
    }

    private static HashMap<String, Object> setRoulesScore(List<RoulesScoresData> listroules) {
        HashMap<String, Object> value = new HashMap<String, Object>();

        HashMap<String, String> RoulesDistinct = new HashMap<String, String>();
        HashMap<String, List<RoulesScoresData>> MapRoulesByGroups = new HashMap<String, List<RoulesScoresData>>();
        HashMap<String, Integer> MapRoulesByValue = new HashMap<String, Integer>();
        HashMap<String, Integer> MapRoulesByValueNumber = new HashMap<String, Integer>();

        if(listroules.size() > 0) {
            for(RoulesScoresData roules : listroules) {
                List<RoulesScoresData> tempList = new ArrayList<RoulesScoresData>();
                if(RoulesDistinct.get(roules.getGroups()) == null) {
                    RoulesDistinct.put(roules.getGroups(), roules.getTyperoules());
                }

                if(MapRoulesByGroups.get(roules.getGroups()) == null) {
                    tempList.add(roules);
                    MapRoulesByGroups.put(roules.getGroups(), tempList);
                }else {
                    tempList = MapRoulesByGroups.get(roules.getGroups());
                    tempList.add(roules);
                    MapRoulesByGroups.put(roules.getGroups(), tempList);
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

    private double netincome(BodyApplicationFinancial body){
        double income = body.getMainincome().doubleValue() + body.getSideincome().doubleValue();
        double expense = body.getExpense().doubleValue() + body.getAdditionalexpense().doubleValue();
        double value = income - expense;
        return value;
    }

    private double debtincomeratio(double income, double pinjaman, int tenor) {
        double val = 100.0;
        double cicilanperbulan = pinjaman;
        if(tenor > 0) {
            cicilanperbulan = cicilanperbulan / Double.valueOf(tenor).doubleValue();
        }
        if(income > 0) {
            val = cicilanperbulan / income;
            val = val * 100.0;
        }
        return val;
    }
}
