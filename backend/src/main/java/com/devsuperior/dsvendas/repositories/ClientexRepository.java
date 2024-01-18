package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.dsvendas.dto.ClientexDTO;
import com.devsuperior.dsvendas.entities.Artist;
 
@Repository
public interface ClientexRepository  extends JpaRepository<Artist, Long>{

	
	@Query(value = " SELECT c.id, c.name "
			+ "  FROM clientex c WHERE 0=0 AND c.name = ?1 "
			, nativeQuery = true)
	
    List<ClientexDTO> findByClienteContaining(@RequestParam("?1") String country);
	//Optional<ClientexDTO> findById(Long id);
    List<ClientexDTO> findByAll=null;
	
}
