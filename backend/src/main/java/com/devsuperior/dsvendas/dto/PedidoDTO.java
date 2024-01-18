package com.devsuperior.dsvendas.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class PedidoDTO {
	private Long id_pedido;
	private String cliente;
	private BigDecimal total;
	
	
	public Long getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	

@JsonCreator
public PedidoDTO(@JsonProperty("id_pedido") Long id_pedido,
            @JsonProperty("cliente") String cliente, 
            @JsonProperty("total") BigDecimal total) {
	        this.id_pedido = id_pedido;
	        this.cliente = cliente;
	        this.total = total;
	    }

public PedidoDTO() {
    // Construtor vazio
}
	
}
