package br.com.bravi.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.bravi.api.exception.CampoinvalidoException;
import br.com.bravi.api.exception.PessoaInexistenteException;
import br.com.bravi.api.model.Pessoa;
import br.com.bravi.api.repository.PessoaRepository;

@Service
public class PessoaService implements ServiceImplementable<Pessoa>{

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Override
	public List<Pessoa> getAll() {
		List<Pessoa> pessoas = pessoaRepository.findAll();
		return pessoas.size() > 0 ? pessoas : null;
	}

	@Override
	public Pessoa getId(Long id) {
		Pessoa pessoa = pessoaRepository.findOne(id);
		if(pessoa == null) {
			throw new PessoaInexistenteException();
		}
		return pessoa;
	}

	@Override
	public Pessoa create(Pessoa request) {
		if(StringUtils.isEmpty(request.getNome())) {
			throw new CampoinvalidoException();
		}
		return pessoaRepository.save(request);
	}

	@Override
	public Pessoa update(Long id, Pessoa sourceRequest) {
		Pessoa pessoaTarget = getId(id);
		BeanUtils.copyProperties(sourceRequest, pessoaTarget,"codigo","contato");
		pessoaRepository.save(pessoaTarget);
		return pessoaTarget;
	}

	@Override
	public void delete(Long id) {
		Pessoa pessoa = getId(id);
		pessoaRepository.delete(id);		
	}
}
