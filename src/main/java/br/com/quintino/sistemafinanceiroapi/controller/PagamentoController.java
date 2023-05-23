package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.PagamentoModel;
import br.com.quintino.sistemafinanceiroapi.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<PagamentoModel> findAll() {
        return this.pagamentoService.findAll();
    }

    @PostMapping
    public PagamentoModel saveOne(@RequestBody PagamentoModel pagamentoModel) {
        return this.pagamentoService.saveOne(pagamentoModel);
    }

    @PutMapping("/{codigo}")
    public PagamentoModel updateOne(@PathVariable Long codigo, @RequestBody PagamentoModel pagamentoModel) {
        return this.pagamentoService.updateOne(codigo, pagamentoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.pagamentoService.deleteOne(codigo);
    }

}
