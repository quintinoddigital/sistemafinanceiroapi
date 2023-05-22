package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoModel;
import br.com.quintino.sistemafinanceiroapi.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public List<LancamentoModel> findAll() {
        return this.lancamentoRepository.findAll();
    }

    public LancamentoModel saveOne(LancamentoModel lancamentoModel) {
        return this.lancamentoRepository.saveAndFlush(lancamentoModel);
    }

    public LancamentoModel updateOne(Long codigo, LancamentoModel lancamentoModel) {
        LancamentoModel lancamentoModelSelecionado = this.lancamentoRepository.findById(codigo).get();
        return this.lancamentoRepository.saveAndFlush(lancamentoModelSelecionado);
    }

    public void deleteOne(Long codigo) {
        this.lancamentoRepository.delete(this.lancamentoRepository.findById(codigo).get());
    }



}
