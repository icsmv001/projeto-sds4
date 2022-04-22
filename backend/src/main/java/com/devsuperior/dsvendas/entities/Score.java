package com.devsuperior.dsvendas.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_score")
public class Score {
	

    @EmbeddedId	
	// declarando uma chave composta, e dar new, que garane fique instanciado.
	private ScorePK id = new  ScorePK();
	
	
	private Double value;
	
	
	public Score() {
		
	}

	//metodo para associar um filme ao score,
	// id que é tipo scorpk, recebe o id do movie.
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}

	
	//metodo para associar um filme ao score,
		// id que é tipo scorpk, recebe o id do movie.
		public void setUser(User user) {
			id.setUser(user);
		}
	
	
	
	
	
	public ScorePK getId() {
		return id;
	}


	public void setId(ScorePK id) {
		this.id = id;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}
	
	

}
