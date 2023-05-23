package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.ArquivoModel;
import br.com.quintino.sistemafinanceiroapi.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arquivo")
public class ArquivoController {

    @Autowired
    private ArquivoService arquivoService;

    @GetMapping
    public List<ArquivoModel> findAll() {
        return this.arquivoService.findAll();
    }

    @PostMapping
    public ArquivoModel saveOne(@RequestBody ArquivoModel arquivoModel) {
        return this.arquivoService.saveOne(arquivoModel);
    }

    @PutMapping("/{codigo}")
    public ArquivoModel updateOne(@PathVariable Long codigo, @RequestBody ArquivoModel arquivoModel) {
        return this.arquivoService.updateOne(codigo, arquivoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.arquivoService.deleteOne(codigo);
    }

}
