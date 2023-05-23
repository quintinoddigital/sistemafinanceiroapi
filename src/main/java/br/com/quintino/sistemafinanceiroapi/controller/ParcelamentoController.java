package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.ParcelamentoModel;
import br.com.quintino.sistemafinanceiroapi.service.ParcelamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcelamento")
public class ParcelamentoController {

    @Autowired
    private ParcelamentoService parcelamentoService;

    @GetMapping
    public List<ParcelamentoModel> findAll() {
        return this.parcelamentoService.findAll();
    }

    @PostMapping
    public ParcelamentoModel saveOne(@RequestBody ParcelamentoModel parcelamentoModel) {
        return this.parcelamentoService.saveOne(parcelamentoModel);
    }

    @PutMapping("/{codigo}")
    public ParcelamentoModel updateOne(@PathVariable Long codigo, @RequestBody ParcelamentoModel parcelamentoModel) {
        return this.parcelamentoService.updateOne(codigo, parcelamentoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.parcelamentoService.deleteOne(codigo);
    }

}
