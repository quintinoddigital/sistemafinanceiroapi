package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.PapelModel;
import br.com.quintino.sistemafinanceiroapi.model.PapelPessoaModel;
import br.com.quintino.sistemafinanceiroapi.repository.PapelImplementationRepository;
import br.com.quintino.sistemafinanceiroapi.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PapelService {

    @Autowired
    private PapelRepository papelRepository;

    @Autowired
    private PapelImplementationRepository papelImplementationRepository;

    public List<PapelModel> findAll() {
        return this.papelRepository.findAll();
    }

    public List<PapelPessoaModel> recuperarPapelPessoa(Long codigoPessoa) {
        System.out.println(this.papelImplementationRepository.recuperarPapelPessoa(codigoPessoa));
        return null;
    }

}
