package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Seller;

public interface SellerRepository  extends JpaRepository <Seller, Long>{
	 /* Objeto responsavel por buscar e alterar os dados a entidade Seller */
	
	
	

}
