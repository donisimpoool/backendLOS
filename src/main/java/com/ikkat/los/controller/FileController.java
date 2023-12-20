package com.ikkat.los.controller;

//import com.example.filedemo.payload.UploadFileResponse;
//import com.example.filedemo.service.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ikkat.los.entity.ApplicationDocumentEntity;
import com.ikkat.los.entity.ListDocumentEntity;
import com.ikkat.los.enumeration.MessageEnum;
import com.ikkat.los.repo.ApplicationDocumentRepo;
import com.ikkat.los.repo.ListDocumentRepo;
import com.ikkat.los.response.Response;
import com.ikkat.los.response.UploadFileResponse;
import com.ikkat.los.service.CompanyService;
//import com.ikkat.los.service.UserService;
import com.ikkat.los.utils.Utils;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file/v1")
@CrossOrigin(origins = "${value.cross_origin}")
public class FileController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private ApplicationDocumentRepo repo;
    @Autowired
    private ListDocumentRepo repoListDoc;
//    @Autowired
//	UserService userservice;
	@Autowired
	CompanyService compservice;

	private String pathupload = System.getProperty("user.home")+File.separatorChar+"CREDITSCORING";

	@PostMapping("/createtes")
	ResponseEntity<Response> createtes(@RequestParam("file") MultipartFile[] files,@RequestParam("description") String description) {
		Response response = new Response();
		response.setService(this.getClass().getName() + "");
		response.setMessage(MessageEnum.CREATE.value());
		for(MultipartFile file : files) {
			String fileName = file.getName();
			Path target = Paths.get(pathupload).resolve(file.getOriginalFilename()).toAbsolutePath().normalize();
			fileName = StringUtils.cleanPath(file.getOriginalFilename());			
		}		
		response.setData(HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		
	}
	@PostMapping("/uploadFile")
	ResponseEntity<Response> uploadFile(@RequestParam("file") MultipartFile file) {
		Response response = new Response();
		response.setService(this.getClass().getName());
		response.setMessage("");
		
		try {
		Utils.createFolder(pathupload);
		String fileName = file.getName();
		Path target = Paths.get(pathupload).resolve(file.getOriginalFilename()).toAbsolutePath().normalize();
		fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* Set Data Dari Database */
		response.setData(new UploadFileResponse(fileName, "", file.getContentType(), file.getSize()));
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/multipleuploadFile")
	ResponseEntity<Response> multipleuploadFile(@RequestParam("file") MultipartFile[] files,@RequestHeader("Authorization") String Authorization,@RequestHeader("Platform-CreditScoring") String platform,@RequestParam("description") String description,@RequestParam("applicationid") String applicationid,@RequestParam("docfor") String docfor) {
		Response response = new Response();
		response.setService(this.getClass().getName());
		response.setMessage("");
		
		try {
		String pathupload1 = pathupload +"/"+applicationid+'/'+docfor;
		Utils.createFolder(pathupload1);
		
		HashMap<String, Object> paramauth = new HashMap<String, Object>();
		paramauth.put("auth", Authorization);
		paramauth.put("platform", platform);
//		paramauth.put("userservice", userservice);
		paramauth.put("companyservice", compservice);
		boolean flagauth = Utils.CheckAuth(paramauth);
		LOGGER.info("multipleuploadFile : "+flagauth);
		if(!flagauth) {
			response.setMessage("not authenticated");
			response.setData("");
			return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> listdone = new ArrayList<String>();
		List<String> listerr = new ArrayList<String>();
		
		for(MultipartFile file : files) {
			String fileName = file.getName();
			Path target = Paths.get(pathupload1).resolve(file.getOriginalFilename())
	              .toAbsolutePath().normalize();
		    fileName = StringUtils.cleanPath(file.getOriginalFilename());
			try {
				Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);
				listdone.add(fileName);
				
				ListDocumentEntity listdoc = new ListDocumentEntity();
				listdoc.setApplicationid(applicationid);
				listdoc.setDocumentfor(docfor);
				listdoc.setPath(target.toString());
				listdoc.setNamefile(fileName);
				repoListDoc.save(listdoc);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				listerr.add(fileName);
				e.printStackTrace();
			}
			new UploadFileResponse(fileName, "", file.getContentType(), file.getSize());
		}
		if(docfor.equals("appdocument")) {
			ApplicationDocumentEntity docentity = new ApplicationDocumentEntity();
			docentity.setApplicationid(applicationid);
			docentity.setDescription(description);
			docentity.setListfile("");
			repo.save(docentity);
		}
		
		map.put("done", listdone);
		map.put("error", listerr);
		/* Set Data Dari Database */
		response.setData(map);
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("/download")
	public ResponseEntity downloadFileFromLocal(@RequestBody @Validated Map<String, Object> payload) {
		String filepath = (String) payload.get("path");
		Resource resource = null;
		try {
//		String filepath = "C:\\upload\\error.png"; 
		Path path = Paths.get(filepath);
		
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		}catch (Exception e) {
			LOGGER.error("ERROR", e);
			// TODO: handle exception
		}
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
	
	
//    @GetMapping("/downloadFile/{fileName:.+}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
//        // Load file as Resource
//        Resource resource = fileStorageService.loadFileAsResource(fileName);
//
//        // Try to determine file's content type
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            logger.info("Could not determine file type.");
//        }
//
//        // Fallback to the default content type if type could not be determined
//        if(contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
}
