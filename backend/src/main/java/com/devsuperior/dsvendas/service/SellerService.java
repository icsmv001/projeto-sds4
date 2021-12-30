package com.devsuperior.dsvendas.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
// objeto de servico 
public class SellerService {
	
	// declarar a dependencia com repositorio sellerRepository
	@Autowired
	private SellerRepository repository;
	
	//criar um metodo para retornar uma lista de seller
	public List<SellerDTO> findAll() {
		//para retornar uma lista de seller
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
		
	}

	 
	public List<SellerDTO> findByNameContaining(String name){
		
		//para retornar uma lista de seller
				List<Seller> result = repository.findByNameContaining(name);
				return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
				
	
	}
}
