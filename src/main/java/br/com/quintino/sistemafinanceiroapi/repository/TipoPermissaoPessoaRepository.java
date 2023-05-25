package br.com.quintino.sistemafinanceiroapi.repository;

import br.com.quintino.sistemafinanceiroapi.model.TipoPermissaoPessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoPermissaoPessoaRepository extends JpaRepository<TipoPermissaoPessoaModel, Long> { }
