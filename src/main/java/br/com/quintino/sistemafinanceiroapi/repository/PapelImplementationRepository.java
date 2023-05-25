package br.com.quintino.sistemafinanceiroapi.repository;

import br.com.quintino.sistemafinanceiroapi.model.PapelPessoaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PapelImplementationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // TODO -- REFATORAR CODIGO- CONVERTER PARA JPQL
    public List<PapelPessoaModel> recuperarPapelPessoa(Long codigoPessoa) {
        StringBuilder sql = new StringBuilder("SELECT PAPEL, PESSOA ")
            .append("FROM TB_PAPEL_PESSOA PAPEL_PESSOA ")
            .append("JOIN TB_PESSOA PESSOA ON PESSOA.CODIGO = PAPEL_PESSOA.ID_PESSOA ")
            .append("JOIN TB_PAPEL PAPEL ON PAPEL.CODIGO = PAPEL_PESSOA.ID_PAPEL ")
            .append("WHERE PESSOA.CODIGO = :codigoPessoaParameter ");
        Query query = this.entityManager.createQuery(sql.toString(), PapelPessoaModel.class);
            query.setParameter("codigoPessoaParameter", codigoPessoa);
        return query.getResultList();
    }

}
