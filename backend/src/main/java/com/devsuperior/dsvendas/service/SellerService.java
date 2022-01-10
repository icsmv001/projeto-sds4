package com.devsuperior.dsvendas.service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.transaction.annotation.Transactional;


@Service
// objeto de servico 
public class SellerService {
	
	// declarar a dependencia com repositorio sellerRepository
	@Autowired
	private SellerRepository sellerRepository;
	
	//criar um metodo para retornar uma lista de seller, retorna lista sem paginacao
	@Transactional(readOnly = true)
	public Page<SellerDTO> findAll(Pageable pageable) {
		//para retornar uma lista de seller
		Page<Seller> result = sellerRepository.findAll(pageable );
		return result.map(x -> new SellerDTO(x));
	}
	
	@Transactional(readOnly=true)
	public List<SellerDTO> findByNameContaining(String name){
		//para retornar uma lista de seller
				List<Seller> result = sellerRepository.findByNameContaining(name);
				return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly=true)
	public Optional<Object> findById(Long id) {
		Optional<Seller> result = sellerRepository.findById(id);
		return result.map(x -> new SellerDTO(x));
	}


	
	
	
	
	

	
}
