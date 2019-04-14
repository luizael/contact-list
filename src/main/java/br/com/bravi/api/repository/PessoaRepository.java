package br.com.bravi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bravi.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
