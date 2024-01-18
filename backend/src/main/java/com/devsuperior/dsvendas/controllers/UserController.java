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

import com.devsuperior.dsvendas.dto.UserDTO;
import com.devsuperior.dsvendas.service.UserService;

@Controller
@RestController
@RequestMapping(value = "/User")

public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
		Page<UserDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);

	}
	
 
	
	
	
// // consulta por nome simples e com like, usando a convensao containing do jpa repository
//	@GetMapping(value = "/User2")
//	public ResponseEntity<List<UserDTO>> buscarUsers() {
//    	// System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + Email);
//		List<UserDTO> list = service.findByAll();
//		return ResponseEntity.ok(list);
//	}
//	   
//	
	
	
	
   // consulta por nome simples e com like, usando a convensao containing do jpa repository
	@GetMapping(value = "/UserNm2/{Email}")
	public ResponseEntity<List<UserDTO>> buscarNomes(@PathVariable String Email) {
    	// System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + Email);
		List<UserDTO> list = service.findByEmailContaining(Email);
		return ResponseEntity.ok(list);
	}
	   
	
	   // consulta por nome simples e com like, usando a convensao containing do jpa repository
		@GetMapping(value = "/Nome/{Email}")
		public ResponseEntity<List<UserDTO>> buscarNomeUsers(@PathVariable String Email) {
	    	// System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + Email);
			List<UserDTO> list = service.findByEmailContaining(Email);
			return ResponseEntity.ok(list);
		}
		  
	
	 
	

		
	   // consulta por id simples
		@GetMapping(value = "/UserId2/{id}")
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
		public ResponseEntity<List<UserDTO>> findByCountryContaining (@PathVariable("country") String country){
			System.out.println("country = " + country);
			
			List<UserDTO> list = service.findByEmailContaining(country);
			return ResponseEntity.ok(list);

			  
			
		}








	 

		
		
		
//		public ResponseEntity<List<UserDTO>> buscarCountry(@PathVariable String country) {
//	    	System.out.println("TESTE ## PASSANDO POR AQUI 1.0 !!!!! ##### " + country);
//			List<UserDTO> list = service.findByCountryContaining(country);
//			
//			System.out.println("TESTE ## PASSANDO POR AQUI 2.0 !!!!! ##### " + country);
//			//System.out.println("LIST1 ## PASSANDO POR AQUI 2.0 !!!!! ##### " + list1.toString());
//			
//			return ResponseEntity.ok(list);
//		}
//		   
		
		
		
		
		
		
		

}
