package com.devsuperior.dsvendas.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.ExecutarProcedureCadCobrAutoDTO;
import com.devsuperior.dsvendas.repositories.ProcedureRepository;
import java.util.Map;


@Service
public class ProcedureService2 {

    @Autowired
    private ProcedureRepository procedureRepository;

    public void executarProcedure(ExecutarProcedureCadCobrAutoDTO dto) {
        procedureRepository.executarProcedure(dto);
    }
}












