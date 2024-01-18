package com.devsuperior.dsvendas.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.GeneresDTO;
import com.devsuperior.dsvendas.entities.Generes;
import com.devsuperior.dsvendas.repositories.GeneresRepository;


@Service
// objeto de servico 
public class GeneresService {
	
	// declarar a dependencia com repositoriogeneresRepository
	@Autowired
	private GeneresRepository generesRepository;
	
	//criar um metodo para retornar uma lista degeneres, retorna lista sem paginacao
	@Transactional(readOnly = true)
	public Page<GeneresDTO> findAll(Pageable pageable) {
		//para retornar uma lista degeneres
		Page<Generes> result = generesRepository.findAll(pageable );
		return result.map(x -> new GeneresDTO(x));
	}
	
	
	@Transactional(readOnly=true)
	public Optional<Object> findById(Long id) {
		Optional<Generes> result =generesRepository.findById(id);
		return result.map(x -> new GeneresDTO(x));
	}

	public List<GeneresDTO> findByAll() {
		//para retornar uma lista degeneres
		List<Generes> result =generesRepository.findAll();
		return result.stream().map(x -> new GeneresDTO(x)).collect(Collectors.toList());
	}

	
	
	
	public List<GeneresDTO> findByName(String name) {
		//para retornar uma lista de generes
		List<Generes> result =generesRepository.findByNameContaining(name);
		return result.stream().map(x -> new GeneresDTO(x)).collect(Collectors.toList());
}

	
		@Transactional(readOnly=true)
		public List<GeneresDTO> findByNameContaining(String name) {
			//para retornar uma lista de generes
					List<Generes> result =generesRepository.findByNameContaining(name);
					return result.stream().map(x -> new GeneresDTO(x)).collect(Collectors.toList());
		}

	 
	
		
		
	 
		
		
		
		
		
		
}
