package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoArquivoModel;
import br.com.quintino.sistemafinanceiroapi.service.LancamentoArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamento-arquivo")
public class LancamentoArquivoController {

    @Autowired
    private LancamentoArquivoService lancamentoArquivoService;

    @GetMapping
    public List<LancamentoArquivoModel> findAll() {
        return this.lancamentoArquivoService.findAll();
    }

    @PostMapping
    public LancamentoArquivoModel saveOne(@RequestBody LancamentoArquivoModel lancamentoPagamentoModel) {
        return this.lancamentoArquivoService.saveOne(lancamentoPagamentoModel);
    }

    @PutMapping("/{codigo}")
    public LancamentoArquivoModel updateOne(@PathVariable Long codigo, @RequestBody LancamentoArquivoModel lancamentoPagamentoModel) {
        return this.lancamentoArquivoService.updateOne(codigo, lancamentoPagamentoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.lancamentoArquivoService.deleteOne(codigo);
    }

}
