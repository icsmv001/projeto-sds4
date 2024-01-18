package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.ArtistDTO;
import com.devsuperior.dsvendas.service.ArtistService4;

@Controller
@RestController
@RequestMapping(value = "/Artist4")

public class ArtistController4 {

	@Autowired
	private ArtistService4 service;
	
	
	
	
	@GetMapping
	public ResponseEntity<Page<ArtistDTO>> findAll(Pageable pageable) {
		Page<ArtistDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);

	}
	
	
	
	
	
	
	
		// METODO PARA USO COM QUERY NATIVE 
		@GetMapping(value = "/filtro4/{country}")
		public ResponseEntity<List<ArtistDTO>> findByCountryContaining (@PathVariable("country") String country){
			System.out.println("country = " + country);
			
			List<ArtistDTO> list = service.findByCountryContaining(country);
			return ResponseEntity.ok(list);
		}
}
