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

import com.devsuperior.dsvendas.dto.GeneresDTO;
import com.devsuperior.dsvendas.service.GeneresService;

@Controller
@RestController
@RequestMapping(value = "/Generes")

public class GeneresController {

	@Autowired
	private GeneresService service;
	
	@GetMapping
	public ResponseEntity<Page<GeneresDTO>> findAll(Pageable pageable) {
		Page<GeneresDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);

	}
	
 	
   @GetMapping(value = "/GeneresNm/{name}")
	public ResponseEntity<List<GeneresDTO>> buscarNomes(@PathVariable String name) {
    	 System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + name);
		List<GeneresDTO> list = service.findByNameContaining(name);
		return ResponseEntity.ok(list);
	}
	   
	
	
	    @GetMapping(value = "/Generes")
		public ResponseEntity<List<GeneresDTO>> buscarGeneress() {
	    	// System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + name);
			List<GeneresDTO> list = service.findByAll();
			return ResponseEntity.ok(list);
		}
		   
		
	    @GetMapping(value = "/GeneresId/{id}")
		public ResponseEntity<Optional<Object>> buscarId(@PathVariable Long id) {
	    	//System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + id);
			Optional<Object> list = service.findById(id);
			if (list.isPresent()) {
			  return ResponseEntity.ok(list);
			}
			return ResponseEntity.notFound().build();
		}

        @GetMapping(value = "/Name/{name}")
        public ResponseEntity<List<GeneresDTO>> findByName(@PathVariable String name) {
   	    System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + name);
   	    List<GeneresDTO> list = service.findByName(name);
	    return ResponseEntity.ok(list);
        }
	
}
