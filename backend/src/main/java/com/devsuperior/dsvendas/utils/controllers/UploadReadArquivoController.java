package com.devsuperior.dsvendas.utils.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.devsuperior.dsvendas.repositories.ReadFileRepository;
 

@RestController
@RequestMapping("/upload")
public class UploadReadArquivoController {
	
	@Autowired
	private ReadFileRepository readFileRepository;
	
	
	@PostMapping
	public void upload(@RequestParam   MultipartFile foto) {
		
		System.out.println( " 1 ate aqui  ok !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ######################" );
		
		readFileRepository.LerArq(null, foto);
		
		 
		
	}


	public ReadFileRepository getReadFileRepository() {
		return readFileRepository;
	}


	public void setReadFileRepository(ReadFileRepository readFileRepository) {
		this.readFileRepository = readFileRepository;
	}
	
	

}
