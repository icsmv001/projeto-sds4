package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository  extends JpaRepository <Sale, Long>{
	 /* Objeto responsavel por buscar e alterar os dados a entidade Seller */
	
	
	// criar metodo customizado adicionado para recuperar os agrupamentos de valores 
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) " 
			+ "From Sale AS obj GROUP BY obj.seller" )
	List<SaleSumDTO> amountGroupBySeller();
		

	
	
	// criar metodo customizado adicionado para recuperar os agrupamentos
	// visitas e negocios fechados por vendedor
	@Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) " 
			+ "From Sale AS obj GROUP BY obj.seller" )
	List<SaleSuccessDTO> successGroupedBySeller();
		

	
	
}
