package br.com.quintino.sistemafinanceiroapi.controller;

import br.com.quintino.sistemafinanceiroapi.model.TipoPermissaoPessoaModel;
import br.com.quintino.sistemafinanceiroapi.service.TipoPermissaoPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-permissao-pessoa")
public class TipoPermissaoControllerController {

    @Autowired
    private TipoPermissaoPessoaService tipoPermissaoPessoaService;

    @GetMapping
    public List<TipoPermissaoPessoaModel> findAll() {
        return this.tipoPermissaoPessoaService.findAll();
    }

}
