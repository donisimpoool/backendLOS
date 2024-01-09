package com.ikkat.los.dashboard.api;

import com.ikkat.los.loanproduct.entity.BodyLoanDashboard;
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
@RequestMapping("/v1/dashboard")
@CrossOrigin(origins = "${value.cross_origin}")
public class DashboardAPI {
    @Autowired
    SecurityService securityService;

    @PostMapping("/getList")
    ResponseEntity<Response> getList(@RequestBody @Validated BodyLoanDashboard body, @RequestHeader(ConstansKey.AUTH) String authorization) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("type", "ALL");
        param.put("body", body);
        Response response = securityService.response(ConstansPermission.READ_DASHBOARD,param,authorization);
        return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping("/getGraph")
    ResponseEntity<Response> getGraph(@RequestHeader(ConstansKey.AUTH) String authorization) {
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put("type", "GET_GRAPH");
        Response response = securityService.response(ConstansPermission.READ_DASHBOARD,param,authorization);
        return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
