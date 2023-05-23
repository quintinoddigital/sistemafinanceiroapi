package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_LANCAMENTO_PAGAMENTO")
public class LancamentoPagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_LANCAMENTO", nullable = false)
    private LancamentoModel lancamentoModel;

    @ManyToOne
    @JoinColumn(name = "ID_PAGAMENTO", nullable = false)
    private PagamentoModel pagamentoModel;

    @Column(name = "VALOR", scale = 9, precision = 2, nullable = false)
    private Double valor;

    public LancamentoPagamentoModel() {}

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

    public PagamentoModel getPagamentoModel() {
        return pagamentoModel;
    }

    public void setPagamentoModel(PagamentoModel pagamentoModel) {
        this.pagamentoModel = pagamentoModel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
