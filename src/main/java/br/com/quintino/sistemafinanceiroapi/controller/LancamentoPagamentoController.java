package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.LancamentoPagamentoModel;
import br.com.quintino.sistemafinanceiroapi.service.LancamentoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamento-pagamento")
public class LancamentoPagamentoController {

    @Autowired
    private LancamentoPagamentoService lancamentoPagamentoService;

    @GetMapping
    public List<LancamentoPagamentoModel> findAll() {
        return this.lancamentoPagamentoService.findAll();
    }

    @PostMapping
    public LancamentoPagamentoModel saveOne(@RequestBody LancamentoPagamentoModel lancamentoPagamentoModel) {
        return this.lancamentoPagamentoService.saveOne(lancamentoPagamentoModel);
    }

    @PutMapping("/{codigo}")
    public LancamentoPagamentoModel updateOne(@PathVariable Long codigo, @RequestBody LancamentoPagamentoModel lancamentoPagamentoModel) {
        return this.lancamentoPagamentoService.updateOne(codigo, lancamentoPagamentoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.lancamentoPagamentoService.deleteOne(codigo);
    }

}
