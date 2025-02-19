package com.devsuperior.dsvendas.repositories;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;






@Repository
public class LogDashBoardProcessamentosPageRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LogDashBoardProcessamentosPageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //recupera consulta de movimentacao por estrutura geral dos ultimos 7 dias.
    @Transactional(readOnly = true)
    public Page<LogDashBoardProcessamentosDTO> buscarLogDashBoardProcessamentosPage(Pageable pageable) {
    	 String sql = " WITH MONITORACAO_D1 AS (                                                                                         "
    			 +"                    select  distinct                                                                           " 
    			 +"                    ES.ID_ESTRUTURA,                                                                          "
    			 +"                    ES.SIGLA,                                                                                 "
    			 +"                    upper(ES.DESCRICAO) NM_ESTRUTURA,                                                         "      
                 +" to_char(case                                                                                                 "
                 +"  	                     when trim(LO.totalregistros) is null  and TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) < TRUNC(SYSDATE) "                          
                 +"  	                        THEN  ('SEM MVTO')                                                                            "
                 +"	                     when trim(LO.totalregistros) is null  and TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) >= TRUNC(SYSDATE)   "                      
    	         +"                                     THEN  ('PENDENTE')                "
    	         +"                   else 'PROCESSADO'                                    "                          
    	         +"              end ) STATUS_LOG , "
    	         +"                    CA.DATA as DATA_CALENDARIO,                                                               "
    			 +"                    CASE                                                                                      "                                                                     
    			 +"                    WHEN TRIM(LO.HORA) IS NULL THEN ('00:00:00 ')                                             "                                                         
    			 +"                    ELSE TO_CHAR(LO.HORA, 'HH24:MI:SS')                                                       "                            
    			 +"                    END HORA,                                                                                 "
    			 +" to_char(case                                                                                                 "
                 +"    when trim(LO.totalregistros) is null  and TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) <= TRUNC(SYSDATE)  "                        
                 +"       THEN  ('SMVTO')   "
                 +"    when trim(LO.totalregistros) is null  and TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) > TRUNC(SYSDATE)     "                    
                 +"                    THEN  ('PNDNT')  "              
                 +"    else trim(LO.totalregistros)   "                                                           
                 +" end ) totalregistros "
    			 +"                 ,ROW_NUMBER() OVER (PARTITION BY ES.ID_ESTRUTURA, CA.DATA ORDER BY LO.ID_SEQLOG DESC) AS RN  "                                                                     
    			 +"                 from PROCESSAMENTO.CALENDARIO_PRODUCAO CA                                                    "
    			 +"                    full outer join sgr.estrutura ES  ON ( ES.ID_ESTRUTURA IS NOT NULL                        "
    			 +"                                                          AND ES.ID_ESTRUTURA IS NOT NULL                     "
    			 +"                                      AND ES.DESCRICAO NOT LIKE '%CANCEL%'                                    "
    			 +"                                      AND ES.DESCRICAO NOT LIKE '%CANCEL%'                                    "
    			 +"                                      AND ES.DESCRICAO NOT LIKE '%MIGOU_API%'                                    "
    			 +"                                     )                                                                        "
    			 +"                    left join sgr.logentrada      LO  ON (CA.DATA = LO.DATA                                   "
    			 +"                                                           AND (LO.arquivoorigem like '%' || ES.SIGLA || '%') "
    			 +"                                       )                                                                      "
    			 +"                     left join sgr.contrato       CT  ON (ES.id_clientecorporativo = ct.id_clientecorporativo "
    			 +"                                                         and ES.id_contrato = ct.id_contrato                  "
    			 +"                                       and ct.titulo not like '%CANCEL%'                                      "
    			 +"                                       and ct.titulo not like '%MIGROU_API%'                                      "
    			 +"                                     )                                                                        "
    			 +"                 WHERE 0 = 0                                                                                  "
    			 +"    			    and es.id_estrutura in (  SELECT  e.ID_ESTRUTURA                                             "
                 +"                                              from sgr.estrutura E                                            "
                 +"                                           full outer join sgr.logentrada l                                   "
                 +"                                              on (l.arquivoorigem like '%' || e.sigla || '%')                 "
                 +"                                           left join sgr.contrato ct                                          "
                 +"                                              on (e.id_clientecorporativo = ct.id_clientecorporativo          "
                 +"                                                  and e.id_contrato = ct.id_contrato)                         "
                 +"                                             AND ct.titulo not like '%CANCEL%'                                "
                 +"                                           where e.id_estrutura is not null                                   "
                 +"                                              and e.DESCRICAO not like '%CANCEL%'                             "
                 +"                                              and  ct.titulo not like '%CANCEL%'                              "
                 +"                                              AND l.DATA   between sysdate -90 and sysdate                    "
                 +"                                            GROUP BY E.ID_ESTRUTURA )                                         "
    			 +"                    AND ES.DESCRICAO NOT LIKE '%DESATIVA%'                                                    "
                 +"                    AND CT.TITULO NOT LIKE '%CANC%'                                                           "
                 +"                    AND CT.TITULO NOT LIKE '%CACE%'                                                           "
                 +"                    AND CT.TITULO NOT LIKE '%MIGROU_API%'                                                           "
     		     +"                    AND CA.DATA IS NOT NULL                                                                   "
    			 +"                    AND ca.data between SYSDATE - 7 and SYSDATE +0                                            "
    			 +")                                                                                                             "
    			 +"                                                                                                              "
    			 +" SELECT                                                                                                       "
    			 +"    M.ID_ESTRUTURA "
    			 +"   ,M.SIGLA                                                                                                 "
    			 +"   ,M.NM_ESTRUTURA	                                                                                         "
    			 +"   ,M.STATUS_LOG" 
    			 +"   ,M.DATA_CALENDARIO	                                                                                     "
    			 +"   ,M.HORA	                                                                                                 "
    			 +"   ,M.TOTALREGISTROS                                                                                          "
    			 +"   ,M.RN                                                                                                      "
    			 +" FROM MONITORACAO_D1 M                                                                                           "
    			 +"    WHERE RN=1                                                                                                "
    			 +"    AND M.DATA_CALENDARIO between SYSDATE - 7 and SYSDATE +0                                                  "
    			 +" ORDER BY   M.NM_ESTRUTURA, M.ID_ESTRUTURA, M.DATA_CALENDARIO desc, M.TOTALREGISTROS                                          ";
    			                                                                                                                 
        
    	 
    	 
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
    
    

 // Consulta detalhada com parâmetros, incluindo `data` no formato `Date`  -- IZAEL 24/08/2024 --v0001.2
    @Transactional(readOnly = true)
    public Page<LogDashBoardProcessamentosDTO> buscarDetalhamentoPorParametros(Pageable pageable, Long idEstrutura, String data) {
        // Definir o formato da data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataParaConsulta = null;

        try {
            if (data != null && !data.isEmpty()) {
                // Converter a String para Date
                dataParaConsulta = sdf.parse(data);
            }
        } catch (ParseException e) {
            e.printStackTrace(); // Tratar o erro de conversão
        }

        // Definir a data corrente e a data limite (90 dias retroativos)
        Date dataAtual = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataAtual);
        cal.add(Calendar.DAY_OF_YEAR, -90);
        Date dataLimite = cal.getTime();

        // Validação da data
        if (dataParaConsulta == null || dataParaConsulta.after(dataAtual) || dataParaConsulta.before(dataLimite)) {
            dataParaConsulta = dataLimite; // Define uma data padrão para casos inválidos
        }

                
        // 	--  CONSULTA-DEMAIS_MOVIMENTO_DIARIAS_CARGAS_TOTAL_V002.sql                                                                       "
    	 String sql = " SELECT                                                                                                                        "
        		+ "     DISTINCT                                                                                                                  "
        		+ "     rpad(nvl(lo.id_seqlog,0),7,0) as id_seqlog,                                                                               "
        		+ "     'MONITORACAO-DIARIA' AS MONITORACAO,                                                                                      "
        		+ "     ES.ID_ESTRUTURA,                                                                                                          "
        		+ "     ES.SIGLA,                                                                                                                 "
        		+ "     case when LTRIM(es.ID_ESTRUTURA) IN (8590,106539,106540,6788,8648,106528,108885,106533,106538,107468,108872,              "
        		+ "                                           108873,108874,108875,108877,108879,108871,7488,7508)                                "
        		+ "          and es.cargatotal = 'N' THEN                                                                                         "
        		+ "         'FULL'                                                                                                                "
        		+ "      else                                                                                                                     "
        		+ "         decode(es.cargatotal, 'N', 'MVTO', 'FULL')                                                                            "
        		+ "     end TIPO_CARGA,                                                                                                           "
        		+ "     CA.DATA AS DATA_CALENDARIO,                                                                                               "
        		+ "     CASE WHEN TRIM(LO.HORA) IS NULL THEN '00:00:00' ELSE TO_CHAR(LO.HORA, 'HH24:MI:SS') END AS HORA,                          "
        		+ "     TO_CHAR(CASE WHEN TRIM(LO.totalregistros) IS NULL AND TRIM(LO.DATA) IS NULL                                               "
        		+ "	AND TRIM(CA.DATA) < TRUNC(SYSDATE)                                                                                            "
        		+ "                   THEN 'SEM MVTO'                                                                                             "
        		+ "                WHEN TRIM(LO.totalregistros) IS NULL AND TRIM(LO.DATA) IS NULL                                                 "
        		+ "			   AND TRIM(CA.DATA) >= TRUNC(SYSDATE)                                                                                "
        		+ "                   THEN 'PENDENTE' ELSE 'PROCESSADO' END) AS STATUS_LOG,                                                       "
        		+ "     TO_CHAR(CASE WHEN TRIM(LO.totalregistros) IS NULL AND TRIM(LO.DATA) IS NULL                                               "
        		+ "	AND TRIM(CA.DATA) <= TRUNC(SYSDATE)                                                                                           "
        		+ "                   THEN 'SMVTO' WHEN TRIM(LO.totalregistros) IS NULL AND TRIM(LO.DATA) IS NULL                                 "
        		+ "				  AND TRIM(CA.DATA) > TRUNC(SYSDATE)                                                                              "
        		+ "                   THEN 'PNDNT' ELSE TRIM(LO.totalregistros) END) AS totalregistros,                                           "
        		+ "     TO_CHAR(CASE WHEN TRIM(LO.REGCORRETOS) IS NULL AND TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) <= TRUNC(SYSDATE)              "
        		+ "                   THEN 'SMVTO' WHEN TRIM(LO.REGCORRETOS) IS NULL AND TRIM(LO.DATA) IS NULL                                    "
        		+ "				  AND TRIM(CA.DATA) > TRUNC(SYSDATE)                                                                              "
        		+ "                   THEN 'PNDNT' ELSE TRIM(LO.REGCORRETOS) END) AS REGCORRETOS,                                                 "
        		+ "     TO_CHAR(CASE WHEN TRIM(LO.REGINCORRETOS) IS NULL AND TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) <= TRUNC(SYSDATE)            "
        		+ "                   THEN 'SMVTO' WHEN TRIM(LO.REGINCORRETOS) IS NULL AND TRIM(LO.DATA) IS NULL                                  "
        		+ "				  AND TRIM(CA.DATA) > TRUNC(SYSDATE)                                                                              "
        		+ "                   THEN 'PNDNT' ELSE TRIM(LO.REGINCORRETOS) END) AS REGINCORRETOS,                                             "
        		+ "     TO_CHAR(CASE WHEN TRIM(LO.REGENVVENCIDO) IS NULL AND TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) <= TRUNC(SYSDATE)            "
        		+ "                   THEN 'SMVTO' WHEN TRIM(LO.REGENVVENCIDO) IS NULL AND TRIM(LO.DATA) IS NULL                                  "
        		+ "				  AND TRIM(CA.DATA) > TRUNC(SYSDATE)                                                                              "
        		+ "                   THEN 'PNDNT' ELSE TRIM(LO.REGENVVENCIDO) END) AS REGENVVENCIDO,                                             "
        		+ "     case                                                                                                                      "
        		+ "     when TRIM(LO.totalregistros) = 0 OR TRIM(LO.totalregistros) is null then                                                  "
        		+ "         to_char(0, '999G999G999G999G990D00') || '%'                                                                           "
        		+ "      else                                                                                                                     "
        		+ "         concat(to_char(((TO_NUMBER(LO.regcorretos) * 100) / to_number(LO.totalregistros)), '999G999G999G999G990D00'),'%')     "
        		+ "     end PERCENTUAL_CORRETO,                                                                                                   "
        		+ "     case                                                                                                                      "
        		+ "     when TRIM(LO.regincorretos) = 0 or TRIM(LO.regincorretos) is null then                                                    "
        		+ "         to_char(0, '999G999G999G999G990D00') || '%'                                                                           "
        		+ "      else                                                                                                                     "
        		+ "        concat(to_char(((TO_NUMBER(LO.regincorretos) * 100) / to_number(LO.totalregistros)), '999G999G999G999G990D00'),'%')    "
        		+ "     end PERCENTUAL_INCORRETO,                                                                                                 "
        		+ "     case                                                                                                                      "
        		+ "        when TRIM(LO.regenvvencido) = 0 or TRIM(LO.regenvvencido) is null then                                                 "
        		+ "           to_char(0, '999G999G999G999G990D00') || '%'                                                                         "
        		+ "        else                                                                                                                   "
        		+ "           concat(to_char(((TO_NUMBER(LO.regenvvencido) * 100) / to_number(LO.totalregistros)), '999G999G999G999G990D00'),'%') "
        		+ "     end PERCENTUAL_VENCIDOS,                                                                                                  "
        		+ "     case                                                                                                                      "
        		+ "        when trim(LO.regenvinclusao) is null then                                                                              "
        		+ "           lpad('0', '1')                                                                                                      "
        		+ "        else                                                                                                                   "
        		+ "           trim(LO.regenvinclusao)                                                                                             "
        		+ "     end regenvinclusao,                                                                                                       "
        		+ "     case                                                                                                                      "
        		+ "        when trim(LO.regenvalteracao) is null then                                                                             "
        		+ "           lpad('0', '1')                                                                                                      "
        		+ "        else                                                                                                                   "
        		+ "           trim(LO.regenvalteracao)                                                                                            "
        		+ "     end regenvalteracao,                                                                                                      "
        		+ "     case                                                                                                                      "
        		+ "        when trim(LO.regenvcancelamento) is null then                                                                          "
        		+ "           lpad('0', '1')                                                                                                      "
        		+ "        else                                                                                                                   "
        		+ "           trim(LO.regenvcancelamento)                                                                                         "
        		+ "     end regenvcancelamento,                                                                                                   "
        		+ "     case                                                                                                                      "
        		+ "        when trim(LO.regduplicadocarga) is null then                                                                           "
        		+ "           lpad('0', '1')                                                                                                      "
        		+ "        else                                                                                                                   "
        		+ "           trim(LO.regduplicadocarga)                                                                                          "
        		+ "     end regduplicadocarga,                                                                                                    "
        		+ "     UPPER(ES.DESCRICAO) AS NM_ESTRUTURA,                                                                                      "
        		+ "     LTRIM(es.ID_CLIENTECORPORATIVO) ID_CLIENTE,                                                                               "
        		+ "     case                                                                                                                      "
        		+ "        when trim(ct.razaosocialclicorp) is null then                                                                          "
        		+ "           es.DESCRICAO                                                                                                        "
        		+ "        else                                                                                                                   "
        		+ "           ct.razaosocialclicorp                                                                                               "
        		+ "     end NM_CLIENTE,                                                                                                           "
        		+ "     LTRIM(es.ID_CONTRATO) ID_CONTRATO,                                                                                        "
        		+ "     ct.titulo nm_contrato,                                                                                                    "
        		+ "     (CASE eS.id_tipocarteira                                                                                                  "
        		+ "        WHEN 1 THEN                                                                                                            "
        		+ "           'VEÍCULO'                                                                                                           "
        		+ "        WHEN 2 THEN                                                                                                            "
        		+ "           'RESIDENCIA'                                                                                                        "
        		+ "        WHEN 3 THEN                                                                                                            "
        		+ "           'PESSOA'                                                                                                            "
        		+ "        WHEN 4 THEN                                                                                                            "
        		+ "           'FUNERAL'                                                                                                           "
        		+ "        ELSE                                                                                                                   "
        		+ "          'SEI LA'                                                                                                             "
        		+ "     END) SEGMENTO,                                                                                                            "
        		+ "     es.LOCAL_ARQUIVO,                                                                                                         "
        		+ "     TO_CHAR(CA.DATA,'YYYY/MM') AS ANO_MES ,                                                                                   "
                + "     LO.TRATADO_SN"
        		+ " FROM PROCESSAMENTO.CALENDARIO_PRODUCAO CA                                                                                     "
        		+ "     FULL OUTER JOIN sgr.estrutura ES ON                                                                                       "
        		+ "         (ES.ID_ESTRUTURA IS NOT NULL AND ES.DESCRICAO NOT LIKE '%CANCEL%'                                                     "
        		+ "          AND ES.DESCRICAO NOT LIKE '%MIGROU_API%')                                                                             "
        		+ "     LEFT JOIN sgr.logentrada LO ON                                                                                            "
        		+ "         (CA.DATA = LO.DATA AND LO.arquivoorigem LIKE '%' || ES.SIGLA || '%')                                                  "
        		+ "     LEFT JOIN sgr.contrato CT ON                                                                                              "
        		+ "     (ES.id_clientecorporativo = CT.id_clientecorporativo AND ES.id_contrato = CT.id_contrato                                  "
        		+ "      AND CT.titulo NOT LIKE '%CANCEL%' AND CT.titulo NOT LIKE '%MIGROU_API%')                                                 "
        		+ " WHERE ES.ID_ESTRUTURA = ?                                                                                                  "
        		+ " AND CA.DATA BETWEEN ? AND SYSDATE                                                            "
        		+ " ORDER BY     UPPER(ES.DESCRICAO), ES.ID_ESTRUTURA, CA.DATA DESC                                                               ";
        		             		                                                                                                                               
        // Executa a consulta com os parâmetros passados
        List<LogDashBoardProcessamentosDTO> resultList = jdbcTemplate.query(
            sql,
            new Object[]{idEstrutura, dataParaConsulta},
            new BeanPropertyRowMapper<>(LogDashBoardProcessamentosDTO.class)
        );

     
        return new PageImpl<>(resultList, pageable, resultList.size());
    }
   
        
    
}