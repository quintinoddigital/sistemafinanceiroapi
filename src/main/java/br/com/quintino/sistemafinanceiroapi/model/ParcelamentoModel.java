package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_PARCELAMENTO")
public class ParcelamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_PAGAMENTO", nullable = false)
    private PagamentoModel pagamentoModel;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @Column(name = "VALOR", scale = 9, precision = 2, nullable = false)
    private Double valor;

    public ParcelamentoModel() {}

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public PagamentoModel getPagamentoModel() {
        return pagamentoModel;
    }

    public void setPagamentoModel(PagamentoModel pagamentoModel) {
        this.pagamentoModel = pagamentoModel;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
