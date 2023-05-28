package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PESSOA_DOCUMENTO")
public class PessoaDocumentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private PessoaModel pessoaModel;

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO")
    private DocumentoModel documentoModel;

    public PessoaDocumentoModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public DocumentoModel getDocumentoModel() {
        return documentoModel;
    }

    public void setDocumentoModel(DocumentoModel documentoModel) {
        this.documentoModel = documentoModel;
    }

    public PessoaModel getPessoaModel() {
        return pessoaModel;
    }

    public void setPessoaModel(PessoaModel pessoaModel) {
        this.pessoaModel = pessoaModel;
    }

}
