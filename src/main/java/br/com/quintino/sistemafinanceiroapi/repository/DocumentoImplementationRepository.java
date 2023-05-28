package br.com.quintino.sistemafinanceiroapi.repository;

import br.com.quintino.sistemafinanceiroapi.model.DocumentoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentoImplementationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // FIXME -- Finalizar Consulta
    public List<DocumentoModel> recuperarDocumentoPessoa(Long codigoPessoa) {
        StringBuilder sql = new StringBuilder("SELECT documentoModel ")
                .append("FROM DocumentoModel documentoModel ")
                .append("WHERE documentoModel.pessoaModel.codigo = : codigoPessoaParameter ");
        return null;
    }

}
