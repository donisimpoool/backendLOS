package com.ikkat.los.admin.role.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/role")
@CrossOrigin(origins = "${value.cross_origin}")
public class RoleApi {
//	@Autowired
//	SecurityService securityService;
//	@Autowired
//	RoleService roleService;
//
//	@GetMapping("{id}")
//	ResponseEntity<Response> getById(@PathVariable long id,@RequestHeader(ConstansKey.AUTH) String authorization) {
//		Response response = securityService.response(ConstansPermission.READ_ROLE,new Long(id).toString(),authorization);
//		return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
//	}
//
//	@GetMapping("/template")
//	ResponseEntity<Response> getTemplateRole(@RequestHeader(ConstansKey.AUTH) String authorization) {
//		Response response = securityService.response(ConstansPermission.READ_ROLE,"TEMPLATE",authorization);
//		return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
//	}
//
//	@GetMapping
//	ResponseEntity<Response> getListRole(@RequestHeader(ConstansKey.AUTH) String authorization) {
//		Response response = securityService.response(ConstansPermission.READ_ROLE,"ALL",authorization);
//		return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
//	}
//
//	@PostMapping
//	ResponseEntity<Response> createRole(@RequestBody @Validated BodyRole role, @RequestHeader(ConstansKey.AUTH) String authorization) {
//		Response response = securityService.response(ConstansPermission.CREATE_ROLE,role,authorization);
//		return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
//	}
//
//	@PutMapping("{id}")
//	ResponseEntity<Response> updateBranch(@PathVariable long id,@RequestBody @Validated BodyRole role, @RequestHeader(ConstansKey.AUTH) String authorization) {
//		HashMap<String, Object> param = new HashMap<String, Object>();
//		param.put("id", id);
//		param.put("BodyRole", role);
//		Response response = securityService.response(ConstansPermission.EDIT_ROLE,param,authorization);
//		return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
//	}
//
//	@DeleteMapping("{id}")
//	ResponseEntity<Response> deleteRole(@PathVariable long id, @RequestHeader(ConstansKey.AUTH) String authorization) {
//		Response response = securityService.response(ConstansPermission.DELETE_ROLE,id,authorization);
//		return ResponseEntity.status(response.getHttpcode()).contentType(MediaType.APPLICATION_JSON).body(response);
//	}

}
