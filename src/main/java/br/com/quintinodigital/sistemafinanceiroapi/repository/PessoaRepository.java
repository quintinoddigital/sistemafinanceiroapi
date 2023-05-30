package br.com.quintinodigital.sistemafinanceiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinodigital.sistemafinanceiroapi.model.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> { 
	public PessoaModel findPessoaModelByNome(String nome);
}
