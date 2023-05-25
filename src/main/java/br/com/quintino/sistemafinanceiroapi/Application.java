package br.com.quintino.sistemafinanceiroapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@GetMapping
	public String application() {
		return "Sistema Financeiro (API)";
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("A API do Sistema Financeiro está em Execução (Versão 1.0.0)");
	}

}
