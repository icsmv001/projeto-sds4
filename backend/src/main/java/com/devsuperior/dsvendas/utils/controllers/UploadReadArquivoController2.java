package com.devsuperior.dsvendas.utils.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.devsuperior.dsvendas.repositories.ReadFileRepository2;
 

@RestController
@RequestMapping("/upload2")
public class UploadReadArquivoController2 {
	
	@Autowired
	private ReadFileRepository2 readFileRepository2;
	
	
	@PostMapping
	public void upload2(@RequestParam   MultipartFile foto) {
		
		System.out.println( " 2 ate aqui  ok !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ######################" );
		
	 
		
		readFileRepository2.LerArq2(foto);
		
	}


	public ReadFileRepository2 getReadFileRepository() {
		return readFileRepository2;
	}


	public void setReadFileRepository2(ReadFileRepository2 readFileRepository2) {
		this.readFileRepository2 = readFileRepository2;
	}
	
	

}
