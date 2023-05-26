package br.com.quintino.sistemafinanceiroapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PAPEL")
public class PapelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO", nullable = false)
    private Long codigo;

    @Column(name = "NOME", length = 45, nullable = false)
    private String nome;

    public PapelModel() { }

    public PapelModel(String nome) {
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
