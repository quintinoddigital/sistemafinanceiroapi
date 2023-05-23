package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.ArquivoModel;
import br.com.quintino.sistemafinanceiroapi.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/upload")
    public ArquivoModel saveOne(@RequestParam("arquivo") MultipartFile multipartFile) {
        return this.arquivoService.saveOne(multipartFile);
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
