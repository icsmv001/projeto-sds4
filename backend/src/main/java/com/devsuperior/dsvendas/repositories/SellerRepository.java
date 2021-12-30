package com.devsuperior.dsvendas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsvendas.entities.Seller;


@Repository
public interface SellerRepository  extends JpaRepository <Seller, Long>{
	 /* Objeto responsavel por buscar e alterar os dados a entidade Seller */
	
	
	//List<Seller> findByName = null;

	Optional<Seller> findByName(String name);

	List<Seller> findByNameContaining(String name);
	


}
