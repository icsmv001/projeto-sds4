package com.devsuperior.dsvendas.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.ClientexDTO;
import com.devsuperior.dsvendas.repositories.ClientexRepository;

@Service
public class xClientexService {
	@Autowired
	private ClientexRepository clientexRepository;
	

	public List<ClientexDTO> findByClienteContaining(String name) {
		// TODO Auto-generated method stub
		List<ClientexDTO> result =clientexRepository.findByClienteContaining(name);
		return result.stream().map(x -> new ClientexDTO(x)).collect(Collectors.toList());		
	}

}
