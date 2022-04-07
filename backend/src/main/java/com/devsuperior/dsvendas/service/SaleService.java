package com.devsuperior.dsvendas.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
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
	
	// retornar total vendido agrupado por vendedor.
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupBySeller() {
		return repository.amountGroupBySeller();
		
	}
	
	
	
	// retornar total vendido agrupado por vendedor.
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupBySeller() {
		return repository.successGroupedBySeller();
		
	}
	
	// retorna lista de vendas
	// SaleService
		public List<SaleDTO> findByAll() {
			//para retornar uma lista de Sale
			List<Sale> result = repository.findAll();
			return result.stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
		}


}
