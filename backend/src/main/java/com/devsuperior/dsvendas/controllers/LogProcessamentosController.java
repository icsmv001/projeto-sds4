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

import com.devsuperior.dsvendas.dto.LogProcessamentosDTO;
import com.devsuperior.dsvendas.repositories.LogProcessamentosRepository;

@RestController
@RequestMapping("/LOGPROCESSAMENTOS")
public class LogProcessamentosController {
    private final LogProcessamentosRepository LogProcessamentosRepository;

    @Autowired
    public LogProcessamentosController(LogProcessamentosRepository LogProcessamentosRepository) {
        this.LogProcessamentosRepository = LogProcessamentosRepository;
    }

    @GetMapping
    public List<LogProcessamentosDTO> listarLogProcessamentoss() {
        return LogProcessamentosRepository.buscarLogProcessamentoss();
    }
    
    
    @GetMapping(value = "/PERIODO")
    public List<LogProcessamentosDTO> buscarLogProcessamentosPorData(
            @RequestParam("dataInicio") String dataInicioStr,
            @RequestParam("dataFim") String dataFimStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataInicio = dateFormat.parse(dataInicioStr);
        Date dataFim = dateFormat.parse(dataFimStr);
        return LogProcessamentosRepository.buscarLogProcessamentosData(dataInicio, dataFim);
    }
    
    @GetMapping(value = "/ID_ESTRUTURA")
    public List<LogProcessamentosDTO> buscarLogProcessamentosPorIdEstrura(
            @RequestParam("id_estrutura") String id_estrutura) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
       // Date dataInicio = dateFormat.parse(dataInicioStr);
       // Date dataFim = dateFormat.parse(dataFimStr);
        return LogProcessamentosRepository.buscarLogProcessamentosIdEstrutura(id_estrutura);
    }
    






// fim
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
