package com.devsuperior.dsvendas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.service.SellerService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value="/sellers")


public class SellerController {
	
	@Autowired
	private SellerService service;
	
	
	// metodo para representar um endpoint e recuper os valores retornados no navegador
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll () {
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
		
	}

}
