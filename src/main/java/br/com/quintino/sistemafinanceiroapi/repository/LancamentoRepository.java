package br.com.quintino.sistemafinanceiroapi.repository;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoModel, Long> { }
