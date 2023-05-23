package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_CONTA_BANCARIA")
public class ContaBancariaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_INSTITUICAO_FINANCEIRA", nullable = false)
    private PessoaModel pessoaInstituicaoFinanceira;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA_TITULAR", nullable = false)
    private PessoaModel pessoaTitular;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ABERTURA", nullable = false)
    private Date dataAbertura;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_FECHAMENTO")
    private Date dataFechamento;

    @Column(name = "SALDO", precision = 9, scale = 2, nullable = false)
    private Double saldo;

    public ContaBancariaModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public PessoaModel getPessoaInstituicaoFinanceira() {
        return pessoaInstituicaoFinanceira;
    }

    public void setPessoaInstituicaoFinanceira(PessoaModel pessoaInstituicaoFinanceira) {
        this.pessoaInstituicaoFinanceira = pessoaInstituicaoFinanceira;
    }

    public PessoaModel getPessoaTitular() {
        return pessoaTitular;
    }

    public void setPessoaTitular(PessoaModel pessoaTitular) {
        this.pessoaTitular = pessoaTitular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}
