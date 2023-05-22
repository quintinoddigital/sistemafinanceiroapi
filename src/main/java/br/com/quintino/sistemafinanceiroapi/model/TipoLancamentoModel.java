package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_TIPO_LANCAMENTO")
public class TipoLancamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "IDENTIFICADOR", nullable = false)
    private String identificacao;
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    public TipoLancamentoModel() { }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
