package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ParcelamentoModel;
import br.com.quintino.sistemafinanceiroapi.repository.ParcelamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelamentoService {

    @Autowired
    private ParcelamentoRepository parcelamentoRepository;

    public List<ParcelamentoModel> findAll() {
        return this.parcelamentoRepository.findAll();
    }

    public ParcelamentoModel saveOne(ParcelamentoModel parcelamentoModel) {
        return this.parcelamentoRepository.saveAndFlush(parcelamentoModel);
    }

    public ParcelamentoModel updateOne(Long codigo, ParcelamentoModel parcelamentoModel) {
        ParcelamentoModel parcelamentoModelSelecionado = this.parcelamentoRepository.findById(codigo).get();
        return this.parcelamentoRepository.saveAndFlush(parcelamentoModelSelecionado);
    }

    public void deleteOne(Long codigo) {
        this.parcelamentoRepository.delete(this.parcelamentoRepository.findById(codigo).get());
    }



}
