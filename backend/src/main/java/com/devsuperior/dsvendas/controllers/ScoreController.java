package com.devsuperior.dsvendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.MovieDTO;
import com.devsuperior.dsvendas.dto.ScoreDTO;
import com.devsuperior.dsvendas.service.ScoreService;

@RestController
@RequestMapping(value="/scores")
public class ScoreController {
	
//	@Autowired
//	private MovieService service;
//	// cirar um metodo de requisicao para retornar pagina de filmes
//	
//	@GetMapping
//	public Page<MovieDTO> findAll(Pageable pageable) {
//		return service.findAll(pageable);
//	}
//	
	
	@Autowired
    private ScoreService service ;
    
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto ) {
		 
		MovieDTO moviedto = service.saveScore(dto);
		return moviedto;
		 
	}

	
	

}
