package com.devsuperior.dsvendas.utils.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.ExecutarProcedureCadCobrAutoDTO;
import com.devsuperior.dsvendas.service.ProcedureService;

import java.util.Map;

@RestController
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;

    @PostMapping("/executarProcedure")
    public String executarProcedure(@RequestBody ExecutarProcedureCadCobrAutoDTO dto) {
        try {
            Map<String, Object> result = procedureService.executarProcedure(dto);
            String msgRetorno = (String) result.get("PMSGRETORNO"); // Ajustado para o nome correto
            return "Procedure executada com sucesso! Mensagem de retorno: " + msgRetorno;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao executar a procedure: " + e.getMessage();
        }
    }
}