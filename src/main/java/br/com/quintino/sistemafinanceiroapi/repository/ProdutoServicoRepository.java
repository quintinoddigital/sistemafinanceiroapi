package br.com.quintino.sistemafinanceiroapi.repository;

import br.com.quintino.sistemafinanceiroapi.model.ProdutoServicoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoServicoRepository extends JpaRepository<ProdutoServicoModel, Long> { }
