package com.devsuperior.dsvendas.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id_clientecorporativo",
    "nm_clientes",
    "id_contrato",
    "titulo",
    "segmento"
})
public class ClienteContratoSegmentoDTO {

    @JsonProperty("id_clientecorporativo")
    private Integer idClientecorporativo;

    @JsonProperty("nm_clientes")
    private String nmClientes;

    @JsonProperty("id_contrato")
    private Integer idContrato;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("segmento")
    private String segmento;

    // getters e setters (PADRÃO JAVA)
    public Integer getIdClientecorporativo() {
        return idClientecorporativo;
    }

    public void setIdClientecorporativo(Integer idClientecorporativo) {
        this.idClientecorporativo = idClientecorporativo;
    }

    public String getNmClientes() {
        return nmClientes;
    }

    public void setNmClientes(String nmClientes) {
        this.nmClientes = nmClientes;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public ClienteContratoSegmentoDTO() {
    }
}