package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ProdutoServicoModel;
import br.com.quintino.sistemafinanceiroapi.repository.ProdutoServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServicoService {

    @Autowired
    private ProdutoServicoRepository produtoServicoRepository;

    public List<ProdutoServicoModel> findAll() {
        return this.produtoServicoRepository.findAll();
    }

    public ProdutoServicoModel saveOne(ProdutoServicoModel pessoaModel) {
        return this.produtoServicoRepository.saveAndFlush(pessoaModel);
    }

    public ProdutoServicoModel updateOne(Long codigo, ProdutoServicoModel produtoServicoModel) {
        ProdutoServicoModel produtoServicoModelSelecionada = this.produtoServicoRepository.findById(codigo).get();
        return this.produtoServicoRepository.saveAndFlush(produtoServicoModelSelecionada);
    }

    public void deleteOne(Long codigo) {
        this.produtoServicoRepository.delete(this.produtoServicoRepository.findById(codigo).get());
    }



}
