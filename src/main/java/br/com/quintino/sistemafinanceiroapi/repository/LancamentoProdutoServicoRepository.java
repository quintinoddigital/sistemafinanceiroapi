package br.com.quintino.sistemafinanceiroapi.repository;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoProdutoServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoProdutoServicoRepository extends JpaRepository<LancamentoProdutoServicoModel, Long> { }
