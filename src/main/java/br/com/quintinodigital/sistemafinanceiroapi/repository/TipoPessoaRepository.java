package br.com.quintinodigital.sistemafinanceiroapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.quintinodigital.sistemafinanceiroapi.model.TipoPessoaModel;

@Repository
public interface TipoPessoaRepository extends JpaRepository<TipoPessoaModel, Long> { }
