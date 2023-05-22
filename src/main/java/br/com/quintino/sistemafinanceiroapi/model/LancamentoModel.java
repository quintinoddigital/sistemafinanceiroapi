package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_LANCAMENTO")
public class LancamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_LANCAMENTO", nullable = false)
    private TipoLancamentoModel tipoLancamentoModel;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_FAVORECIDA", nullable = false)
    private PessoaModel pessoaFavorecida;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_RESPONSAVEL_LANCAMENTO", nullable = false)
    private PessoaModel pessoaResponsavelLancamento;

    @Column(name = "IDENTIFICADOR", nullable = false)
    private String identificacao;

    public LancamentoModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public TipoLancamentoModel getTipoLancamentoModel() {
        return tipoLancamentoModel;
    }

    public void setTipoLancamentoModel(TipoLancamentoModel tipoLancamentoModel) {
        this.tipoLancamentoModel = tipoLancamentoModel;
    }

    public PessoaModel getPessoaFavorecida() {
        return pessoaFavorecida;
    }

    public void setPessoaFavorecida(PessoaModel pessoaFavorecida) {
        this.pessoaFavorecida = pessoaFavorecida;
    }

    public PessoaModel getPessoaResponsavelLancamento() {
        return pessoaResponsavelLancamento;
    }

    public void setPessoaResponsavelLancamento(PessoaModel pessoaResponsavelLancamento) {
        this.pessoaResponsavelLancamento = pessoaResponsavelLancamento;
    }

}
