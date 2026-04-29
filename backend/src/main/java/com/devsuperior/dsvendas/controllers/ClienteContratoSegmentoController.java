package com.devsuperior.dsvendas.controllers;

import java.text.ParseException;
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

    // -------------------------------
    // BUSCAR POR NOME DO CLIENTE E NOME DO CONTRATO
    // -------------------------------
    @GetMapping("/CLIENTES")
    public List<ClienteContratoSegmentoDTO> buscarClienteContratoSegmentoPorCLIENTE(
            @RequestParam("clientes") String clientes) throws ParseException {

        return clienteContratoSegmentoRepository.buscarPorNome(clientes);
    }
        
    @GetMapping("/CONTRATOS")
    public List<ClienteContratoSegmentoDTO> buscarClienteContratoSegmentoPorCONTRATO(
            @RequestParam("contratos") String contratos) throws ParseException {

        return clienteContratoSegmentoRepository.buscarPorNomeContrato(contratos);
    }
    
     
    // -------------------------------
    // BUSCAR POR ID DO CLIENTE E DO CONTRATO
    // -------------------------------
    @GetMapping("/ID_CONTRATO")
    public List<ClienteContratoSegmentoDTO> buscarClienteContratoSegmentoPorID_CONTRATO(
            @RequestParam("id_contrato") Long id_contrato) throws ParseException {

        return clienteContratoSegmentoRepository.buscarPorIdContrato(id_contrato);
    }
    
    
    @GetMapping("/ID_CLIENTE")
    public List<ClienteContratoSegmentoDTO> buscarClienteContratoSegmentoPorID_CLIENTE(
            @RequestParam("id_cliente") Long id_cliente) throws ParseException {

        return clienteContratoSegmentoRepository.buscarPorIdCliente(id_cliente);
    }
    
    
    
    
    
}




