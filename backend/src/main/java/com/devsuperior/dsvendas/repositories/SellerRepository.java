package com.devsuperior.dsvendas.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devsuperior.dsvendas.entities.Seller;


@Repository
public interface SellerRepository  extends JpaRepository<Seller, Long>{
	 /* Objeto responsavel por buscar e alterar os dados a entidade Seller */
	
	
	List<Seller> findByName = null;
	List<Seller> findByNameContaining(String name);
	Optional<Seller> findByName(String name);
	Optional<Seller> findById(Long id);
	 
    List<Seller> findByAll=null;
	

	
	
	
	
	
}
