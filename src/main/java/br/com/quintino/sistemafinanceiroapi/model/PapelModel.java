package br.com.quintino.sistemafinanceiroapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_PAPEL")
public class PapelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "NOME", length = 45, nullable = false)
    private String nome;

    @JsonIgnore
    @ManyToMany(mappedBy = "papelModelList", fetch = FetchType.EAGER)
    private List<PessoaModel> pessoaModelList;

    public PapelModel() { }

    public PapelModel(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PessoaModel> getPessoaModelList() {
        return pessoaModelList;
    }

    public void setPessoaModelList(List<PessoaModel> pessoaModelList) {
        this.pessoaModelList = pessoaModelList;
    }

}
