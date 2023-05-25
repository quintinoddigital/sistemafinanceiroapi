package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.PapelModel;
import br.com.quintino.sistemafinanceiroapi.repository.PapelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPermissaoPessoaService {

    @Autowired
    private PapelRepository tipoPermissaoPessoaRepository;

    public List<PapelModel> findAll() {
        return this.tipoPermissaoPessoaRepository.findAll();
    }

}
