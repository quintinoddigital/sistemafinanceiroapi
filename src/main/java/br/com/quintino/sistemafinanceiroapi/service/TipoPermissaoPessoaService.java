package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ArquivoModel;
import br.com.quintino.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintino.sistemafinanceiroapi.model.TipoPermissaoPessoaModel;
import br.com.quintino.sistemafinanceiroapi.repository.ArquivoRepository;
import br.com.quintino.sistemafinanceiroapi.repository.PessoaRepository;
import br.com.quintino.sistemafinanceiroapi.repository.TipoPermissaoPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TipoPermissaoPessoaService {

    @Autowired
    private TipoPermissaoPessoaRepository tipoPermissaoPessoaRepository;

    public List<TipoPermissaoPessoaModel> findAll() {
        return this.tipoPermissaoPessoaRepository.findAll();
    }

}
