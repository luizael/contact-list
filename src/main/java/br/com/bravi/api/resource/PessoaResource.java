package br.com.bravi.api.resource;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.bravi.api.exception.CampoinvalidoException;
import br.com.bravi.api.exception.PessoaInexistenteException;
import br.com.bravi.api.model.Pessoa;
import br.com.bravi.api.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource implements ResourceImplementable<Pessoa>{

	@Autowired
	private PessoaService pessoaService;
	
	@Override
	@GetMapping
	public List<Pessoa> getAll() {
		return pessoaService.getAll();
	}	
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> getId(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.getId(id);
		return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
	}

	@Override
	@PostMapping
	public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa request, HttpServletResponse response) {
		Pessoa pessoa = pessoaService.create(request);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getCodigo()).toUri();
		return pessoa != null ? ResponseEntity.created(uri).body(pessoa) : ResponseEntity.notFound().build();
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id,@Valid @RequestBody Pessoa request) {
		Pessoa pessoa = pessoaService.update(id, request);
		return pessoa != null ? ResponseEntity.status(HttpStatus.CREATED).body(pessoa) : ResponseEntity.notFound().build();
	}

	@Override
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		pessoaService.delete(id);
		ResponseEntity.noContent().build();
	}	
	
	@ExceptionHandler({PessoaInexistenteException.class})
	public ResponseEntity<Object> handlerPessoainexistenteExceptin(PessoaInexistenteException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Conta inexistente");
	}
	
	@ExceptionHandler({CampoinvalidoException.class})
	public ResponseEntity<Object> handlerCampoinvalidoExceptin(CampoinvalidoException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Arrays.asList("campo inválido",LocaleContextHolder.getLocale()));
	}

}
