package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PESSOA_PAPEL")
public class PessoaPapelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "ID_PAPEL")
    private PapelModel papelModel;

    @ManyToOne
    @JoinColumn(name = "ID_PESSOA")
    private PessoaModel pessoaModel;

    public PessoaPapelModel() { }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public PapelModel getPapelModel() {
        return papelModel;
    }

    public void setPapelModel(PapelModel papelModel) {
        this.papelModel = papelModel;
    }

    public PessoaModel getPessoaModel() {
        return pessoaModel;
    }

    public void setPessoaModel(PessoaModel pessoaModel) {
        this.pessoaModel = pessoaModel;
    }

}
