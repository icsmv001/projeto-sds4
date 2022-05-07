package com.devsuperior.dsvendas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import com.devsuperior.dsvendas.service.SellerService;

@Controller
@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

	@Autowired
	private SellerService service;
	
	@Autowired
	private SellerRepository sellerRepository;
	// metodo para representar um endpoint e recuper os valores retornados no
	// navegador

	@GetMapping
	public ResponseEntity<Page<SellerDTO>> findAll(Pageable pageable) {
		Page<SellerDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);

	}
	
 
	
	
	
	
	
	
   // consulta por nome simples e com like, usando a convensao containing do jpa repository
	@GetMapping(value = "/vendedorNm/{name}")
	public ResponseEntity<List<SellerDTO>> buscarNomes(@PathVariable String name) {
    	// System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + name);
		List<SellerDTO> list = service.findByNameContaining(name);
		return ResponseEntity.ok(list);
	}
	   
	
	
	// findByAll
	
	 // consulta por nome simples e com like, usando a convensao containing do jpa repository
		@GetMapping(value = "/vendedores")
		public ResponseEntity<List<SellerDTO>> buscarVendedores() {
	    	// System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + name);
			List<SellerDTO> list = service.findByAll();
			return ResponseEntity.ok(list);
		}
		   
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	   // consulta por id simples
		@GetMapping(value = "/vendedorId/{id}")
		public ResponseEntity<Optional<Object>> buscarId(@PathVariable Long id) {
	    	//System.out.println("TESTE ## PASSANDO POR AQUI 1 !!!!! ##### " + id);
			Optional<Object> list = service.findById(id);
			if (list.isPresent()) {
			  return ResponseEntity.ok(list);
			}
			return ResponseEntity.notFound().build();
		}

		
		// metodo para inserir novo registro de vendedor - sucesso - 15/12/2021
		@PostMapping(value = "/vendedor")
		public Seller adicionar(@RequestBody Seller seller) {
			// System.out.println("POST ---> TESTE ## PASSANDO POR AQUI 1 !!!!! ##### ");
		    return sellerRepository.save(seller);
		}
		
	
		
		
		// alteracao de nome por id
		@PutMapping(value = "/AtualizaNome/{id}")
		public ResponseEntity<String> Atualizar(@PathVariable Long id, @RequestBody Seller seller) {
			// System.out.println("TESTE ## PASSANDO POR AQUI alteracao 1 !!!!! ##### " + id);
			if (!sellerRepository.existsById(id)) {
				return ResponseEntity.notFound().build();
			}
			seller.setId(id);
			seller = sellerRepository.save(seller);
			// System.out.println("TESTE ## PASSANDO POR AQUI alteracao 2 !!!!! ##### " +/ id);
			return ResponseEntity.ok(seller.getName());
		}
		
		
		
		
		
		
		
		

}
