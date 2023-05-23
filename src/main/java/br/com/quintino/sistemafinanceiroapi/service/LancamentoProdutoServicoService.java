package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoProdutoServicoModel;
import br.com.quintino.sistemafinanceiroapi.repository.LancamentoProdutoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoProdutoServicoService {

    @Autowired
    private LancamentoProdutoServicoRepository lancamentoProdutoServicoRepository;

    public List<LancamentoProdutoServicoModel> findAll() {
        return this.lancamentoProdutoServicoRepository.findAll();
    }

    public LancamentoProdutoServicoModel saveOne(LancamentoProdutoServicoModel lancamentoProdutoServicoModel) {
        return this.lancamentoProdutoServicoRepository.saveAndFlush(lancamentoProdutoServicoModel);
    }

    public LancamentoProdutoServicoModel updateOne(Long codigo, LancamentoProdutoServicoModel lancamentoProdutoServicoModel) {
        LancamentoProdutoServicoModel lancamentoProdutoServicoModelSelecionado = this.lancamentoProdutoServicoRepository.findById(codigo).get();
        return this.lancamentoProdutoServicoRepository.saveAndFlush(lancamentoProdutoServicoModelSelecionado);
    }

    public void deleteOne(Long codigo) {
        this.lancamentoProdutoServicoRepository.delete(this.lancamentoProdutoServicoRepository.findById(codigo).get());
    }

}
