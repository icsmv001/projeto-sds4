package com.devsuperior.dsvendas.controllers;

import java.util.List;
import java.util.Optional;

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
import com.devsuperior.dsvendas.service.ArtistService2;

@Controller
@RestController
@RequestMapping(value = "/Artist2")

public class ArtistController2 {

	@Autowired
	private ArtistService2 service;
	
	@GetMapping
	public ResponseEntity<Page<ArtistDTO>> findAll(Pageable pageable) {
		Page<ArtistDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);

	}
	
 
	
	
	
// // consulta por nome simples e com like, usando a convensao containing do jpa repository
//	@GetMapping(value = "/Artist2")
//	public ResponseEntity<List<ArtistDTO>> buscarArtists() {
//    	// System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + name);
//		List<ArtistDTO> list = service.findByAll();
//		return ResponseEntity.ok(list);
//	}
//	   
//	
	
	
	
   // consulta por nome simples e com like, usando a convensao containing do jpa repository
	@GetMapping(value = "/ArtistNm2/{name}")
	public ResponseEntity<List<ArtistDTO>> buscarNomes(@PathVariable String name) {
    	// System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + name);
		List<ArtistDTO> list = service.findByNameContaining(name);
		return ResponseEntity.ok(list);
	}
	   
	
	
	 
	

		
	   // consulta por id simples
		@GetMapping(value = "/ArtistId2/{id}")
		public ResponseEntity<Optional<Object>> buscarId(@PathVariable Long id) {
	    	//System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + id);
			Optional<Object> list = service.findById(id);
			if (list.isPresent()) {
			  return ResponseEntity.ok(list);
			}
			return ResponseEntity.notFound().build();
		}

		
		// METODO PARA USO COM QUERY NATIVE 
		@GetMapping(value = "/filtro2/{country}")
		public ResponseEntity<List<ArtistDTO>> findByCountryContaining (@PathVariable("country") String country){
			System.out.println("country = " + country);
			
			List<ArtistDTO> list = service.findByCountryContaining(country);
			return ResponseEntity.ok(list);

			  
			
		}








	 

		
		
		
//		public ResponseEntity<List<ArtistDTO>> buscarCountry(@PathVariable String country) {
//	    	System.out.println("TESTE ## PASSANDO POR AQUI 1.0 !!!!! ##### " + country);
//			List<ArtistDTO> list = service.findByCountryContaining(country);
//			
//			System.out.println("TESTE ## PASSANDO POR AQUI 2.0 !!!!! ##### " + country);
//			//System.out.println("LIST1 ## PASSANDO POR AQUI 2.0 !!!!! ##### " + list1.toString());
//			
//			return ResponseEntity.ok(list);
//		}
//		   
		
		
		
		
		
		
		

}
