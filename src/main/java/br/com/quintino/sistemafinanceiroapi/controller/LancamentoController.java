package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoModel;
import br.com.quintino.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintino.sistemafinanceiroapi.service.LancamentoService;
import br.com.quintino.sistemafinanceiroapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamento")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping
    public List<LancamentoModel> findAll() {
        return this.lancamentoService.findAll();
    }

    @PostMapping
    public LancamentoModel saveOne(@RequestBody LancamentoModel lancamentoModel) {
        return this.lancamentoService.saveOne(lancamentoModel);
    }

    @PutMapping("/{codigo}")
    public LancamentoModel updateOne(@PathVariable Long codigo, @RequestBody LancamentoModel lancamentoModel) {
        return this.lancamentoService.updateOne(codigo, lancamentoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.lancamentoService.deleteOne(codigo);
    }

}
