package br.com.quintino.sistemafinanceiroapi.dto;

import br.com.quintino.sistemafinanceiroapi.model.PapelModel;

import java.util.List;

public class PapelPessoaDTO {

    private String nomePessoa;

    private String nomePapel;

    public PapelPessoaDTO() { }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getNomePapel() {
        return nomePapel;
    }

    public void setNomePapel(String nomePapel) {
        this.nomePapel = nomePapel;
    }

}
