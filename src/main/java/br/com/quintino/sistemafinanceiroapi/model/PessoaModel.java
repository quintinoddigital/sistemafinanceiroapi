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

//    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TB_PAPEL_PESSOA",
            joinColumns = @JoinColumn(name = "ID_PAPEL"),
            inverseJoinColumns = @JoinColumn(name = "ID_PESSOA")
    )
    private List<PapelModel> papelModelList;

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

    public List<PapelModel> getPapelModelList() {
        return papelModelList;
    }

    public void setPapelModelList(List<PapelModel> papelModelList) {
        this.papelModelList = papelModelList;
    }

//    public void setPermissaoPessoaModelList(List<PessoaPapelModel> permissaoPessoaModelList) {
//        for (PessoaPapelModel permissaoPessoaModel : permissaoPessoaModelList) {
//            permissaoPessoaModel.setPessoaModel(this);
//        }
//        this.permissaoPessoaModelList = permissaoPessoaModelList;
//    }

}
