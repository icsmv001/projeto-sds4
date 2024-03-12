package com.devsuperior.dsvendas.repositories;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsvendas.dto.LogProcessamentosDTO;
@Repository
public class LogProcessamentosPageRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LogProcessamentosPageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Page<LogProcessamentosDTO> buscarLogProcessamentosPage(org.springframework.data.domain.Pageable pageable) {
    	   String sql = " select "  
    				+ "   ID_SEQLOG,DATA,HORA,STATUS,ID_ESTRUTURA,TIPO_CARGA,SIGLA,ID_CLIENTECORPORATIVO,ID_CONTRATO," 
    				+ "   DESCRICAO,TIPOCARTEIRA,LOCAL_ARQUIVO,TOTALREGISTROS,REGCORRETOS,REGINCORRETOS,REGENVVENCIDO,PERCENTUAL_CORRETO," 
    				+ "   PERCENTUAL_INCORRETO,PERCENTUAL_VENCIDOS" 
    				+ "  from LOG_PROCESSAMENTOS l where 0=0  ";
        
        return new PageImpl<>(jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LogProcessamentosDTO.class)), pageable, 10);
    }
}