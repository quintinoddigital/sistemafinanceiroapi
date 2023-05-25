package br.com.quintino.sistemafinanceiroapi;

import br.com.quintino.sistemafinanceiroapi.repository.PapelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTest {

	@Autowired
	private PapelRepository papelRepository;

	@Test
	void contextLoads() {

	}

}
