package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import com.devsuperior.dsvendas.entities.Seller;

public class SellerDTO   implements Serializable  {
	/**
	 * representacao dos atribudos da entidade, que recebe os valores vindos da entidade, via servico
	 * apos é fechada a conexao com o banco de dados e passara a usar somento o conteudo do dto.
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	
	//construtor vazio
	public SellerDTO(){
		
	}
	
	//construtor de conversao do valor vindo do servico.entidade, para gravar no DTO.
		public SellerDTO(Long id, String name) {
			this.id = id;
		this.name = name;
	}
		
		
		//construtor que vai receber uma entidade seller, para copiar os dados da entidade para o dto
		public SellerDTO(Seller entity) {
			id = entity.getId();
		    name = entity.getName();
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

	 
	
	
	
	
}
