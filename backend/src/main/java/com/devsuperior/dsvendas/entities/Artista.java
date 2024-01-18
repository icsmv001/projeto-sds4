package com.devsuperior.dsvendas.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista {
	
	@Id
	private Long id;
	private String name;
	private Instant birthdate;
	private String country;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Generes generes;
	
	public Artista() {
	}

	public Artista(Long id, String name, Instant birthdate, String country, Generes generes) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.country = country;
		this.generes = generes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Instant birthdate) {
		this.birthdate = birthdate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Generes getGenre() {
		return generes;
	}

	public void setGenre(Generes generes) {
		this.generes = generes;
	}
	
}