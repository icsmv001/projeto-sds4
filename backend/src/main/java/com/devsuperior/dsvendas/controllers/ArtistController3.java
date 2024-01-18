package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.ArtistDTO;
import com.devsuperior.dsvendas.service.ArtistService3;

@Controller
@RestController
@RequestMapping(value = "/Artist3")

public class ArtistController3 {

	@Autowired
	private ArtistService3 service;
	
	
		// METODO PARA USO COM QUERY NATIVE 
		@GetMapping(value = "/filtro3/{country}")
		public ResponseEntity<List<ArtistDTO>> findByCountryContaining (@PathVariable("country") String country){
			System.out.println("country = " + country);
			
			List<ArtistDTO> list = service.findByCountryContaining(country);
			return ResponseEntity.ok(list);
		}
}
