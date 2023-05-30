package br.com.quintinodigital.sistemafinanceiroapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.quintinodigital.sistemafinanceiroapi.dto.PessoaResponseDTO;
import br.com.quintinodigital.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintinodigital.sistemafinanceiroapi.model.TipoPessoaModel;
import br.com.quintinodigital.sistemafinanceiroapi.repository.PessoaImplementarionRepository;
import br.com.quintinodigital.sistemafinanceiroapi.repository.PessoaRepository;
import br.com.quintinodigital.sistemafinanceiroapi.repository.TipoPessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private PessoaImplementarionRepository pessoaImplementarionRepository;
	
	@Autowired
	private TipoPessoaRepository tipoPessoaRepository;
	
	public PessoaResponseDTO saveOne(PessoaModel pessoaModel) {
		PessoaModel pessoa = pessoaRepository.save(pessoaModel);
		TipoPessoaModel tipoPessoaModel = this.tipoPessoaRepository.findById(pessoa.getTipoPessoaModel().getCodigo()).get();
		return new PessoaResponseDTO(pessoa.getCodigo(), pessoa.getNome(), tipoPessoaModel.getDescricao());
	}
	
	public List<PessoaResponseDTO> findAll() {
		List<PessoaResponseDTO> pessoaResponseDTOList = new ArrayList<>();
		for (PessoaModel pessoaModel : this.pessoaRepository.findAll()) {
			PessoaResponseDTO pessoaResponseDTO = new PessoaResponseDTO();
				pessoaResponseDTO.setCodigo(pessoaModel.getCodigo());
				pessoaResponseDTO.setNome(pessoaModel.getNome());
				pessoaResponseDTO.setTipoPessoa(pessoaModel.getTipoPessoaModel().getDescricao());
				pessoaResponseDTOList.add(pessoaResponseDTO);
		}
		return pessoaResponseDTOList;
	}
	
	public PessoaModel updateOne(Long codigoPessoa, PessoaModel pessoaModel) {
		PessoaModel pessoa = this.pessoaRepository.findById(codigoPessoa).get();
			pessoa.setNome(pessoaModel.getNome());
			pessoa.setTipoPessoaModel(pessoaModel.getTipoPessoaModel());
		return this.pessoaRepository.save(pessoa);
	}
	
	public void deleteOne(Long codigo) {
		this.pessoaRepository.deleteById(codigo);
	}
	
	public List<PessoaResponseDTO> recuperarPessoaNome(String nome) {
		return this.pessoaImplementarionRepository.recuperarPessoaNome(nome);
	}
	
	public PessoaResponseDTO findOne(Long codigoPessoa) {
		List<PessoaModel> pessoaModelList = this.pessoaImplementarionRepository.findOne(codigoPessoa);
		PessoaModel pessoaModel = pessoaModelList.get(0);
		return new PessoaResponseDTO(pessoaModel.getCodigo(), pessoaModel.getNome(), pessoaModel.getTipoPessoaModel().getDescricao());
	}

}
