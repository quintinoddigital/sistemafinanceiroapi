package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ContaBancariaModel;
import br.com.quintino.sistemafinanceiroapi.model.FormaPagamentoModel;
import br.com.quintino.sistemafinanceiroapi.model.PagamentoModel;
import br.com.quintino.sistemafinanceiroapi.repository.ContaBancariaRepository;
import br.com.quintino.sistemafinanceiroapi.repository.FormaPagamentoRepository;
import br.com.quintino.sistemafinanceiroapi.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public List<PagamentoModel> findAll() {
        return this.pagamentoRepository.findAll();
    }

    public PagamentoModel saveOne(PagamentoModel pagamentoModel) {
        pagamentoModel.setContaBancariaModel(this.configurarContaBancaria(pagamentoModel.getContaBancariaModel().getCodigo()));
        pagamentoModel.setFormaPagamentoModel(this.configurarFormaPagamento(pagamentoModel.getFormaPagamentoModel().getCodigo()));
        return this.pagamentoRepository.saveAndFlush(pagamentoModel);
    }

    public PagamentoModel updateOne(Long codigo, PagamentoModel pagamentoModel) {
        PagamentoModel formaPagamentoModelSelecionada = this.pagamentoRepository.findById(codigo).get();
        return this.pagamentoRepository.saveAndFlush(formaPagamentoModelSelecionada);
    }

    public void deleteOne(Long codigo) {
        this.pagamentoRepository.delete(this.pagamentoRepository.findById(codigo).get());
    }

    private ContaBancariaModel configurarContaBancaria(Long codigoContaBancaria) {
        return this.contaBancariaRepository.findById(codigoContaBancaria).get();
    }

    private FormaPagamentoModel configurarFormaPagamento(Long codigoFormaPagamento) {
        return this.formaPagamentoRepository.findById(codigoFormaPagamento).get();
    }

}
