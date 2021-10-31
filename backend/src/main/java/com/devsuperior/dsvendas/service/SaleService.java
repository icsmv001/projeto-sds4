package com.devsuperior.dsvendas.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
// objeto de servico 
public class SaleService {
	
	
	// declarar a dependencia com repositorio sellerRepository
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	//criar um metodo para retornar uma lista de seller
	@Transactional(readOnly=true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		
		sellerRepository.findAll();
		
		//para retornar uma lista de seller
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
		
	}
	
	
	

}
