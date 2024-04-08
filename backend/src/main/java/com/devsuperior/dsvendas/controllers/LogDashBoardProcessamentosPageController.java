package com.devsuperior.dsvendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.LogDashBoardProcessamentosDTO;
import com.devsuperior.dsvendas.repositories.LogDashBoardProcessamentosPageRepository;

@RestController
@RequestMapping("/LogDashBoardProcessamentosPage")
public class LogDashBoardProcessamentosPageController {
    private final LogDashBoardProcessamentosPageRepository LogDashBoardProcessamentosPageRepository;

    @Autowired
    public LogDashBoardProcessamentosPageController(LogDashBoardProcessamentosPageRepository LogDashBoardProcessamentosPageRepository) {
        this.LogDashBoardProcessamentosPageRepository = LogDashBoardProcessamentosPageRepository;
    }

        
    @GetMapping
    public Page<LogDashBoardProcessamentosDTO> listarLogDashBoardProcessamentos(@RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return LogDashBoardProcessamentosPageRepository.buscarLogDashBoardProcessamentosPage(pageable);
    }
}

