package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintino.sistemafinanceiroapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<PessoaModel> findAll() {
        return this.pessoaService.findAll();
    }

    @PostMapping
    public PessoaModel saveOne(@RequestBody PessoaModel pessoaModel) {
        return this.pessoaService.saveOne(pessoaModel);
    }

    @PutMapping("/{codigo}")
    public PessoaModel updateOne(@PathVariable Long codigo, @RequestBody PessoaModel pessoaModel) {
        return this.pessoaService.updateOne(codigo, pessoaModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.pessoaService.deleteOne(codigo);
    }

}
