package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_DOCUMENTO")
public class DocumentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_DOCUMENTO")
    private TipoDocumentoModel tipoDocumentoModel;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private PessoaModel pessoaModel;

    @Transient
    private List<ArquivoModel> arquivoModelList;

    @Column(name = "NUMERO", nullable = false)
    private String numero;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_EMISSAO", nullable = false)
    private Date dataEmissao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_VENCIMENTO", nullable = false)
    private Date dataVencimento;

    @Column(name = "IS_ATIVO", nullable = false)
    private Boolean isAtivo;

    public DocumentoModel() {
        this.isAtivo = true;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public TipoDocumentoModel getTipoDocumentoModel() {
        return tipoDocumentoModel;
    }

    public void setTipoDocumentoModel(TipoDocumentoModel tipoDocumentoModel) {
        this.tipoDocumentoModel = tipoDocumentoModel;
    }

    public PessoaModel getPessoaModel() {
        return pessoaModel;
    }

    public void setPessoaModel(PessoaModel pessoaModel) {
        this.pessoaModel = pessoaModel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public List<ArquivoModel> getArquivoModelList() {
        return arquivoModelList;
    }

    public void setArquivoModelList(List<ArquivoModel> arquivoModelList) {
        this.arquivoModelList = arquivoModelList;
    }

}
