package com.devsuperior.dsvendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//##@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class DsvendasApplication {
	public static void main(String[] args) {
		SpringApplication.run(DsvendasApplication.class, args);
	}

}
