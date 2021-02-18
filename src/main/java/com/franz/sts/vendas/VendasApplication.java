package com.franz.sts.vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan() //outra anotação que mostra à aplicação especificamente os componentes que tem de ser monitorados
// cv pode, p.e. inserir dois pacotes com repository e service e aplicar (basePackages = { "com.franz.sts.vendas.repository",
// "com.franz.sts.vendas.service"}) <--- é um array. Mas por padrão, mesmo sem essa anotação, todos os subpacotes estão monitorados
@RestController
public class VendasApplication {
	
	@Autowired
	@Qualifier("applicationName")
	private String applicationName;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return applicationName;
	}
	
//	@GetMapping("/other")
//	public String otherMapping() {
//		return "Esse é outro GetMapping!";
//	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}

}
