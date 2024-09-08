package com.devsuperior.dsvendas.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;

import com.devsuperior.dsvendas.dto.ExecutarProcedureCadCobrAutoDTO;

import javax.annotation.PostConstruct;
import java.sql.Types;
import java.util.Map;

@Repository
public class ProcedureRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    private void init() {
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
            .withProcedureName("SPS_CADASTRO_FAT_AUTOMATICO")
            .declareParameters(
                new SqlParameter("PID_COBRANCA", Types.INTEGER),
                new SqlParameter("PDIADATA", Types.INTEGER),
                new SqlParameter("PID_USUARIO", Types.VARCHAR),
                new SqlOutParameter("PMSGRETORNO", Types.VARCHAR) // Ajustado para o nome correto
            );
    }

    public Map<String, Object> executarProcedure(ExecutarProcedureCadCobrAutoDTO dto) {
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("PID_COBRANCA", dto.getIdCobranca())
            .addValue("PDIADATA", dto.getDiaExecucao())
            .addValue("PID_USUARIO", dto.getUsuario());

        return simpleJdbcCall.execute(params);
    }
    
}