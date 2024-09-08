package com.devsuperior.dsvendas.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteContratoSegmentoDTO {

    private Integer ID_CLIENTECORPORATIVO;
    private String CLIENTES;
    private Integer ID_CONTRATO;
    private String TITULO;
    private String SEGMENTO;

    public Integer getID_CLIENTECORPORATIVO() {
        return ID_CLIENTECORPORATIVO;
    }

    public void setID_CLIENTECORPORATIVO(Integer iD_CLIENTECORPORATIVO) {
        ID_CLIENTECORPORATIVO = iD_CLIENTECORPORATIVO;
    }

    public String getCLIENTES() {
        return CLIENTES;
    }

    public void setCLIENTES(String cLIENTES) {
        CLIENTES = cLIENTES;
    }

    public Integer getID_CONTRATO() {
        return ID_CONTRATO;
    }

    public void setID_CONTRATO(Integer iD_CONTRATO) {
        ID_CONTRATO = iD_CONTRATO;
    }

    public String getTITULO() {
        return TITULO;
    }

    public void setTITULO(String tITULO) {
        TITULO = tITULO;
    }

    public String getSEGMENTO() {
        return SEGMENTO;
    }

    public void setSEGMENTO(String sEGMENTO) {
        SEGMENTO = sEGMENTO;
    }

    @JsonCreator
    public ClienteContratoSegmentoDTO(
            @JsonProperty("ID_CLIENTECORPORATIVO") Integer ID_CLIENTECORPORATIVO,
            @JsonProperty("CLIENTES") String CLIENTES,
            @JsonProperty("ID_CONTRATO") Integer ID_CONTRATO,
            @JsonProperty("TITULO") String TITULO,
            @JsonProperty("SEGMENTO") String SEGMENTO) {
        this.ID_CLIENTECORPORATIVO = ID_CLIENTECORPORATIVO;
        this.CLIENTES = CLIENTES;
        this.ID_CONTRATO = ID_CONTRATO;
        this.TITULO = TITULO;
        this.SEGMENTO = SEGMENTO;
    }

    public ClienteContratoSegmentoDTO() {
        // Construtor padrão necessário para serialização/desserialização
    }
}
