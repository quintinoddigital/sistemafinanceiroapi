package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.DocumentoModel;
import br.com.quintino.sistemafinanceiroapi.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping
    public List<DocumentoModel> findAll() {
        return this.documentoService.findAll();
    }

    @PostMapping
    public DocumentoModel saveOne(@RequestBody DocumentoModel documentoModel) {
        return this.documentoService.saveOne(documentoModel);
    }

    @PutMapping("/{codigo}")
    public DocumentoModel updateOne(@PathVariable Long codigo, @RequestBody DocumentoModel documentoModel) {
        return this.documentoService.updateOne(codigo, documentoModel);
    }

    @DeleteMapping("{codigo}")
    public void deleteOne(@PathVariable Long codigo) {
        this.documentoService.deleteOne(codigo);
    }

}
