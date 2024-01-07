package com.ikkat.los.Process;

import com.google.gson.Gson;
import com.ikkat.los.formapplication.application.entity.BodyAllApplication;
import com.ikkat.los.formapplication.application.service.FormApplicationService;
import com.ikkat.los.security.entity.AuthorizationData;
import com.ikkat.los.shared.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ProcessHandler implements ProcessService{
    @Autowired
    private FormApplicationService applicationService;
    @Override
    public ProcessReturn ProcessingFunction(String codepermission, Object data, String authorization) {
        ProcessReturn val = new ProcessReturn();
        val.setHttpcode(HttpStatus.OK.value());
        val.setSuccess(true);
        val.setValidations(new ArrayList<ValidationDataMessage>());

        Gson gson = new Gson();
        AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
        String decryption = aesEncryptionDecryption.decrypt(authorization);
        AuthorizationData auth = gson.fromJson(decryption, AuthorizationData.class);
        if(auth.getTypelogin().equals(ConstansKey.TYPE_WEB)) {
            if(codepermission.equals(ConstansPermission.CREATE_APPLICATION)) {
                BodyAllApplication body = (BodyAllApplication) data;
                ReturnData valReturn = applicationService.saveAllApplication(auth.getIdcompany(),auth.getId(), body);
                if(valReturn.isSuccess()) {
                    val.setData(valReturn.getId());
                }else {
                    val.setSuccess(valReturn.isSuccess());
                    val.setHttpcode(HttpStatus.BAD_REQUEST.value());
                    val.setValidations(valReturn.getValidations());
                    val.setData(null);
                }
            }
        }

        return val;
    }

    @Override
    public ProcessReturn ProcessingReadFunction(String codepermission, Object data, String authorization) {
        ProcessReturn val = new ProcessReturn();
        val.setHttpcode(HttpStatus.OK.value());
        val.setSuccess(true);
        val.setValidations(new ArrayList<ValidationDataMessage>());

        Gson gson = new Gson();
        AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
        String decryption = aesEncryptionDecryption.decrypt(authorization);
        AuthorizationData auth = gson.fromJson(decryption, AuthorizationData.class);
        if(auth.getTypelogin().equals(ConstansKey.TYPE_WEB)) {
            if(codepermission.equals(ConstansPermission.READ_APPLICATION)) {
                HashMap<String, Object> param = (HashMap<String, Object>) data;
                String type = (String) param.get("type");
                if(type.equals("ALL")) {
                    val.setData(applicationService.getApplicarionListByDraft(auth.getIdcompany(), true));
                }else if(type.equals("APPROVAL_ALL")) {
                    val.setData(applicationService.getApprovalApplicationList(auth.getIdcompany(), ""));
                }
            }
        }
        return val;
    }
}
