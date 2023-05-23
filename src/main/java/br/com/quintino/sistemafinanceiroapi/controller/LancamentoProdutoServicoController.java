package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoProdutoServicoModel;
import br.com.quintino.sistemafinanceiroapi.service.LancamentoProdutoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamento-produto-servico")
public class LancamentoProdutoServicoController {

    @Autowired
    private LancamentoProdutoServicoService lancamentoProdutoServicoService;

    @GetMapping
    public List<LancamentoProdutoServicoModel> findAll() {
        return this.lancamentoProdutoServicoService.findAll();
    }

    @PostMapping
    public LancamentoProdutoServicoModel saveOne(@RequestBody LancamentoProdutoServicoModel lancamentoProdutoServicoModel) {
        return this.lancamentoProdutoServicoService.saveOne(lancamentoProdutoServicoModel);
    }

    @PutMapping("/{codigo}")
    public LancamentoProdutoServicoModel updateOne(@PathVariable Long codigo, @RequestBody LancamentoProdutoServicoModel lancamentoProdutoServicoModel) {
        return this.lancamentoProdutoServicoService.updateOne(codigo, lancamentoProdutoServicoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.lancamentoProdutoServicoService.deleteOne(codigo);
    }

}
