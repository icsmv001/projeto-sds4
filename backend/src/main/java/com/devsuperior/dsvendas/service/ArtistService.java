package com.devsuperior.dsvendas.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.ArtistDTO;
import com.devsuperior.dsvendas.entities.Artist;
import com.devsuperior.dsvendas.repositories.ArtistRepository2;


@Service
// objeto de servico 
public class ArtistService {
	
	// declarar a dependencia com repositorioartistRepository
	@Autowired
	private ArtistRepository2 artistRepository2;
	
	//criar um metodo para retornar uma lista deartist, retorna lista sem paginacao
	@Transactional(readOnly = true)
	public Page<ArtistDTO> findAll(Pageable pageable) {
		//para retornar uma lista deartist
		Page<Artist> result = artistRepository2.findAll(pageable );
		return result.map(x -> new ArtistDTO(x));
	}
	
	
	@Transactional(readOnly=true)
	public Optional<Object> findById(Long id) {
		Optional<Artist> result =artistRepository2.findById(id);
		return result.map(x -> new ArtistDTO(x));
	}

	public List<ArtistDTO> findByAll() {
		//para retornar uma lista deartist
		List<Artist> result =artistRepository2.findAll();
		return result.stream().map(x -> new ArtistDTO(x)).collect(Collectors.toList());
	}

	
	
	
	public List<ArtistDTO> findByCountry(String country) {
		//para retornar uma lista de artist
		List<Artist> result =artistRepository2.findByCountryContaining(country);
		return result.stream().map(x -> new ArtistDTO(x)).collect(Collectors.toList());
}

	
		@Transactional(readOnly=true)
		public List<ArtistDTO> findByNameContaining(String name) {
			//para retornar uma lista de artist
					List<Artist> result =artistRepository2.findByNameContaining(name);
					return result.stream().map(x -> new ArtistDTO(x)).collect(Collectors.toList());
		}

	 
	
		
		
		@Transactional(readOnly=true)
		public List<ArtistDTO> findByCountryContaining(String country){
			//para retornar uma lista de artist
					List<Artist> result =artistRepository2.findByCountryContaining(country);
					return result.stream().map(x -> new ArtistDTO(x)).collect(Collectors.toList());
		}

		
		
		
		
		
		
}
