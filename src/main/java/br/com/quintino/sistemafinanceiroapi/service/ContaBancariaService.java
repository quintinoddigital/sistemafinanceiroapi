package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ContaBancariaModel;
import br.com.quintino.sistemafinanceiroapi.repository.ContaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaBancariaService {

    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    public List<ContaBancariaModel> findAll() {
        return this.contaBancariaRepository.findAll();
    }

    public ContaBancariaModel saveOne(ContaBancariaModel contaBancariaModel) {
        return this.contaBancariaRepository.saveAndFlush(contaBancariaModel);
    }

    public ContaBancariaModel updateOne(Long codigo, ContaBancariaModel contaBancariaModel) {
        ContaBancariaModel contaBancariaModelModelSelecionada = this.contaBancariaRepository.findById(codigo).get();
        return this.contaBancariaRepository.saveAndFlush(contaBancariaModelModelSelecionada);
    }

    public void deleteOne(Long codigo) {
        this.contaBancariaRepository.delete(this.contaBancariaRepository.findById(codigo).get());
    }



}
