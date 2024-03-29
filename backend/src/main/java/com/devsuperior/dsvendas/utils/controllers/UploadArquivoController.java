package com.devsuperior.dsvendas.utils.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.devsuperior.dsvendas.repositories.DiscoRepository;
 

@RestController
@RequestMapping("/fotos")
public class UploadArquivoController {
	
	@Autowired
	private DiscoRepository discoRepository;
	
	
	@PostMapping
	public void upload(@RequestParam   MultipartFile foto) {
		discoRepository.salvarFoto(foto);
		
		
		
	}


	public DiscoRepository getDiscoRepository() {
		return discoRepository;
	}


	public void setDiscoRepository(DiscoRepository discoRepository) {
		this.discoRepository = discoRepository;
	}
	
	

}
