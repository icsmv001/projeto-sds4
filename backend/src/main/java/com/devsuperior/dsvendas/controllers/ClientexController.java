package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.ClientexDTO;

@Controller
@RestController
@RequestMapping(value = "/Clientex")

public class ClientexController {

	@Autowired
	private xClientexService service;
	
	
		// METODO PARA USO COM QUERY NATIVE 
		@GetMapping(value = "/filtro3/{name}")
		public ResponseEntity<List<ClientexDTO>> findByClienteContaining (@PathVariable("name") String name){
			System.out.println("name = " + name);
			
			List<ClientexDTO> list = service.findByClienteContaining(name);
			return ResponseEntity.ok(list);
		}
}
