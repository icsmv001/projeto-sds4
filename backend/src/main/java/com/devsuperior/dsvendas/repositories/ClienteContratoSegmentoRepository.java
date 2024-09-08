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

    @Transactional(readOnly = true)
    public List<ClienteContratoSegmentoDTO> buscarClienteContratoSegmentoNome(String clientes) {
        String sql = "SELECT " +
                     "    CL.ID_CLIENTECORPORATIVO, " +
                     "    TRANSLATE(PS.NOMEPESQUISA, 'àâêôîûãõáéíóúçüÀÂÊÔÛÎÃÕÁÉÍÓÚÇÜº', 'aaeoiuaoaeioucuAAEOUIAOAEIOUCU') as CLIENTES, " +
                     "    CT.ID_CONTRATO, " +
                     "    TRANSLATE(CT.TITULO, 'àâêôîûãõáéíóúçüÀÂÊÔÛÎÃÕÁÉÍÓÚÇÜº', 'aaeoiuaoaeioucuAAEOUIAOAEIOUCU') as TITULO, " +
                     "    (CASE SE.id_tipocarteira " +
                     "        WHEN 1 THEN 'VEICULO' " +
                     "        WHEN 2 THEN 'RESIDENCIA' " +
                     "        WHEN 3 THEN 'PESSOA' " +
                     "        WHEN 4 THEN 'FUNERAL' " +
                     "        ELSE 'SEM_SEGMENTO' " +
                     "     END) as SEGMENTO " +
                     " FROM SGR.clientecorporativo CL " +
                     "    LEFT JOIN SGR.PESSOA PS ON (CL.ID_PESSOA = PS.ID) " +
                     "    LEFT JOIN SGR.CONTRATO CT ON (CL.ID_CLIENTECORPORATIVO = CT.ID_CLIENTECORPORATIVO) " +
                     "    LEFT JOIN PLANO PL ON (CT.ID_CONTRATO = PL.ID_CONTRATO) " +
                     "    LEFT JOIN sgr.infcarteiraplano SE ON (PL.ID_PLANO = SE.ID_PLANO) " +
                     " WHERE " +
                     "    UPPER(PS.NOMEPESQUISA) LIKE UPPER('%' || ? || '%') " +
                     "    AND UPPER(CT.TITULO) NOT LIKE UPPER('%CANCEL%') " +
                     " GROUP BY " +
                     "    CL.ID_CLIENTECORPORATIVO, PS.NOMEPESQUISA, CT.ID_CONTRATO, CT.TITULO, SE.id_tipocarteira " +
                     " ORDER BY " +
                     "    PS.NOMEPESQUISA, CT.ID_CONTRATO, SE.id_tipocarteira DESC";

        List<ClienteContratoSegmentoDTO> listaCliente = jdbcTemplate.query(sql, new Object[]{clientes}, new BeanPropertyRowMapper<>(ClienteContratoSegmentoDTO.class));
        
        if (listaCliente.isEmpty()) {
            ClienteContratoSegmentoDTO semMovimento = new ClienteContratoSegmentoDTO();
            semMovimento.setCLIENTES("Sem movimento");
            return Collections.singletonList(semMovimento);
        }

        return listaCliente;
    }
}
