package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoModel;
import br.com.quintino.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintino.sistemafinanceiroapi.repository.LancamentoRepository;
import br.com.quintino.sistemafinanceiroapi.repository.PessoaRepository;
import br.com.quintino.sistemafinanceiroapi.utility.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<LancamentoModel> findAll() {
        return this.lancamentoRepository.findAll();
    }

    public LancamentoModel saveOne(LancamentoModel lancamentoModel) {
        lancamentoModel.setPessoaFavorecida(this.configurarPessoa(lancamentoModel.getPessoaFavorecida()));
        lancamentoModel.setPessoaResponsavelLancamento(this.configurarPessoa(lancamentoModel.getPessoaResponsavelLancamento()));
        lancamentoModel.setIdentificador(this.configurarIdentificador());
        return this.lancamentoRepository.saveAndFlush(lancamentoModel);
    }

    public LancamentoModel updateOne(Long codigo, LancamentoModel lancamentoModel) {
        LancamentoModel lancamentoModelSelecionado = this.lancamentoRepository.findById(codigo).get();
        return this.lancamentoRepository.saveAndFlush(lancamentoModelSelecionado);
    }

    public void deleteOne(Long codigo) {
        this.lancamentoRepository.delete(this.lancamentoRepository.findById(codigo).get());
    }

    private PessoaModel configurarPessoa(PessoaModel pessoaModel) {
        return this.pessoaRepository.findById(pessoaModel.getCodigo()).get();
    }

    private String configurarIdentificador() {
        return "LANCAMENTOFINANCEIRO" + DateUtility.gerarNumeroDemanda();
    }

}
