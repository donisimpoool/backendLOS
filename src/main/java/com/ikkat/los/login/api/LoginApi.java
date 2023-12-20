package com.ikkat.los.login.api;

import com.ikkat.los.login.entity.BodyLogin;
import com.ikkat.los.security.service.SecurityService;
import com.ikkat.los.shared.AESEncryptionDecryption;
import com.ikkat.los.shared.Response;
import com.ikkat.los.user.service.UserAppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class LoginApi {

    @Autowired
    UserAppsService userappsservice;
    @Autowired
    SecurityService securityService;

    //123456 == Gwwiq+0ccgH1SO0aymsvpg==
    @PostMapping("/login")
    ResponseEntity<Response> getLogin(@RequestBody @Validated BodyLogin bodylogin){
        AESEncryptionDecryption aesEncryptionDecryption = new AESEncryptionDecryption();
        String passwordDB = aesEncryptionDecryption.encrypt(bodylogin.getPassword());
        System.out.println("passwordDB "+passwordDB);
        Response response = securityService.response("loginweb",userappsservice.actionLogin(bodylogin.getUser(), bodylogin.getPassword()),"loginweb");
        return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
    }
}
