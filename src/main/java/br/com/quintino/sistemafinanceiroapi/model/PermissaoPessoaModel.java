package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_PERMISSAO_PESSOA")
public class PermissaoPessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PERMISSAO_PESSOA")
    private TipoPermissaoPessoaModel tipoPermissaoPessoaModel;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private PessoaModel pessoaModel;

    public PermissaoPessoaModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoPermissaoPessoaModel getTipoPermissaoPessoaModel() {
        return tipoPermissaoPessoaModel;
    }

    public void setTipoPermissaoPessoaModel(TipoPermissaoPessoaModel tipoPermissaoPessoaModel) {
        this.tipoPermissaoPessoaModel = tipoPermissaoPessoaModel;
    }

    public PessoaModel getPessoaModel() {
        return pessoaModel;
    }

    public void setPessoaModel(PessoaModel pessoaModel) {
        this.pessoaModel = pessoaModel;
    }

}
