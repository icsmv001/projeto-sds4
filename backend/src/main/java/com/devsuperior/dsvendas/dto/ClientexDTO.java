package com.devsuperior.dsvendas.dto;
import java.io.Serializable;

public class ClientexDTO   implements Serializable  {
	/**
	 * representacao dos atribudos da entidade, que recebe os valores vindos da entidade, via servico
	 * apos é fechada a conexao com o banco de dados e passara a usar somento o conteudo do dto.
	 */
	private static final long serialVersionUID = 1L;
	      
	    private Long id;
	    private String name;
	     
	    public ClientexDTO(Long id, String name) {
	        this.id = id;
	        this.name = name;
	    }
	 
	    public ClientexDTO(ClientexDTO x) {
			// TODO Auto-generated constructor stub
		}

		public Long getid() {
	        return id;
	    }
	     
	    public String getname() {
	        return name;
	    }
	     
	}
