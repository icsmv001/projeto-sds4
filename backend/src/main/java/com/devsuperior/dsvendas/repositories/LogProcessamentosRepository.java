package com.devsuperior.dsvendas.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.devsuperior.dsvendas.dto.LogProcessamentosDTO;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Repository
public class LogProcessamentosRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LogProcessamentosRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<LogProcessamentosDTO> buscarLogProcessamentoss() {
        String sql = " select "  
			+ "   ID_SEQLOG,DATA,HORA,STATUS,ID_ESTRUTURA,TIPO_CARGA,SIGLA,ID_CLIENTECORPORATIVO,ID_CONTRATO," 
			+ "   DESCRICAO,TIPOCARTEIRA,LOCAL_ARQUIVO,TOTALREGISTROS,REGCORRETOS,REGINCORRETOS,REGENVVENCIDO,PERCENTUAL_CORRETO," 
			+ "   PERCENTUAL_INCORRETO,PERCENTUAL_VENCIDOS" 
			+ "  from LOG_PROCESSAMENTOS l where 0=0  ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LogProcessamentosDTO.class));
    }
    
    
    
   public List<LogProcessamentosDTO> buscarLogProcessamentosData(Date dataInicio, Date dataFim) {
        String sql = " select "  
			+ "   l.ID_SEQLOG,l.DATA,l.HORA,l.STATUS,l.ID_ESTRUTURA,l.TIPO_CARGA,l.SIGLA,l.ID_CLIENTECORPORATIVO,l.ID_CONTRATO," 
			+ "   l.DESCRICAO,l.TIPOCARTEIRA,l.LOCAL_ARQUIVO,l.TOTALREGISTROS,l.REGCORRETOS,l.REGINCORRETOS,l.REGENVVENCIDO,l.PERCENTUAL_CORRETO," 
			+ "   l.PERCENTUAL_INCORRETO,l.PERCENTUAL_VENCIDOS" 
			+ "  from LOG_PROCESSAMENTOS l where 0=0 "
			+ "  and  l.DATA >= ? AND l.DATA <= ? "
            + "  order by l.data desc";
        
        // return jdbcTemplate.query(sql, new Object[]{dataInicio, dataFim}, new BeanPropertyRowMapper<>(LogProcessamentosDTO.class));
        List<LogProcessamentosDTO> logs = jdbcTemplate.query(sql, new Object[]{dataInicio, dataFim}, new BeanPropertyRowMapper<>(LogProcessamentosDTO.class));
        if (logs.isEmpty()) {
            // Não há movimento para o intervalo de datas
            LogProcessamentosDTO semMovimento = new LogProcessamentosDTO();
            semMovimento.setDESCRICAO("Sem movimento");
            return Collections.singletonList(semMovimento);
        }

        return logs;
   }

   
   public List<LogProcessamentosDTO> buscarLogProcessamentosIdEstrutura(String id_estrutura) {
       String sql = " select "  
			+ "   l.ID_SEQLOG,l.DATA,l.HORA,l.STATUS,l.ID_ESTRUTURA,l.TIPO_CARGA,l.SIGLA,l.ID_CLIENTECORPORATIVO,l.ID_CONTRATO," 
			+ "   l.DESCRICAO,l.TIPOCARTEIRA,l.LOCAL_ARQUIVO,l.TOTALREGISTROS,l.REGCORRETOS,l.REGINCORRETOS,l.REGENVVENCIDO,l.PERCENTUAL_CORRETO," 
			+ "   l.PERCENTUAL_INCORRETO,l.PERCENTUAL_VENCIDOS" 
			+ "  from LOG_PROCESSAMENTOS l where 0=0 "
			+ "  and  l.ID_ESTRUTURA in ( ? ) ";
       
       // return jdbcTemplate.query(sql, new Object[]{dataInicio, dataFim}, new BeanPropertyRowMapper<>(LogProcessamentosDTO.class));
       List<LogProcessamentosDTO> logs = jdbcTemplate.query(sql, new Object[]{id_estrutura}, new BeanPropertyRowMapper<>(LogProcessamentosDTO.class));
       if (logs.isEmpty()) {
           // Não há movimento para o intervalo de datas
           LogProcessamentosDTO semMovimento = new LogProcessamentosDTO();
           semMovimento.setDESCRICAO("Sem movimento");
           return Collections.singletonList(semMovimento);
       }

       return logs;
  }
    
   
   
    
}