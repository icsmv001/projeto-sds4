package com.devsuperior.dsvendas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.dsvendas.entities.Generes;

@Repository
public interface GeneresRepository  extends JpaRepository<Generes, Long>{

	
	@Query(
			value = "SELECT a.* FROM generes a WHERE 0=0 AND upper(a.name) = upper(?1)"
			, nativeQuery = true)
	
	// public List<Generes> findByName(String name);
    List<Generes> findByNameContaining(@RequestParam("?1") String name);

	

	 
	    
	//Optional<Generes> findByName(String name);
	Optional<Generes> findById(Long id);
	//Optional<Generes> findByName(String name);
	 
    List<Generes> findByAll=null;
	
	
	//List<Generes> findByNameContaining(String name);
	
	
	
	
	
	
}
