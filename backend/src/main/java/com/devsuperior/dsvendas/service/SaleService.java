package com.devsuperior.dsvendas.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;

@Service
// objeto de servico 
public class SaleService {
	
	
	// declarar a dependencia com repositorio sellerRepository
	@Autowired
	private SaleRepository repository;
	
	//criar um metodo para retornar uma lista de seller
	public Page<SaleDTO> findAll(Pageable pageable) {
		//para retornar uma lista de seller
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
		
	}
	
	
	

}
