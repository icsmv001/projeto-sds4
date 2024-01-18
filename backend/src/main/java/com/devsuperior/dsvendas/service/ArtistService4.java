package com.devsuperior.dsvendas.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.ArtistDTO;
import com.devsuperior.dsvendas.entities.Artist;
import com.devsuperior.dsvendas.repositories.ArtistRepository4;


@Service
// objeto de servico 
public class ArtistService4 {
	
	// declarar a dependencia com repositorioartistRepository
	@Autowired
	private ArtistRepository4 artistRepository4;
	
		
	//criar um metodo para retornar uma lista deartist, retorna lista sem paginacao
	@Transactional(readOnly = true)
	public Page<ArtistDTO> findAll(Pageable pageable) {
		//para retornar uma lista deartist
		Page<Artist> result =artistRepository4.findAll(pageable );
		return result.map(x -> new ArtistDTO(x));
	}
	
	
	
	
		@Transactional(readOnly=true)
		public List<ArtistDTO> findByCountryContaining(String country){
			//para retornar uma lista de artist
					List<Artist> result =artistRepository4.findByCountryContaining(country);
					return result.stream().map(x -> new ArtistDTO(x)).collect(Collectors.toList());
		}

		
		
		
		
		
		
}
