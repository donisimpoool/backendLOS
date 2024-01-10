package com.ikkat.los.formapplication.application.service;

import com.ikkat.los.entity.applicationEntity;
import com.ikkat.los.formapplication.application.entity.*;
import com.ikkat.los.shared.ReturnData;

import java.util.List;

public interface FormApplicationService {

    List<ApplicationApprovalData> getApprovalApplicationList(Long idcompany, String status);
    List<ApplicationListData> getApplicarionListByDraft(Long idcompany,boolean isDraft);
    List<ApplicationData> getListAll(Long idcompany);
    ApplicationData getId(Long id,Long idcompany);
    ReturnData save(Long idcompany, Long iduser, BodyApplication body);
    ReturnData update(Long idcompany,Long iduser,Long id,BodyApplication body);
    ReturnData delete(Long idcompany,Long iduser,Long id);
    List<ApplicationData> findByStatus(Long idcompany,String status);
    List<ApplicationData> findbystatusperpage(Long idcompany,String status, int sizelimit);
    List<ApplicationData> findbyIsDraft(Long idcompany,String status,boolean isdraft);
    List<ApplicationData> findbyOnlyIsDraft(Long idcompany,boolean isdraft);

    ReturnData saveAllApplication(Long idcompany, Long iduser, BodyAllApplication body);
    Long getCountApplicant(Long idcompany,String fromDate,String thruDate,String status);

    ReturnData updateStatus(Long idcompany,Long iduser,BodyUpdateStatus body);
}
