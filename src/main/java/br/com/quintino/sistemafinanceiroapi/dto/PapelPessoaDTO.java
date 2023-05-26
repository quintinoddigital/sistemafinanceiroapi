package br.com.quintino.sistemafinanceiroapi.dto;

import br.com.quintino.sistemafinanceiroapi.model.PapelModel;

import java.util.ArrayList;
import java.util.List;

public class PapelPessoaDTO {

    private String nomePessoa;

    private List<PapelModel> papelModelList = new ArrayList<>();

    public PapelPessoaDTO() { }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public List<PapelModel> getPapelModelList() {
        return papelModelList;
    }

    public void setPapelModelList(List<PapelModel> papelModelList) {
        this.papelModelList = papelModelList;
    }

}
