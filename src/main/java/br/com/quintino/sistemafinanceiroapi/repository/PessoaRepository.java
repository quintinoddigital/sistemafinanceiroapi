package br.com.quintino.sistemafinanceiroapi.repository;

import br.com.quintino.sistemafinanceiroapi.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> { }
