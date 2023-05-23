package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.FormaPagamentoModel;
import br.com.quintino.sistemafinanceiroapi.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public List<FormaPagamentoModel> findAll() {
        return this.formaPagamentoRepository.findAll();
    }

    public FormaPagamentoModel saveOne(FormaPagamentoModel formaPagamentoModel) {
        return this.formaPagamentoRepository.saveAndFlush(formaPagamentoModel);
    }

    public FormaPagamentoModel updateOne(Long codigo, FormaPagamentoModel contaBancariaModel) {
        FormaPagamentoModel formaPagamentoModelSelecionada = this.formaPagamentoRepository.findById(codigo).get();
        return this.formaPagamentoRepository.saveAndFlush(formaPagamentoModelSelecionada);
    }

    public void deleteOne(Long codigo) {
        this.formaPagamentoRepository.delete(this.formaPagamentoRepository.findById(codigo).get());
    }



}
