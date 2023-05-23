package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.PagamentoModel;
import br.com.quintino.sistemafinanceiroapi.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoModel> findAll() {
        return this.pagamentoRepository.findAll();
    }

    public PagamentoModel saveOne(PagamentoModel pagamentoModel) {
        return this.pagamentoRepository.saveAndFlush(pagamentoModel);
    }

    public PagamentoModel updateOne(Long codigo, PagamentoModel pagamentoModel) {
        PagamentoModel formaPagamentoModelSelecionada = this.pagamentoRepository.findById(codigo).get();
        return this.pagamentoRepository.saveAndFlush(formaPagamentoModelSelecionada);
    }

    public void deleteOne(Long codigo) {
        this.pagamentoRepository.delete(this.pagamentoRepository.findById(codigo).get());
    }



}
