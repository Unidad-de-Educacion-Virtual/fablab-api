package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.demo.services.UploadFilesService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/upload")
public class UploadFilesController {
	@Autowired
	private UploadFilesService uploadFilesService;
	
	@PostMapping
	private ResponseEntity<String> uploadFile(@RequestParam MultipartFile file) throws Exception {
		return ResponseEntity.status(201).body(uploadFilesService.uploadFile(file));
	}
	
}
