package com.devsuperior.dsvendas.repositories;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class ReadFileRepository2 {
	public void ReadFile2(MultipartFile foto) {
	this.LerArq2(foto);
	}
	
	public void LerArq2(MultipartFile foto) {
		//System.out.println( " 3 ate aqui  ok !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ######################" );
		 Scanner sc;
		try {
			int tot_line =0;
			sc = new Scanner(foto.getInputStream());
		  while (sc.hasNext()) {
			 tot_line = tot_line +1;
	            System.out.print(sc.nextLine());
	            System.out.println( " leitura de arquivo txt, realizado com sucesso, total de linhas--> " + tot_line );
	        }
	        sc.close();
	      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			/// e.printStackTrace();
			throw new RuntimeException("Problemas na tentativa de Ler Arq arquivos");
		}
	      
		
}}




 
