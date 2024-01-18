package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.dsvendas.entities.Artist;
import com.devsuperior.dsvendas.nativeQuery.ArtistMinProjection;

@Repository
public interface ArtistRepository4  extends JpaRepository<Artist, Long>{

	
	@Query(
			value = "SELECT a.* FROM artists a WHERE 0=0 AND a.country = ?1"
			, nativeQuery = true)

    List<Artist> findByCountryContaining(@RequestParam("?1") String NAME);
    List<Artist> findByAll=null;
	
    
    
 
    
    
}




