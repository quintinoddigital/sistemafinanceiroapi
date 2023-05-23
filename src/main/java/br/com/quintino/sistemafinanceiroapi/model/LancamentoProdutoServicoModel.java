package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_LANCAMENTO_PRODUTO_SERVICO")
public class LancamentoProdutoServicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_LANCAMENTO", nullable = false)
    private LancamentoModel lancamentoModel;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO_SERVICO", nullable = false)
    private ProdutoServicoModel produtoServicoModel;

    @Column(name = "VALOR", scale = 9, precision = 2, nullable = false)
    private Double valor;

    public LancamentoProdutoServicoModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public LancamentoModel getLancamentoModel() {
        return lancamentoModel;
    }

    public void setLancamentoModel(LancamentoModel lancamentoModel) {
        this.lancamentoModel = lancamentoModel;
    }

    public ProdutoServicoModel getProdutoServicoModel() {
        return produtoServicoModel;
    }

    public void setProdutoServicoModel(ProdutoServicoModel produtoServicoModel) {
        this.produtoServicoModel = produtoServicoModel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
