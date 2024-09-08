package com.devsuperior.dsvendas.controllers;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.ClienteContratoSegmentoDTO;
import com.devsuperior.dsvendas.repositories.ClienteContratoSegmentoRepository;

@RestController
@RequestMapping("/ClienteContratoSegmento")
public class ClienteContratoSegmentoController {

    private final ClienteContratoSegmentoRepository clienteContratoSegmentoRepository;

    @Autowired
    public ClienteContratoSegmentoController(ClienteContratoSegmentoRepository clienteContratoSegmentoRepository) {
        this.clienteContratoSegmentoRepository = clienteContratoSegmentoRepository;
    }

    @GetMapping("/CLIENTES")
    public List<ClienteContratoSegmentoDTO> buscarClienteContratoSegmentoPorCLIENTE(
            @RequestParam("clientes") String clientes) throws ParseException {
        return clienteContratoSegmentoRepository.buscarClienteContratoSegmentoNome(clientes);
    }
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
