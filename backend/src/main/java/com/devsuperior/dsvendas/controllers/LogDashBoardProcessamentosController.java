package com.devsuperior.dsvendas.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.LogDashBoardProcessamentosDTO;
import com.devsuperior.dsvendas.repositories.LogDashBoardProcessamentosRepository;

@RestController
@RequestMapping("/LogDashBoardProcessamentos2")
public class LogDashBoardProcessamentosController {
    private final LogDashBoardProcessamentosRepository LogDashBoardProcessamentosRepository;

    @Autowired
    public LogDashBoardProcessamentosController(LogDashBoardProcessamentosRepository LogDashBoardProcessamentosRepository) {
        this.LogDashBoardProcessamentosRepository = LogDashBoardProcessamentosRepository;
    }

    @GetMapping
    public List<LogDashBoardProcessamentosDTO> listarLogDashBoardProcessamentoss() {
        return LogDashBoardProcessamentosRepository.buscarLogDashBoardProcessamentoss();
    }
    
    
    @GetMapping(value = "/PERIODO2")
    public List<LogDashBoardProcessamentosDTO> buscarLogDashBoardProcessamentosPorData(
            @RequestParam("dataInicio") String dataInicioStr,
            @RequestParam("dataFim") String dataFimStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataInicio = dateFormat.parse(dataInicioStr);
        Date dataFim = dateFormat.parse(dataFimStr);
        return LogDashBoardProcessamentosRepository.buscarLogDashBoardProcessamentosData(dataInicio, dataFim);
    }
    
    @GetMapping(value = "/ID_ESTRUTURA2")
    public List<LogDashBoardProcessamentosDTO> buscarLogDashBoardProcessamentosPorIdEstrura(
            @RequestParam("id_estrutura") String id_estrutura) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       // Date dataInicio = dateFormat.parse(dataInicioStr);
       // Date dataFim = dateFormat.parse(dataFimStr);
        return LogDashBoardProcessamentosRepository.buscarLogDashBoardProcessamentosIdEstrutura(id_estrutura);
    }
    






// fim
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
