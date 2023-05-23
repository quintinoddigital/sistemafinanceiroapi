package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.ProdutoServicoModel;
import br.com.quintino.sistemafinanceiroapi.service.ProdutoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto-servico")
public class ProdutoServicoController {

    @Autowired
    private ProdutoServicoService produtoServicoService;

    @GetMapping
    public List<ProdutoServicoModel> findAll() {
        return this.produtoServicoService.findAll();
    }

    @PostMapping
    public ProdutoServicoModel saveOne(@RequestBody ProdutoServicoModel produtoServicoModel) {
        return this.produtoServicoService.saveOne(produtoServicoModel);
    }

    @PutMapping("/{codigo}")
    public ProdutoServicoModel updateOne(@PathVariable Long codigo, @RequestBody ProdutoServicoModel produtoServicoModel) {
        return this.produtoServicoService.updateOne(codigo, produtoServicoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.produtoServicoService.deleteOne(codigo);
    }

}
