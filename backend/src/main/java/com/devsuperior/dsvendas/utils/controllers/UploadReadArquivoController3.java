package com.devsuperior.dsvendas.utils.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.devsuperior.dsvendas.repositories.ReadFileRepository3;
 

@RestController
@RequestMapping("/upload_txt")
public class UploadReadArquivoController3 {
	
	@Autowired
	private ReadFileRepository3 readFileRepository3;
	
	
	@PostMapping
	public void upload2(@RequestParam   MultipartFile foto) {
		
		System.out.println( " 2 ate aqui  ok !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ######################" );
		
	 
		
		readFileRepository3.LerArq3(foto);
		
	}


	public ReadFileRepository3 getReadFileRepository() {
		return readFileRepository3;
	}


	public void setReadFileRepository2(ReadFileRepository3 readFileRepository2) {
		this.readFileRepository3 = readFileRepository3;
	}
	
	

}
