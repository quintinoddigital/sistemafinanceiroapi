package br.com.quintino.sistemafinanceiroapi.repository;

import br.com.quintino.sistemafinanceiroapi.dto.PapelPessoaDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PapelImplementationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // TODO -- REFATORAR CODIGO
    public List<String> recuperarPapelPessoa(Long codigoPessoa) {
        StringBuilder sql = new StringBuilder("SELECT PESSOA.NOME, PAPEL.NOME ")
            .append("FROM TB_PAPEL_PESSOA PAPEL_PESSOA ")
            .append("JOIN TB_PESSOA PESSOA ON PESSOA.CODIGO = PAPEL_PESSOA.ID_PESSOA ")
            .append("JOIN TB_PAPEL PAPEL ON PAPEL.CODIGO = PAPEL_PESSOA.ID_PAPEL ")
            .append("WHERE PESSOA.CODIGO = :codigoPessoaParameter ");
        Query query = this.entityManager.createQuery(sql.toString(), String.class);
            query.setParameter("codigoPessoaParameter", codigoPessoa);
        return query.getResultList();
    }

}
