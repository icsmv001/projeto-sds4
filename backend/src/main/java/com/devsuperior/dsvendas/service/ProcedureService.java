package com.devsuperior.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.ExecutarProcedureCadCobrAutoDTO;
import com.devsuperior.dsvendas.repositories.ProcedureRepository;

import java.util.Map;

@Service
public class ProcedureService {

    @Autowired
    private ProcedureRepository procedureRepository;

    public Map<String, Object> executarProcedure(ExecutarProcedureCadCobrAutoDTO dto) {
        return procedureRepository.executarProcedure(dto);
    }
}