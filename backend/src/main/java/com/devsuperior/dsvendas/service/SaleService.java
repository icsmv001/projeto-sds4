package com.devsuperior.dsvendas.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
// objeto de servico 
public class SaleService {
	
	
	// declarar a dependencia com repositorio sellerRepository
	@Autowired
	private SaleRepository repository;
	
	//criar um metodo para retornar uma lista de seller
	public List<SaleDTO> findAll() {
		//para retornar uma lista de seller
		List<Sale> result = repository.findAll();
		return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
		
	}
	
	
	

}
