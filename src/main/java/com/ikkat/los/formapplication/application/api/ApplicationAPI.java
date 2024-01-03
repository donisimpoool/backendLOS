package com.ikkat.los.formapplication.application.api;

import com.ikkat.los.formapplication.application.entity.BodyAllApplication;
import com.ikkat.los.formapplication.application.entity.Tets;
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
@RequestMapping("/v1/application")
@CrossOrigin(origins = "${value.cross_origin}")
public class ApplicationAPI {
    @Autowired
    SecurityService securityService;

    @GetMapping
    ResponseEntity<Response> getList(@RequestHeader(ConstansKey.AUTH) String authorization) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("type", "ALL");
        Response response = securityService.response(ConstansPermission.READ_APPLICATION,param,authorization);
        return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @PostMapping
    ResponseEntity<Response> createObject(@RequestBody @Validated BodyAllApplication body, @RequestHeader(ConstansKey.AUTH) String authorization) {
        System.out.println("ApplicationAPI In ");
        Response response = securityService.response(ConstansPermission.CREATE_APPLICATION,body,authorization);
        return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
