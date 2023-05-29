package br.com.quintino.sistemafinanceiroapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_PAGAMENTO")
public class PagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_CONTA_BANCARIA", nullable = false)
    private ContaBancariaModel contaBancariaModel;

    @ManyToOne
    @JoinColumn(name = "ID_FORMA_PAGAMENTO", nullable = false)
    private FormaPagamentoModel formaPagamentoModel;

    @JsonFormat(pattern = "dd/mm/YYYY")
    @Column(name = "DATA_PAGAMENTO", nullable = false)
    private Date dataPagamento;

    public PagamentoModel() {}

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public ContaBancariaModel getContaBancariaModel() {
        return contaBancariaModel;
    }

    public void setContaBancariaModel(ContaBancariaModel contaBancariaModel) {
        this.contaBancariaModel = contaBancariaModel;
    }

    public FormaPagamentoModel getFormaPagamentoModel() {
        return formaPagamentoModel;
    }

    public void setFormaPagamentoModel(FormaPagamentoModel formaPagamentoModel) {
        this.formaPagamentoModel = formaPagamentoModel;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

}
