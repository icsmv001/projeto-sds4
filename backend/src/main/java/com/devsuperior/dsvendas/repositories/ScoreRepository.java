package com.devsuperior.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsvendas.entities.Score;
import com.devsuperior.dsvendas.entities.ScorePK;
@Repository
public interface  ScoreRepository extends JpaRepository<Score, ScorePK> {
//implementacao de objeto que fara o acesso ao banco de dados para salvar, atualizar, cancelar, buscar


}
