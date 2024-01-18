package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsuperior.dsvendas.entities.User;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {
//implementacao de objeto que fara o acesso ao banco de dados para salvar, atualizar, cancelar, buscar


	
	User findByEmail( String email);
	
	@Query(
			value = "SELECT a.id as id, a.email as email FROM tb_user a WHERE 0=0 AND a.email = ?1"
			, nativeQuery = true)
	
	List<User> getUserEmailContaining(@RequestParam("?1") String email);

	
	
	
	
}
