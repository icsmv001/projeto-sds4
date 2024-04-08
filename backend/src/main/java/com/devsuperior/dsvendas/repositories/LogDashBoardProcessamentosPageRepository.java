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
    	    String sql = "select 'monitoracao v.2' as monitoracao,                         "
        		+"       ES.ID_ESTRUTURA,                                                          "
        		+"       ES.SIGLA,                                                                 "
        		+"       case                                                                      "
        		+"         when LTRIM(ES.ID_ESTRUTURA) IN (8590,                                   "
        		+"                                         106539,                                 "
        		+"                                         106540,                                 "
        		+"                                         6788,                                   "
        		+"                                         8648,                                   "
        		+"                                         106528,                                 "
        		+"                                         108885,                                 "
        		+"                                         106533,                                 "
        		+"                                         106538,                                 "
        		+"                                         107468,                                 "
        		+"                                         108872,                                 "
        		+"                                         108873,                                 "
        		+"                                         108874,                                 "
        		+"                                         108875,                                 "
        		+"                                         108877,                                 "
        		+"                                         108879,                                 "
        		+"                                         108871,                                 "
        		+"                                         7488,                                   "
        		+"                                         7508) and ES.cargatotal = 'N' THEN      "
        		+"          'FULL'                                                                 "
        		+"         else                                                                    "
        		+"          decode(ES.cargatotal, 'N', 'MVTO', 'FULL')                             "
        		+"       end TIPO_CARGA,                                                           "
        		+"       CA.DATA as DATA_CALENDARIO,                                               "
        		+"       CASE                                                                      "
        		+"         WHEN TRIM(LO.HORA) IS NULL THEN                                         "
        		+"          ('00:00:00 ')                                                          "
        		+"         ELSE                                                                    "
        		+"          TO_CHAR(LO.HORA, 'HH24:MI:SS')                                         "
        		+"       END HORA,                                                                 "
        		+"       NVL(TRIM(LO.ID_SEQLOG), 0) ID_SEQLOG,                                     "
        		+"       CASE                                                                      "
        		+"         WHEN TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) <= TRUNC(SYSDATE) THEN     "
        		+"          ('SEM_MOVTOS')                                                         "
        		+"         WHEN TRIM(LO.DATA) IS NULL AND TRIM(CA.DATA) > TRUNC(SYSDATE) THEN      "
        		+"          ('PENDENTES ')                                                         "
        		+"         ELSE                                                                    "
        		+"          ('PROCESSADO')                                                         "
        		+"       END STATUS_LOG,                                                           "
        		+"       case                                                                      "
        		+"         when trim(LO.totalregistros) is null then                               "
        		+"          lpad('0', '1')                                                         "
        		+"         else                                                                    "
        		+"          trim(LO.totalregistros)                                                "
        		+"       end totalregistros,                                                       "
        		+"       case                                                                      "
        		+"         when trim(LO.regcorretos) is null then                                  "
        		+"          lpad('0', '1')                                                         "
        		+"         else                                                                    "
        		+"          trim(LO.regcorretos)                                                   "
        		+"       end regcorretos,                                                          "
        		+"       case                                                                      "
        		+"         when trim(LO.regincorretos) is null then                                "
        		+"          lpad('0', '1')                                                         "
        		+"         else                                                                    "
        		+"          trim(LO.regincorretos)                                                 "
        		+"       end regincorretos,                                                        "
        		+"       case                                                                      "
        		+"         when trim(LO.regenvvencido) is null then                                "
        		+"          lpad('0', '1')                                                         "
        		+"         else                                                                    "
        		+"          trim(LO.regenvvencido)                                                 "
        		+"       end regenvvencido,                                                        "
        		+"       case                                                                      "
        		+"         when TRIM(LO.totalregistros) = 0 OR TRIM(LO.totalregistros) is null then"
        		+"          to_char(0, '999G999G999G999G990D00') || '%'                            "
        		+"         else                                                                    "
        		+"          concat(to_char(((TO_NUMBER(lO.regcorretos) * 100) /                    "
        		+"                         to_number(LO.totalregistros)),                          "
        		+"                         '999G999G999G999G990D00'),                              "
        		+"                 '%')                                                            "
        		+"       end PERCENTUAL_CORRETO,                                                   "
        		+"       case                                                                      "
        		+"         when TRIM(LO.regincorretos) = 0 or TRIM(LO.regincorretos) is null then  "
        		+"          to_char(0, '999G999G999G999G990D00') || '%'                            "
        		+"         else                                                                    "
        		+"          concat(to_char(((TO_NUMBER(LO.regincorretos) * 100) /                  "
        		+"                         to_number(LO.totalregistros)),                          "
        		+"                         '999G999G999G999G990D00'),                              "
        		+"                 '%')                                                            "
        		+"       end PERCENTUAL_INCORRETO,                                                 "
        		+"       case                                                                      "
        		+"         when TRIM(LO.regenvvencido) = 0 or TRIM(LO.regenvvencido) is null then  "
        		+"          to_char(0, '999G999G999G999G990D00') || '%'                            "
        		+"         else                                                                    "
        		+"          concat(to_char(((TO_NUMBER(LO.regenvvencido) * 100) /                  "
        		+"                         to_number(LO.totalregistros)),                          "
        		+"                         '999G999G999G999G990D00'),                              "
        		+"                 '%')                                                            "
        		+"       end PERCENTUAL_VENCIDOS,                                                  "
        		+"       case                                                                      "
        		+"         when trim(LO.REGENVINCLUSAO) is null then                               "
        		+"          lpad('0', '1')                                                         "
        		+"         else                                                                    "
        		+"          trim(LO.REGENVINCLUSAO)                                                "
        		+"       end REGENVINCLUSAO,                                                       "
        		+"       case                                                                      "
        		+"         when trim(LO.REGENVALTERACAO) is null then                              "
        		+"          lpad('0', '1')                                                         "
        		+"         else                                                                    "
        		+"          trim(LO.REGENVALTERACAO)                                               "
        		+"       end REGENVALTERACAO,                                                      "
        		+"       case                                                                      "
        		+"         when trim(LO.REGENVCANCELAMENTO) is null then                           "
        		+"          lpad('0', '1')                                                         "
        		+"         else                                                                    "
        		+"          trim(LO.REGENVCANCELAMENTO)                                            "
        		+"       end REGENVCANCELAMENTO,                                                   "
        		+"       ES.DESCRICAO NM_ESTRUTURA,                                                "
        		+"       ES.ID_CLIENTECORPORATIVO AS ID_CLIENTE,                                   "
        		+"       case                                                                      "
        		+"         when trim(ct.razaosocialclicorp) is null then                           "
        		+"          ES.DESCRICAO                                                           "
        		+"         else                                                                    "
        		+"          ct.razaosocialclicorp                                                  "
        		+"       end NM_CLIENTE,                                                           "
        		+"       ES.ID_CONTRATO,                                                           "
        		+"       ct.titulo NM_contrato,                                                    "
        		+"       (CASE ES.id_tipocarteira                                                  "
        		+"         WHEN 1 THEN                                                             "
        		+"          'VEÍCULO'                                                              "
        		+"         WHEN 2 THEN                                                             "
        		+"          'RESIDENCIA'                                                           "
        		+"         WHEN 3 THEN                                                             "
        		+"          'PESSOA'                                                               "
        		+"         WHEN 4 THEN                                                             "
        		+"          'FUNERAL'                                                              "
        		+"         ELSE                                                                    "
        		+"          'SEI LA'                                                               "
        		+"       END) SEGMENTO,                                                            "
        		+"       ES.LOCAL_ARQUIVO,                                                         "
        		+"       TO_CHAR(CA.DATA, 'YYYY/MM') ANO_MES                                       "
        		+"  from PROCESSAMENTO.CALENDARIO_PRODUCAO CA                                      "
        		+"  full outer join sgr.estrutura ES                                               "
        		+"    ON (ES.ID_ESTRUTURA IS NOT NULL AND ES.ID_ESTRUTURA IS NOT NULL AND          "
        		+"       ES.DESCRICAO NOT LIKE '%CANCEL%' AND                                      "
        		+"       ES.DESCRICAO NOT LIKE '%CANCEL%')                                         "
        		+"  left join sgr.logentrada LO                                                    "
        		+"    ON (CA.DATA = LO.DATA AND                                                    "
        		+"       (LO.arquivoorigem like '%' || ES.SIGLA || '%'))                           "
        		+"  left join sgr.contrato CT                                                      "
        		+"    ON (ES.id_clientecorporativo = ct.id_clientecorporativo and                  "
        		+"       ES.id_contrato = ct.id_contrato and ct.titulo not like '%CANCEL%')        "
        		+" WHERE 0 = 0    "
        		+"   AND ES.ID_ESTRUTURA IN (10978, 10827)                                         "
        		+ "  AND CA.DATA IS NOT NULL                                                        "
        		+" ORDER BY ES.ID_ESTRUTURA, CA.DATA DESC , lo.id_seqlog asc";
    	   
        
    	    // Executa a consulta com paginação
            List<LogDashBoardProcessamentosDTO> resultList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LogDashBoardProcessamentosDTO.class));

            // Calcula o índice inicial e final da página
            int start = (int) pageable.getOffset();
            int end = Math.min((start + pageable.getPageSize()), resultList.size());

            // Cria uma sublista dos resultados correspondentes à página atual
            List<LogDashBoardProcessamentosDTO> pageList = resultList.subList(start, end);

            // Retorna uma instância de Page contendo os resultados da página atual
            return new PageImpl<>(pageList, pageable, resultList.size());
     
    }
}