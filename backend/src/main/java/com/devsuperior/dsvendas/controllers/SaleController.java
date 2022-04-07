package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private SaleService service;

	// metodo para representar um endpoint e recuper os valores retornados no
	// navegador

	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);

	}

	
	// findByAll  em Salecontrole
	
		 // consulta lista de vendas sem paginacao
			@GetMapping(value = "/vendas")
			public ResponseEntity<List<SaleDTO>> buscarVendas() {
		    	// System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " );
				List<SaleDTO> list = service.findByAll();
				return ResponseEntity.ok(list);
			}
			   
	
	
	
	
	// endpoint para recuperar valor agrupado por vendedor
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupBySeller() {
		List<SaleSumDTO> list = service.amountGroupBySeller();
		return ResponseEntity.ok(list);

	}

	// endpoint para recuperar valor agrupado por vendedor
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupBySeller() {
		List<SaleSuccessDTO> list = service.successGroupBySeller();
		return ResponseEntity.ok(list);

	}

	// metodo para inserir novo registro de venda por vendedor - ok
	@PostMapping(value = "/vendaNova")

	public ResponseEntity<Sale> adicionar(@RequestBody Sale sale) {
		//System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### ");

		Sale listar = saleRepository.save(sale);

		return ResponseEntity.ok(listar);
	}

}
