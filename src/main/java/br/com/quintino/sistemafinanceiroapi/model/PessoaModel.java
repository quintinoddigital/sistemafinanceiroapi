package br.com.quintino.sistemafinanceiroapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_PESSOA")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PESSOA", nullable = false)
    private TipoPessoaModel tipoPessoaModel;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoaModel", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE} )
    private List<PermissaoPessoaModel> permissaoPessoaModelList;

    @Column(name = "NOME", nullable = false)
    private String nome;

    public PessoaModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoPessoaModel getTipoPessoaModel() {
        return tipoPessoaModel;
    }

    public void setTipoPessoaModel(TipoPessoaModel tipoPessoaModel) {
        this.tipoPessoaModel = tipoPessoaModel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PermissaoPessoaModel> getPermissaoPessoaModelList() {
        return permissaoPessoaModelList;
    }

    public void setPermissaoPessoaModelList(List<PermissaoPessoaModel> permissaoPessoaModelList) {
        for (PermissaoPessoaModel permissaoPessoaModel : permissaoPessoaModelList) {
            permissaoPessoaModel.setPessoaModel(this);
        }
        this.permissaoPessoaModelList = permissaoPessoaModelList;
    }

}
