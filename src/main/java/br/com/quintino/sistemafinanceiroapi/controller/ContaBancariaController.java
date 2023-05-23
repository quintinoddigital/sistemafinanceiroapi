package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.ContaBancariaModel;
import br.com.quintino.sistemafinanceiroapi.service.ContaBancariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conta-bancaria")
public class ContaBancariaController {

    @Autowired
    private ContaBancariaService contaBancariaService;

    @GetMapping
    public List<ContaBancariaModel> findAll() {
        return this.contaBancariaService.findAll();
    }

    @PostMapping
    public ContaBancariaModel saveOne(@RequestBody ContaBancariaModel contaBancariaModel) {
        return this.contaBancariaService.saveOne(contaBancariaModel);
    }

    @PutMapping("/{codigo}")
    public ContaBancariaModel updateOne(@PathVariable Long codigo, @RequestBody ContaBancariaModel contaBancariaModel) {
        return this.contaBancariaService.updateOne(codigo, contaBancariaModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.contaBancariaService.deleteOne(codigo);
    }

}
