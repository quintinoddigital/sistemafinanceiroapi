package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_LANCAMENTO_ARQUIVO")
public class LancamentoArquivoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_LANCAMENTO", nullable = false)
    private LancamentoModel lancamentoModel;

    @ManyToOne
    @JoinColumn(name = "ID_ARQUIVO", nullable = false)
    private ArquivoModel arquivoModel;

    public LancamentoArquivoModel() { }

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

    public ArquivoModel getArquivoModel() {
        return arquivoModel;
    }

    public void setArquivoModel(ArquivoModel arquivoModel) {
        this.arquivoModel = arquivoModel;
    }

}
