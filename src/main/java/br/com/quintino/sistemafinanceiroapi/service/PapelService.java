package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.dto.PapelPessoaDTO;
import br.com.quintino.sistemafinanceiroapi.model.PapelModel;
import br.com.quintino.sistemafinanceiroapi.model.PapelPessoaModel;
import br.com.quintino.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintino.sistemafinanceiroapi.repository.PapelImplementationRepository;
import br.com.quintino.sistemafinanceiroapi.repository.PapelRepository;
import br.com.quintino.sistemafinanceiroapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PapelService {

    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PapelImplementationRepository papelImplementationRepository;

    public List<PapelModel> findAll() {
        return this.papelRepository.findAll();
    }

    public PapelPessoaDTO recuperarPapelPessoa(Long codigoPessoa) {
        PessoaModel pessoaModel = this.pessoaRepository.findById(codigoPessoa).get();
        PapelPessoaDTO papelPessoaDTO = new PapelPessoaDTO();
            papelPessoaDTO.setNomePessoa(pessoaModel.getNome());
            for (PapelPessoaModel papelPessoaModel : pessoaModel.getPapelPessoaModelList()) {
                papelPessoaDTO.getPapelModelList().add(papelPessoaModel.getPapelModel());
            }
        return papelPessoaDTO;
    }

}
