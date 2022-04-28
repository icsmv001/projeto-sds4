package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.User;

public interface  UserRepository extends JpaRepository<User, Long> {
//implementacao de objeto que fara o acesso ao banco de dados para salvar, atualizar, cancelar, buscar


	
	User findByEmail( String email);
	
	
	
	
	
}
