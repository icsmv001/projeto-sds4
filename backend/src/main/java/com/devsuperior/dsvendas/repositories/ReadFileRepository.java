package com.devsuperior.dsvendas.repositories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class ReadFileRepository {
	
	
	public void ReadFile(MultipartFile foto) {
	this.LerArq(null,foto);
	}
	


	public void LerArq(Object arquivo, MultipartFile foto) {
		// TODO Auto-generated method stub
		System.out.println( " 2 ate aqui  ok #####" + foto );
		try {
			 Path path = Paths.get("C:\\tmp\\download\\files\\teste002.txt");

		        List<String> linhasArquivo = Files.readAllLines(path);
		        for (String linha : linhasArquivo) {
		            
		        	 String cpf = linha.substring(0, 11);
		             String nome = linha.substring(11, 33);
		             String agencia = linha.substring(34, 37);
		             String conta = linha.substring(38);
		             System.out.println(" 1CPF....: " + cpf + 
		            		            " 1NOME...: " + nome +
		            		            " 1AGENCIA: " + agencia + 
		            		            " 1CONTA..: " + conta +
		            		            "\n" );
		       
		            
		            
		        }
		
//		        for (String linha : linhasArquivo) {
//		        
//		        System.out.println( "linhas--> " + linha );
//		        }   
		
		
		
		
		
		
		
		}catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de LerArq arquivos");
		}
		
	}
	
		



 
 
 
	
	
 


 }
 
