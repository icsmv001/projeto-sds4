package com.devsuperior.dsvendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.LogProcessamentosDTO;
import com.devsuperior.dsvendas.repositories.LogProcessamentosPageRepository;

@RestController
@RequestMapping("/LogProcessamentosPage")
public class LogProcessamentosPageController {
    private final LogProcessamentosPageRepository pedidoPageRepository;

    @Autowired
    public LogProcessamentosPageController(LogProcessamentosPageRepository pedidoPageRepository) {
        this.pedidoPageRepository = pedidoPageRepository;
    }

    
    @GetMapping
    public Page<LogProcessamentosDTO> listarLogProcessamentoss(@RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "size", defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return pedidoPageRepository.buscarLogProcessamentossPage(pageable);
    }
}