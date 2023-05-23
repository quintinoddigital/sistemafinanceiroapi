package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.FormaPagamentoModel;
import br.com.quintino.sistemafinanceiroapi.service.FormaPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forma-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoService formaPagamentoService;

    @GetMapping
    public List<FormaPagamentoModel> findAll() {
        return this.formaPagamentoService.findAll();
    }

    @PostMapping
    public FormaPagamentoModel saveOne(@RequestBody FormaPagamentoModel formaPagamentoModel) {
        return this.formaPagamentoService.saveOne(formaPagamentoModel);
    }

    @PutMapping("/{codigo}")
    public FormaPagamentoModel updateOne(@PathVariable Long codigo, @RequestBody FormaPagamentoModel formaPagamentoModel) {
        return this.formaPagamentoService.updateOne(codigo, formaPagamentoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.formaPagamentoService.deleteOne(codigo);
    }

}
