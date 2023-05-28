package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ARQUIVO_DOCUMENTO")
public class ArquivoDocumentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_ARQUIVO")
    private ArquivoModel arquivoModel;

    @ManyToOne
    @JoinColumn(name = "ID_DOCUMENTO")
    private DocumentoModel documentoModel;

    public ArquivoDocumentoModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public ArquivoModel getArquivoModel() {
        return arquivoModel;
    }

    public void setArquivoModel(ArquivoModel arquivoModel) {
        this.arquivoModel = arquivoModel;
    }

    public DocumentoModel getDocumentoModel() {
        return documentoModel;
    }

    public void setDocumentoModel(DocumentoModel documentoModel) {
        this.documentoModel = documentoModel;
    }

}
