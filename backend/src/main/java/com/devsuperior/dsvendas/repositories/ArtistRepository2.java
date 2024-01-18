package com.devsuperior.dsvendas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.dsvendas.entities.Artist;

@Repository
public interface ArtistRepository2  extends JpaRepository<Artist, Long>{

	
	@Query(
			value = "SELECT a.* FROM artists a WHERE 0=0 AND a.country = ?1"
			, nativeQuery = true)
	
	// public List<Artist> findByCountry(String country);
    List<Artist> findByCountryContaining(@RequestParam("?1") String country);

	

	List<Artist> findByName = null;
	List<Artist> findByNameContaining(String name);
	Optional<Artist> findByName(String name);
	Optional<Artist> findById(Long id);
	//Optional<Artist> findByCountry(String country);
	 
    List<Artist> findByAll=null;
	
	
	//List<Artist> findByCountryContaining(String country);
	
	
	
	
	
	
}
