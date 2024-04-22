package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.LogDashBoardProcessamentosDTO;
@Repository
public class LogDashBoardProcessamentosPageRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LogDashBoardProcessamentosPageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    @Transactional(readOnly = true)
    public Page<LogDashBoardProcessamentosDTO> buscarLogDashBoardProcessamentosPage(Pageable pageable) {
    	 String sql = " WITH MONITORACAO AS (                                                                                         "
    			 +"                    select  distinct                                                                           " 
    			 +"                    ES.ID_ESTRUTURA,                                                                          "
    			 +"                    ES.SIGLA,                                                                                 "
    			 +"                    upper(ES.DESCRICAO) NM_ESTRUTURA,                                                         "      
    			 +"                    CASE                                                                                      "
    			 +"                       WHEN TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) <= TRUNC(SYSDATE)                         "
    			 +"                          THEN  ('SEM_MOVTOS')                                                                "
    			 +"                       WHEN TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) > TRUNC(SYSDATE)                          "
    			 +"                          THEN  ('PENDENTES ')                                                                "
    			 +"                       ELSE    ('PROCESSADO')                                                                 "
    			 +"                    END STATUS_LOG,                                                                           "
    			 +"                    CA.DATA as DATA_CALENDARIO,                                                               "
    			 +"                    CASE                                                                                      "                                                                     
    			 +"                    WHEN TRIM(LO.HORA) IS NULL THEN ('00:00:00 ')                                             "                                                         
    			 +"                    ELSE TO_CHAR(LO.HORA, 'HH24:MI:SS')                                                       "                            
    			 +"                    END HORA,                                                                                 "
    			 +"                    case                                                                                      "
    			 +"                       when trim(LO.totalregistros) is null                                                   "
    			 +"                        then lpad('0', '1')                                                                   "
    			 +"                       else trim(LO.totalregistros)                                                           "
    			 +"                    end totalregistros                                                                        "
    			 +"                 ,ROW_NUMBER() OVER (PARTITION BY ES.ID_ESTRUTURA, CA.DATA ORDER BY LO.ID_SEQLOG DESC) AS RN  "                                                                     
    			 +"                 from PROCESSAMENTO.CALENDARIO_PRODUCAO CA                                                    "
    			 +"                    full outer join sgr.estrutura ES  ON ( ES.ID_ESTRUTURA IS NOT NULL                        "
    			 +"                                                          AND ES.ID_ESTRUTURA IS NOT NULL                     "
    			 +"                                      AND ES.DESCRICAO NOT LIKE '%CANCEL%'                                    "
    			 +"                                      AND ES.DESCRICAO NOT LIKE '%CANCEL%'                                    "
    			 +"                                     )                                                                        "
    			 +"                    left join sgr.logentrada      LO  ON (CA.DATA = LO.DATA                                   "
    			 +"                                                           AND (LO.arquivoorigem like '%' || ES.SIGLA || '%') "
    			 +"                                       )                                                                      "
    			 +"                     left join sgr.contrato       CT  ON (ES.id_clientecorporativo = ct.id_clientecorporativo "
    			 +"                                                         and ES.id_contrato = ct.id_contrato                  "
    			 +"                                       and ct.titulo not like '%CANCEL%'                                      "
    			 +"                                     )                                                                        "
    			 +"                 WHERE 0 = 0                                                                                  "
    			 +"                    AND ES.DESCRICAO NOT LIKE '%DESATIVA%'                                                    "
                 +"                    AND CT.TITULO NOT LIKE '%CANC%'                                                           "
                 +"                    AND CT.TITULO NOT LIKE '%CACE%'                                                           "
    			 +"                    AND CA.DATA IS NOT NULL                                                                   "
    			 +"                    AND ca.data between SYSDATE - 9 and SYSDATE +1                                           "
    			 +")                                                                                                             "
    			 +"                                                                                                              "
    			 +" SELECT                                                                                                       "
    			 +"    M.ID_ESTRUTURA                                                                                            "
    			 +"   ,M.SIGLA	                                                                                                 "
    			 +"   ,M.NM_ESTRUTURA	                                                                                         "
    			 +"   ,M.STATUS_LOG	                                                                                             "
    			 +"   ,M.DATA_CALENDARIO	                                                                                     "
    			 +"   ,M.HORA	                                                                                                 "
    			 +"   ,M.TOTALREGISTROS                                                                                          "
    			 +"   ,M.RN                                                                                                      "
    			 +" FROM MONITORACAO M                                                                                           "
    			 +"    WHERE RN=1                                                                                                "
    			 +" ORDER BY ID_ESTRUTURA, DATA_CALENDARIO DESC                                                              ";
    			                                                                                                                 
        
    	 
    	    // Executa a consulta com paginação
            List<LogDashBoardProcessamentosDTO> resultList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LogDashBoardProcessamentosDTO.class));

            // Calcula o índice inicial e final da página
            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), resultList.size());

           // Verifica se end não ultrapassa o tamanho da lista
            if (end > resultList.size()) {
                end = resultList.size();
            }

            
            // Cria uma sublista dos resultados correspondentes à página atual
            List<LogDashBoardProcessamentosDTO> pageList = resultList.subList(start, end);

            // Retorna uma instância de Page contendo os resultados da página atual
            return new PageImpl<>(pageList, pageable, resultList.size());
     
    }
}