package com.ikkat.los.roulesscores.api;

import com.ikkat.los.formapplication.application.entity.BodyUpdateStatus;
import com.ikkat.los.roulesscores.entity.BodyUpdateScore;
import com.ikkat.los.security.service.SecurityService;
import com.ikkat.los.shared.ConstansKey;
import com.ikkat.los.shared.ConstansPermission;
import com.ikkat.los.shared.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/roules")
@CrossOrigin(origins = "${value.cross_origin}")
public class RoulesScoresAPI {
    @Autowired
    SecurityService securityService;

    @GetMapping
    ResponseEntity<Response> getList(@RequestHeader(ConstansKey.AUTH) String authorization) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("type", "ALL");
        Response response = securityService.response(ConstansPermission.READ_ROULES,param,authorization);
        return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @PostMapping("/updatescore")
    ResponseEntity<Response> updateScore(@RequestBody @Validated BodyUpdateScore body, @RequestHeader(ConstansKey.AUTH) String authorization) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("type", "UPDATESCORE");
        param.put("body", body);
        Response response = securityService.response(ConstansPermission.EDIT_ROULES_SCORE,param,authorization);
        return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
