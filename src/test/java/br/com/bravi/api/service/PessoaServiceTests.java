package br.com.bravi.api.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.bravi.api.model.Contato;
import br.com.bravi.api.model.Pessoa;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaServiceTests {
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private Pessoa pessoa;
	
	@Autowired
	private Contato contato;
	
	@Test
	public void createPessaTestOk() {
		
	}	
	@Test
	public void deletePessaTestOk() {
		
	}
	@Test
	public void updatePessaTestOk() {
		
	}

}
