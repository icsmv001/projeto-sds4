package com.devsuperior.dsvendas.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.ClienteContratoSegmentoDTO;

@Repository
public class ClienteContratoSegmentoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClienteContratoSegmentoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // SQL COM ALIAS (RECOMENDADO)
    private static final String SQL_BASE =
            "SELECT " +
            "    CL.ID_CLIENTECORPORATIVO AS idClientecorporativo, " +
            "    TRANSLATE(PS.NOMEPESQUISA, " +
            "        'àâêôîûãõáéíóúçüÀÂÊÔÛÎÃÕÁÉÍÓÚÇÜº', " +
            "        'aaeoiuaoaeioucuAAEOUIAOAEIOUCU') AS nmClientes, " +
            "    CT.ID_CONTRATO AS idContrato, " +
            "    TRANSLATE(CT.TITULO, " +
            "        'àâêôîûãõáéíóúçüÀÂÊÔÛÎÃÕÁÉÍÓÚÇÜº', " +
            "        'aaeoiuaoaeioucuAAEOUIAOAEIOUCU') AS titulo, " +
            "    NULL AS segmento " + // mantendo compatibilidade com DTO
            " FROM SGR.clientecorporativo CL " +
            " LEFT JOIN SGR.PESSOA PS ON (CL.ID_PESSOA = PS.ID) " +
            " LEFT JOIN SGR.CONTRATO CT ON (CL.ID_CLIENTECORPORATIVO = CT.ID_CLIENTECORPORATIVO) " +
            " LEFT JOIN PLANO PL ON (CT.ID_CONTRATO = PL.ID_CONTRATO) " +
            " WHERE 1=1 " +
            " AND UPPER(CT.TITULO) NOT LIKE UPPER('%CANC%') ";

    private List<ClienteContratoSegmentoDTO> buscarGenerico(String filtroSQL, Object valorFiltro) {

        String sql = SQL_BASE +
                filtroSQL +
                " GROUP BY CL.ID_CLIENTECORPORATIVO, PS.NOMEPESQUISA, CT.ID_CONTRATO, CT.TITULO " +
                " ORDER BY PS.NOMEPESQUISA, CT.ID_CONTRATO DESC";

        List<ClienteContratoSegmentoDTO> lista = jdbcTemplate.query(
                sql,
                new Object[]{valorFiltro},
                new BeanPropertyRowMapper<>(ClienteContratoSegmentoDTO.class)
        );

        //  CORREÇÃO AQUI
        if (lista.isEmpty()) {
            ClienteContratoSegmentoDTO semMovimento = new ClienteContratoSegmentoDTO();
            semMovimento.setNmClientes("Sem movimento");
            return Collections.singletonList(semMovimento);
        }

        return lista;
    }

    @Transactional(readOnly = true)
    public List<ClienteContratoSegmentoDTO> buscarPorNome(String nome) {
        return buscarGenerico(
                " AND UPPER(PS.NOMEPESQUISA) LIKE UPPER(? || '%') ",
                nome
        );
    }

    @Transactional(readOnly = true)
    public List<ClienteContratoSegmentoDTO> buscarPorNomeContrato(String nomeContrato) {
        return buscarGenerico(
                " AND UPPER(CT.TITULO) LIKE UPPER(? || '%') ",
                nomeContrato
        );
    }

    @Transactional(readOnly = true)
    public List<ClienteContratoSegmentoDTO> buscarPorIdCliente(Long idCliente) {
        return buscarGenerico(
                " AND CL.ID_CLIENTECORPORATIVO = ? ",
                idCliente
        );
    }

    @Transactional(readOnly = true)
    public List<ClienteContratoSegmentoDTO> buscarPorIdContrato(Long idContrato) {
        return buscarGenerico(
                " AND CT.ID_CONTRATO = ? ",
                idContrato
        );
    }

    @Transactional(readOnly = true)
    public List<ClienteContratoSegmentoDTO> buscarPorSegmento(Integer tipoCarteira) {
        return buscarGenerico(
                " AND SE.ID_TIPOCARTEIRA = ? ",
                tipoCarteira
        );
    }

    @Transactional(readOnly = true)
    public List<ClienteContratoSegmentoDTO> buscarPorEstrutura(String estrutura) {
        return buscarGenerico(
                " AND UPPER(CT.ESTRUTURA) LIKE UPPER(? || '%') ",
                estrutura
        );
    }
}