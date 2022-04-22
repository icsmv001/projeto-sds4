package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsvendas.entities.Movie;

public interface  MovieRepository extends JpaRepository<Movie, Long> {
//implementacao de objeto que fara o acesso ao banco de dados para salvar, atualizar, cancelar, buscar


}
