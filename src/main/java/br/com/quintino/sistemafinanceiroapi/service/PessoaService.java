package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintino.sistemafinanceiroapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> findAll() {
        return this.pessoaRepository.findAll();
    }

    public PessoaModel saveOne(PessoaModel pessoaModel) {
        return this.pessoaRepository.saveAndFlush(pessoaModel);
    }

    public PessoaModel updateOne(Long codigo, PessoaModel pessoaModel) {
        PessoaModel pessoaModelSelecionada = this.pessoaRepository.findById(codigo).get();
            pessoaModelSelecionada.setTipoPessoaModel(pessoaModel.getTipoPessoaModel());
            pessoaModelSelecionada.setNome(pessoaModel.getNome());
        return this.pessoaRepository.saveAndFlush(pessoaModelSelecionada);
    }

    public void deleteOne(Long codigo) {
        this.pessoaRepository.delete(this.pessoaRepository.findById(codigo).get());
    }



}
