package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoPagamentoModel;
import br.com.quintino.sistemafinanceiroapi.repository.LancamentoPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoPagamentoService {

    @Autowired
    private LancamentoPagamentoRepository lancamentoPagamentoRepository;

    public List<LancamentoPagamentoModel> findAll() {
        return this.lancamentoPagamentoRepository.findAll();
    }

    public LancamentoPagamentoModel saveOne(LancamentoPagamentoModel lancamentoPagamentoModel) {
        return this.lancamentoPagamentoRepository.saveAndFlush(lancamentoPagamentoModel);
    }

    public LancamentoPagamentoModel updateOne(Long codigo, LancamentoPagamentoModel lancamentoPagamentoModel) {
        LancamentoPagamentoModel lancamentoPagamentoModelSelecionado = this.lancamentoPagamentoRepository.findById(codigo).get();
        return this.lancamentoPagamentoRepository.saveAndFlush(lancamentoPagamentoModelSelecionado);
    }

    public void deleteOne(Long codigo) {
        this.lancamentoPagamentoRepository.delete(this.lancamentoPagamentoRepository.findById(codigo).get());
    }



}
