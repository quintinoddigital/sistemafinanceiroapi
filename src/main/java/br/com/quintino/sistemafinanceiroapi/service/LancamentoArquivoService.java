package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ArquivoModel;
import br.com.quintino.sistemafinanceiroapi.model.LancamentoArquivoModel;
import br.com.quintino.sistemafinanceiroapi.model.LancamentoModel;
import br.com.quintino.sistemafinanceiroapi.repository.ArquivoRepository;
import br.com.quintino.sistemafinanceiroapi.repository.LancamentoArquivoRepository;
import br.com.quintino.sistemafinanceiroapi.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoArquivoService {

    @Autowired
    private LancamentoArquivoRepository lancamentoArquivoRepository;

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private ArquivoRepository arquivoRepository;

    public List<LancamentoArquivoModel> findAll() {
        return this.lancamentoArquivoRepository.findAll();
    }

    public LancamentoArquivoModel saveOne(Long codigoLancamento, Long codigoArquivo) {
        LancamentoModel lancamentoModel = this.lancamentoRepository.findById(codigoLancamento).get();
        ArquivoModel arquivoModel = this.arquivoRepository.findById(codigoArquivo).get();
        return this.lancamentoArquivoRepository.saveAndFlush(new LancamentoArquivoModel(lancamentoModel, arquivoModel));
    }

    public LancamentoArquivoModel updateOne(Long codigo, LancamentoArquivoModel lancamentoModel) {
        LancamentoArquivoModel objetoSelecionado = this.lancamentoArquivoRepository.findById(codigo).get();
        return this.lancamentoArquivoRepository.saveAndFlush(objetoSelecionado);
    }

    public void deleteOne(Long codigo) {
        this.lancamentoArquivoRepository.delete(this.lancamentoArquivoRepository.findById(codigo).get());
    }



}
