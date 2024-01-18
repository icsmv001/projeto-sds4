package com.devsuperior.dsvendas.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.ArtistDTO;
import com.devsuperior.dsvendas.entities.Artist;
import com.devsuperior.dsvendas.repositories.ArtistRepository3;


@Service
// objeto de servico 
public class ArtistService3 {
	
	// declarar a dependencia com repositorioartistRepository
	@Autowired
	private ArtistRepository3 artistRepository3;
	
		
		@Transactional(readOnly=true)
		public List<ArtistDTO> findByCountryContaining(String country){
			//para retornar uma lista de artist
					List<Artist> result =artistRepository3.findByCountryContaining(country);
					return result.stream().map(x -> new ArtistDTO(x)).collect(Collectors.toList());
		}

		
		
		
		
		
		
}
