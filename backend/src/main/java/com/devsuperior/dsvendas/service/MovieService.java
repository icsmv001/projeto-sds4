package com.devsuperior.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.MovieDTO;
import com.devsuperior.dsvendas.entities.Movie;
import com.devsuperior.dsvendas.repositories.MovieRepository;

       
@Service
public class MovieService {
	
	
	//metodo repository, que fara o acesso ao dados do banco, para repassar a camada de servico
	@Autowired
	
	private MovieRepository repository;
	
	
	//metodo publico para buscar os filmes e retornar numa lista para o MovieDTO, assim o retorno deve ser uma lista de DTO,
	// trocar List por Page, para retorno vir como uma lista paginada.
	@Transactional(readOnly =true)
	public Page<MovieDTO> findAll(Pageable pegeable){
		// chamando o banco de dados , de modo que o retorno da busca findAll, seja uma lista de movie
		Page <Movie> result = repository.findAll(pegeable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x) );
		return page;
	}
	
	// criar metodo para pegar um unico filme
	@Transactional(readOnly =true)
	public MovieDTO findById(Long id){
	
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
	

}
