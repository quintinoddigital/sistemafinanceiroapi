package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.dto.PapelPessoaDTO;
import br.com.quintino.sistemafinanceiroapi.model.PapelModel;
import br.com.quintino.sistemafinanceiroapi.service.PapelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/papel")
public class PapelController {

    @Autowired
    private PapelService tipoPermissaoPessoaService;

    @GetMapping
    public List<PapelModel> findAll() {
        return this.tipoPermissaoPessoaService.findAll();
    }

    @GetMapping("/pessoa/{codigoPessoa}")
    public PapelPessoaDTO recuperarPapelPessoa(@PathVariable("codigoPessoa") Long codigoPessoa) {
        return this.tipoPermissaoPessoaService.recuperarPapelPessoa(codigoPessoa);
    }

}
