package com.devsuperior.dsvendas.dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class ExecutarProcedureCadCobrAutoDTO {
    private int idCobranca;
    private int diaExecucao;
    private String usuario;

    // getters e setters
    public int getIdCobranca() {
        return idCobranca;
    }

    public void setIdCobranca(int idCobranca) {
        this.idCobranca = idCobranca;
    }

    public int getDiaExecucao() {
        return diaExecucao;
    }

    public void setDiaExecucao(int diaExecucao) {
        this.diaExecucao = diaExecucao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}