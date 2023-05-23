package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoArquivoModel;
import br.com.quintino.sistemafinanceiroapi.repository.LancamentoArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoArquivoService {

    @Autowired
    private LancamentoArquivoRepository lancamentoArquivoRepository;

    public List<LancamentoArquivoModel> findAll() {
        return this.lancamentoArquivoRepository.findAll();
    }

    public LancamentoArquivoModel saveOne(LancamentoArquivoModel lancamentoModel) {
        return this.lancamentoArquivoRepository.saveAndFlush(lancamentoModel);
    }

    public LancamentoArquivoModel updateOne(Long codigo, LancamentoArquivoModel lancamentoModel) {
        LancamentoArquivoModel objetoSelecionado = this.lancamentoArquivoRepository.findById(codigo).get();
        return this.lancamentoArquivoRepository.saveAndFlush(objetoSelecionado);
    }

    public void deleteOne(Long codigo) {
        this.lancamentoArquivoRepository.delete(this.lancamentoArquivoRepository.findById(codigo).get());
    }



}
