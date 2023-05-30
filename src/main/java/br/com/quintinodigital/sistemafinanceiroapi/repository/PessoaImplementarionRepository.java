package br.com.quintinodigital.sistemafinanceiroapi.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.quintinodigital.sistemafinanceiroapi.dto.PessoaResponseDTO;
import br.com.quintinodigital.sistemafinanceiroapi.model.PessoaModel;

@Repository
public class PessoaImplementarionRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<PessoaResponseDTO> recuperarPessoaNome(String nome) {
		StringBuilder sql = new StringBuilder("SELECT pessoaModel ")
				.append("FROM PessoaModel pessoaModel ")
				.append("WHERE UPPER(pessoaModel.nome) LIKE UPPER(:nomeParameter) ");
		Query query = this.entityManager.createQuery(sql.toString());
			query.setParameter("nomeParameter", "%" + nome + "%");
		List<PessoaModel> pessoaModelList = query.getResultList();
		List<PessoaResponseDTO> pessoaResponseDTOList = new ArrayList<>();
		for (PessoaModel pessoaModel : pessoaModelList) {
			PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO(pessoaModel.getCodigo(), pessoaModel.getNome(), pessoaModel.getTipoPessoaModel().getDescricao());
				pessoaResponseDTOList.add(pessoaResponseDTO);
		}
		return pessoaResponseDTOList;
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaModel> findOne(Long codigoPessoa) {
		StringBuilder sql = new StringBuilder("SELECT pessoaModel ")
				.append("FROM PessoaModel pessoaModel ")
				.append("WHERE pessoaModel.codigo = :codigoPessoaParameter ");
		Query query = this.entityManager.createQuery(sql.toString(), PessoaModel.class);
			query.setParameter("codigoPessoaParameter", codigoPessoa);
		return query.getResultList();
	}

}
